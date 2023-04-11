package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivitySQL extends AppCompatActivity {
    EditText edtMaSP,edtTenSP,edtSoLuong;
    Button btnThem,btnXoa,btnSua,btnHienThi;
    ListView lvDSSP;
    ArrayList<SanPham> data_sp= new ArrayList<>();
    ArrayAdapter adapter_sp;
    DBSanPham dbSanPham;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_s_q_l);
        setControl();
        setEvent();
        
    }

    private void setEvent() {
        dbSanPham = new DBSanPham(this);
        adapter_sp= new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_sp);
        lvDSSP.setAdapter(adapter_sp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemDL();
            }
        });
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XoaDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuaDL();
            }
        });
    }

    private void HienThiDL() {
        data_sp.clear();
        data_sp.addAll((dbSanPham.hienThiDuLieu()));
        adapter_sp.notifyDataSetChanged();
    }

    private void ThemDL() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(edtMaSP.getText().toString());
        sanPham.setTenSP(edtTenSP.getText().toString());
        sanPham.setSoluong(edtSoLuong.getText().toString());
        dbSanPham.ThemDL(sanPham);
    }
    private void XoaDL() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(edtMaSP.getText().toString());
        dbSanPham.XoaDL(sanPham);
        HienThiDL();
    }

    private void SuaDL() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(edtMaSP.getText().toString());
        sanPham.setTenSP(edtTenSP.getText().toString());
        sanPham.setSoluong(edtSoLuong.getText().toString());
        dbSanPham.SuaDL(sanPham);
        HienThiDL();

    }



    private void setControl() {
        edtMaSP=findViewById(R.id.edtMaSP);
        edtTenSP=findViewById(R.id.edtTenSP);
        edtSoLuong=findViewById(R.id.edtSoLuong);
        btnThem=findViewById(R.id.btnThem);
        btnXoa=findViewById(R.id.btnXoa);
        btnSua=findViewById(R.id.btnSua);
        lvDSSP=findViewById(R.id.lvDSSP);
        btnHienThi=findViewById(R.id.btnHienThi);
    }
    
}