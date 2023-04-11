package com.example.caculator;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterProduct extends RecyclerView.Adapter<CustomAdapterProduct.ViewHolder> {

    private ArrayList<Product> data_product;
    Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtPrice;
        private final ImageView ivProduct;

        public ViewHolder(View view) {
            super(view);

            txtPrice = view.findViewById(R.id.txtPrice);
            ivProduct = view.findViewById(R.id.ivProduct);


        }

        public TextView getTxtPrice() {
            return txtPrice;
        }
        public ImageView getivProduct() {
            return ivProduct;
        }
    }


    public CustomAdapterProduct(ArrayList<Product> dataSet,@NonNull Context context) {
        this.data_product = dataSet;
        this.context = context;


    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item\
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_item_product, null);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Product pr=data_product.get(position);

        viewHolder.getTxtPrice().setText(pr.name);
        Picasso.get().load(pr.urlImg).into(viewHolder.getivProduct());

        viewHolder.ivProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainProductDetail.class);
                intent.putExtra("product_selected", pr);
                context.startActivity(intent);

//                Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.activity_main_product_detail);
//                ImageView im = dialog.findViewById(R.id.ivSP);
//                Picasso.get().load(pr.urlImg).into(im);
//                dialog.show();

            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return data_product.size();
    }
}
