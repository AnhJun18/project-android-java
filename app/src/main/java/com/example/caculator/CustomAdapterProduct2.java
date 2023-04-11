package com.example.caculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterProduct2 extends ArrayAdapter<Product> {
    Context context;
    int resource;
    ArrayList<Product> data;

    public CustomAdapterProduct2(@NonNull Context context, int resource, @NonNull ArrayList<Product> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomAdapterProduct2.ViewHorder viewHorder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewHorder = new CustomAdapterProduct2.ViewHorder(convertView);
            convertView.setTag(viewHorder);
        } else {
            viewHorder = (CustomAdapterProduct2.ViewHorder) convertView.getTag();
        }
        Product pr = data.get(position);
        Picasso.get().load(pr.urlImg).into(viewHorder.ivProduct);
        viewHorder.txtPrice.setText(pr.name);

        return convertView;
    }

    private class ViewHorder {
        ImageView ivProduct;
        TextView txtPrice;


        public ViewHorder(View view) {
            ivProduct = view.findViewById(R.id.ivProduct);
            txtPrice = view.findViewById(R.id.txtPrice);

        }
    }


}
