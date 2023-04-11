package com.example.caculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainDetail extends AppCompatActivity {
    ImageView ivGioiTinh;
    EditText edtMaSV, edtTenSV, edtNgaySinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        setControl();
        setEvent();
        //show icon back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setEvent() {
        SinhVien sv = (SinhVien) getIntent().getSerializableExtra("msg");
        Toast.makeText(this,sv.getMaSV(),Toast.LENGTH_LONG).show();
        edtMaSV.setText(sv.getMaSV());
        edtNgaySinh.setText(sv.getNgaySinh());
        edtTenSV.setText(sv.getHoTen());
        if (sv.isGioiTinh())
            ivGioiTinh.setImageResource(R.drawable.ic_baseline_boy_24);
        else
            ivGioiTinh.setImageResource(R.drawable.ic_baseline_pregnant_woman_24);
    }

    private void setControl() {
        ivGioiTinh = findViewById(R.id.ivGioiTinh);
        edtMaSV = findViewById(R.id.edtMaSV);
        edtTenSV = findViewById(R.id.edtTenSV);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sinhvien,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.mmThongBao:
                Toast.makeText(this,"Thông báo",Toast.LENGTH_LONG).show();
                break;
            case  android.R.id.home:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}