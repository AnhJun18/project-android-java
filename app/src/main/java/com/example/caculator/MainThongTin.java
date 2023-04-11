package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainThongTin extends AppCompatActivity {

    EditText txtTK,txtMK,txtNS,txtEmail;
    Button btnDK;
    TextView twInfor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thong_tin);
        setControl();
        setEvent();

    }

    private void setEvent() {
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg="Thong tin tai khoan \n";
                msg+="Tai Khoan: "+txtTK.getText().toString()+"\n";
                msg+="Mat Khau: "+txtMK.getText().toString()+"\n";
                msg+="Ngay Sinh: "+txtNS.getText().toString()+"\n";
                msg+="Email: "+txtEmail.getText().toString()+"\n";
                twInfor.setText(msg);
            }
        });
    }

    private void setControl() {
        txtTK= findViewById(R.id.txtTK);
        txtMK= findViewById(R.id.txtMK);
        txtNS= findViewById(R.id.txtNS);
        txtEmail= findViewById(R.id.txtEmail);
        btnDK= findViewById(R.id.btnDK);
        twInfor=findViewById(R.id.twInfor);

    }
}