package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView tvKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pheptinh);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kq= Integer.parseInt(txt1.getText().toString())+Integer.parseInt(txt2.getText().toString());
                tvKq.setText(String.valueOf(kq));
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kq= Integer.parseInt(txt1.getText().toString())-Integer.parseInt(txt2.getText().toString());
                tvKq.setText(String.valueOf(kq));
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kq= Integer.parseInt(txt1.getText().toString())*Integer.parseInt(txt2.getText().toString());
                tvKq.setText(String.valueOf(kq));
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kq= Integer.parseInt(txt1.getText().toString())/Integer.parseInt(txt2.getText().toString());
                tvKq.setText(String.valueOf(kq));
            }
        });
    }

    private void setControl() {
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        btnCong=findViewById(R.id.btnCong);
        btnTru=findViewById(R.id.btnTru);
        btnNhan=findViewById(R.id.btnNhan);
        btnChia=findViewById(R.id.btnChia);
        tvKq=findViewById(R.id.tvKq);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ptit","onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ptit","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ptit","onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ptit","onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ptit","onResume");

    }
}