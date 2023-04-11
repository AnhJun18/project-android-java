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

import java.util.ArrayList;

public class CustomAdapterSinhVien extends ArrayAdapter<SinhVien> {
    Context context;
    int resource;
    ArrayList<SinhVien> data;
    ArrayList<SinhVien> data_tmp = new ArrayList<>();
    CheckBox checkBox;


    public CustomAdapterSinhVien(@NonNull Context context, int resource, @NonNull ArrayList<SinhVien> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
        data_tmp.addAll(data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHorder viewHorder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewHorder = new ViewHorder(convertView);
            convertView.setTag(viewHorder);
        } else {
            viewHorder = (ViewHorder) convertView.getTag();
        }

        SinhVien sv = data.get(position);
        viewHorder.tvHoTen.setText((sv.getHoTen()));
        if (sv.isGioiTinh())
            viewHorder.ivGioiTinh.setImageResource(R.drawable.ic_baseline_boy_24);
        else
            viewHorder.ivGioiTinh.setImageResource(R.drawable.ic_baseline_pregnant_woman_24);

        viewHorder.ivDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainDetail.class);
                intent.putExtra("msg",sv);
                context.startActivity(intent);
            }
        });

        viewHorder.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0912684797"));
                context.startActivity(intent);
            }
        });
        viewHorder.ivMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:0912684797"));
                intent.putExtra("sms_body","Thông báo "+sv.getHoTen() );
                context.startActivity(intent);
            }
        });
        if(sv.isSelect())
            viewHorder.checkBox.setChecked(true);
        else
            viewHorder.checkBox.setChecked(false);

        viewHorder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sv.setSelect(b);
            }
        });
        return convertView;
    }

    private class ViewHorder {
        TextView tvHoTen;
        ImageView ivGioiTinh;
        ImageView ivDetail;
        ImageView ivPhone;
        ImageView ivMessage;
        CheckBox checkBox;

        public ViewHorder(View view) {
            tvHoTen = view.findViewById(R.id.tvHoTen);
            ivGioiTinh = view.findViewById(R.id.ivGioiTinh);
            ivDetail = view.findViewById(R.id.ivDetail);
            ivMessage = view.findViewById(R.id.ivMessage);
            ivPhone = view.findViewById(R.id.ivPhone);
            checkBox = view.findViewById(R.id.cbSelected);
        }
    }
    public  void searchSV(String query){
        data.clear();
        if(query==""){
            data.addAll(data_tmp);
        }
        for (SinhVien sv:data_tmp) {
            if(sv.getHoTen().contains(query))
                data.add(sv);
        }
        notifyDataSetChanged();
    }
    public  void XoaDuLieu(){
        data_tmp.clear();
        data_tmp.addAll(data);
        data.clear();
        for (SinhVien sv:data_tmp ) {
            if(!sv.isSelect())
                data.add(sv);
        }
        notifyDataSetChanged();
        data_tmp.clear();
        data_tmp.addAll(data);
    }
    public void CheckAll(){
        for ( SinhVien sv:data      ) {
            sv.setSelect(true);
        }
        notifyDataSetChanged();
    }

    public void UnCheckAll(){
        for ( SinhVien sv:data      ) {
            sv.setSelect(false);
        }
        notifyDataSetChanged();
    }
}
