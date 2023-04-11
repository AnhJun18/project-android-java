package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainDemoSpinner extends AppCompatActivity {
    EditText edtHT, edtSDT, edtNgay, edtGio;
    AutoCompleteTextView atvTinh;
    Spinner spPhuongTien;
    String []data_Tinh = {"Hà Nội","Hà Tĩnh","Đà Nẵng","TP.HCM"};
    ArrayAdapter adapter_tinh;
    ArrayList<String> data_PhuongTien = new ArrayList<>();
    ArrayAdapter adapter_PhuongTien;
    Button btnDangKy, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo_spinner);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        khoiTao();
        adapter_PhuongTien = new ArrayAdapter(this,
                android.R.layout.simple_list_item_activated_1, data_PhuongTien);
        spPhuongTien.setAdapter(adapter_PhuongTien);

        adapter_tinh= new ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,data_Tinh);
        atvTinh.setAdapter(adapter_tinh);

        edtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgay();
            }
        });
        edtGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonGio();
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg="";
                msg+="Họ tên: "+ edtHT.getText()+"\n";
                msg+="SĐT: "+ edtSDT.getText()+"\n";
                msg+="Tỉnh: "+ atvTinh.getText()+"\n";
                msg+="Ngày: "+ edtNgay.getText()+"\n";
                msg+="Giờ: "+ edtGio.getText()+"\n";
                msg+="Phương Tiện: "+ spPhuongTien.getSelectedItem()+"\n";

                Toast.makeText(MainDemoSpinner.this,msg,Toast.LENGTH_SHORT);
                DangKy(msg);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongBao();
            }
        });
    }
    private void ThongBao(){
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);
        thongbao.setMessage("Xac nhan thoat?");
        thongbao.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        thongbao.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        thongbao.show();
    }
    private void DangKy(String msg){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_thongtin);
        EditText edtThongTin = dialog.findViewById(R.id.edtThongTin);
        Button btnDK = dialog.findViewById(R.id.btnDangKy);
        edtThongTin.setText(msg);
        dialog.show();
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    private void chonGio(){
        Calendar calendar = Calendar.getInstance();
        int gio= calendar.get(Calendar.HOUR);
        int phut= calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm");
                calendar.set(0,0,0,i,i1);
                edtGio.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },gio,phut,true);
        timePickerDialog.show();

    }

    private void chonNgay() {
        Calendar calendar = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH);
        int ngay = calendar.get(Calendar.DATE);
        DatePickerDialog pickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                calendar.set(i,i1,i2);
                edtNgay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        pickerDialog.show();
    }

    private void khoiTao() {
        data_PhuongTien.add("Máy Bay");
        data_PhuongTien.add("Xe Khách");
        data_PhuongTien.add("Tàu Hỏa");

    }

    private void setConTrol() {
        edtHT = findViewById(R.id.edtHT);
        edtSDT = findViewById(R.id.edtSDT);
        edtNgay = findViewById(R.id.edtNgay);
        edtGio = findViewById(R.id.edtGio);
        atvTinh = findViewById(R.id.atvTinh);
        spPhuongTien = findViewById(R.id.spPhuongTien);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnThoat = findViewById(R.id.btnThoat);
    }
}