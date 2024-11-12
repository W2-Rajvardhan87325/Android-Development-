package com.sunbeaminfo.adminapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeaminfo.adminapp.R;
import com.sunbeaminfo.adminapp.activity.ProductAddEditActivity;
import com.sunbeaminfo.adminapp.entity.Product;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Context context;
    List<Product> productList;

    public interface DeleteListner{
        void deleteProduct(Product product);
    }
    private DeleteListner deleteListner;

    public ProductAdapter(Context context, List<Product> productList,DeleteListner deleteListner) {
        this.context = context;
        this.productList = productList;
        this.deleteListner = deleteListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_product,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textName.setText(product.getName());
        holder.textPrice.setText("RS - "+product.getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textName,textPrice;
        ImageView imageEdit,imageDelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            imageEdit = itemView.findViewById(R.id.imageEdit);
            imageDelete = itemView.findViewById(R.id.imageDelete);
            imageEdit.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProductAddEditActivity.class);
                intent.putExtra("product",productList.get(getAdapterPosition()));
                context.startActivity(intent);
            });

            imageDelete.setOnClickListener(v ->deleteListner.deleteProduct(productList.get(getAdapterPosition())));
        }
    }
}
