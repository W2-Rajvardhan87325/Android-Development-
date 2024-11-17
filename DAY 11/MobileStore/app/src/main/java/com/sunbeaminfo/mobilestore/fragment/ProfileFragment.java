package com.sunbeaminfo.mobilestore.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.utils.Constants;
import com.sunbeaminfo.mobilestore.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {
    TextView textName,textEmail,textMobile,textLogout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textName = view.findViewById(R.id.textName);
        textEmail = view.findViewById(R.id.textEmail);
        textMobile = view.findViewById(R.id.textMobile);
        textLogout = view.findViewById(R.id.textLogout);
        getUserById();
        textLogout.setOnClickListener(v -> {
            getContext()
                    .getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .putBoolean(Constants.LOGIN_STATUS,false)
                    .apply();

            getActivity().finish();
        });
    }

    private void getUserById(){
      int id = getContext()
              .getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME,Context.MODE_PRIVATE)
              .getInt(Constants.USER_ID,0);

        RetrofitClient.getInstance().getApi().getUserById(id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().get("status").getAsString().equals("success")){
                    JsonObject jsonObject = response.body().getAsJsonObject("data");
                    textName.setText(jsonObject.get("name").getAsString());
                    textEmail.setText(jsonObject.get("email").getAsString());
                    textMobile.setText(jsonObject.get("mobile").getAsString());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}