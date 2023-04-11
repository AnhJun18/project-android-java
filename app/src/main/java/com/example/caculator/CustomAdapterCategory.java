package com.example.caculator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterCategory extends ArrayAdapter<String> {
    Context context;
    int resource;
    ArrayList<String> data;

    public CustomAdapterCategory(@NonNull Context context, int resource, @NonNull ArrayList<String> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomAdapterCategory.ViewHorder viewHorder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewHorder = new CustomAdapterCategory.ViewHorder(convertView);
            convertView.setTag(viewHorder);
        } else {
            viewHorder = (CustomAdapterCategory.ViewHorder) convertView.getTag();
        }
        String link = data.get(position);
        Picasso.get().load(link).into(viewHorder.ivCategory);

        return convertView;
    }

    private class ViewHorder {
        ImageView ivCategory;


        public ViewHorder(View view) {
            ivCategory = view.findViewById(R.id.ivCategory);
        }
    }


}
