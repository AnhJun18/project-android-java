package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainListView extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<SinhVien> data_Sv = new ArrayList<>();
    SinhVien sv;
    CustomAdapterSinhVien adapterSV;
    EditText edt_MaSV, edt_TenSV, edt_NgaySinh;
    RadioButton rad_Nam, rad_Nu;
    Button btn_Them, btn_Sua, btn_Xoa, btn_Thoat;
    SearchView searchView;
    Button btnCheckAll, btnUnCheckAll, btnXoaDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);
        setControl();
        setEvent();

    }

    private void setEvent() {
        KhoiTao();
        adapterSV = new CustomAdapterSinhVien(this, R.layout.layout_item_sinhvien, data_Sv);
        lvDanhSach.setAdapter(adapterSV);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sv = data_Sv.get(i);
                Toast.makeText(MainListView.this, "Chọn " + sv.getHoTen(), Toast.LENGTH_SHORT);
                ChonDL();
            }
        });
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                data_Sv.remove(i);
                adapterSV.notifyDataSetChanged();
                ;
                return false;
            }
        });
        btn_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemData();
            }
        });
        btn_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_Sv.remove(sv);
                adapterSV.notifyDataSetChanged();
            }
        });
        btn_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setMaSV(edt_MaSV.getText().toString());
                sv.setHoTen(edt_TenSV.getText().toString());
                sv.setNgaySinh(edt_NgaySinh.getText().toString());
                sv.setGioiTinh(rad_Nam.isChecked());
                adapterSV.notifyDataSetChanged();
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnXoaDuLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterSV.XoaDuLieu();
            }
        });

        btnCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterSV.CheckAll();
            }
        });
        btnUnCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterSV.UnCheckAll();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterSV.searchSV(s);
                return false;
            }
        });
    }
    private void ChonDL() {
        edt_MaSV.setText(sv.getMaSV());
        edt_TenSV.setText(sv.getHoTen());
        edt_NgaySinh.setText(sv.getNgaySinh());
        if(sv.isGioiTinh())
            rad_Nam.setChecked(true);
        else
            rad_Nu.setChecked(true);

    }
    private void ThemData() {
        SinhVien sVien = new SinhVien();
        sVien.setMaSV(edt_MaSV.getText().toString());
        sVien.setHoTen(edt_TenSV.getText().toString());
        sVien.setNgaySinh(edt_NgaySinh.getText().toString());
        sVien.setGioiTinh(rad_Nam.isChecked());
        data_Sv.add(sVien);
        adapterSV.notifyDataSetChanged();
    }

    private void KhoiTao() {
        data_Sv.add(new SinhVien("001", "Nguyễn Văn A", "12/02/2002", true));
        data_Sv.add(new SinhVien("002", "Nguyễn Văn B", "12/02/2002", false));
        data_Sv.add(new SinhVien("003", "Nguyễn Văn C", "12/02/2002", true));
    }

    private void setControl() {

        lvDanhSach = findViewById(R.id.lvDanhsach);
        btn_Them = findViewById(R.id.btn_Them);
        btn_Sua = findViewById(R.id.btn_Sua);
        btn_Xoa = findViewById(R.id.btn_Xoa);
        btn_Thoat = findViewById(R.id.btn_Thoat);
        edt_MaSV = findViewById(R.id.edt_MaSV);
        edt_TenSV = findViewById(R.id.edt_TenSV);
        edt_NgaySinh = findViewById(R.id.edt_NgaySinh);
        rad_Nam = findViewById(R.id.rad_Nam);
        rad_Nu = findViewById(R.id.rad_Nu);
        searchView = findViewById(R.id.seacrch_SV);
        btnCheckAll=findViewById(R.id.btnCheckAll);;
        btnUnCheckAll=findViewById(R.id.btnUnCheckAll);
        btnXoaDuLieu=findViewById(R.id.btnXoaDuLieu);
    }

}