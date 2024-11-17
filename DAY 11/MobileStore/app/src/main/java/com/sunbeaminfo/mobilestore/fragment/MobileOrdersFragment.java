package com.sunbeaminfo.mobilestore.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.adapter.MobileListAdapter;
import com.sunbeaminfo.mobilestore.entity.Mobile;
import com.sunbeaminfo.mobilestore.utils.Constants;
import com.sunbeaminfo.mobilestore.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileOrdersFragment extends Fragment {

    RecyclerView recyclerView;
    List<Mobile> mobileList;

    MobileListAdapter mobileListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        mobileList = new ArrayList<>();
        mobileListAdapter = new MobileListAdapter(getContext(),mobileList);
        recyclerView.setAdapter(mobileListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
    }

    @Override
    public void onStart() {
        getAllOrders();
        super.onStart();
    }

    private void getAllOrders(){
        int uid = getContext().getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
                .getInt(Constants.USER_ID,0);
        RetrofitClient.getInstance().getApi().getAllOrders(uid).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().get("status").getAsString().equals("success")){
                    JsonArray array = response.body().getAsJsonArray("data");
                    mobileList.clear();
                    for(JsonElement element : array){
                        JsonObject object = element.getAsJsonObject();
                        Mobile mobile = new Mobile();
                        mobile.setId(object.get("id").getAsInt());
                        mobile.setName(object.get("name").getAsString());
                        mobile.setRam(object.get("ram").getAsInt());
                        mobile.setStorage(object.get("storage").getAsInt());
                        mobile.setCompany(object.get("company").getAsString());
                        mobile.setPrice(object.get("price").getAsDouble());
                        mobile.setImage(object.get("image").getAsString());
                        mobileList.add(mobile);
                    }
                    mobileListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(getContext(), "Something Went Wrong..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}