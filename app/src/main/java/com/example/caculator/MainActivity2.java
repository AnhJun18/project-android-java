package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

    ImageView imgView;
    Button btnLogout, btnLogin;
    EditText edtPass, edtUserName;
    CheckBox cbSavePass;
    FloatingActionButton fabSitting,fabTiengViet;
    boolean sitting;

    SharedPreferences sharedPreferences;// lưu thông tin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setControl();
        setEvent();
    }

    private void setEvent() {
        sharedPreferences = getSharedPreferences("matkhau",MODE_PRIVATE);
        readPass();
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                HieuUngHinh();
                if(cbSavePass.isChecked())
                    savePass();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().commit();
                Toast.makeText(MainActivity2.this,"Đã đăng xuất",Toast.LENGTH_SHORT).show();

            }
        });
        fabSitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sitting){
                    hideSitting();
                }
                else{
                    showSitting();

                }
                sitting=!sitting;
            }
        });
        fabTiengViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,"Setting....",Toast.LENGTH_SHORT).show();
                fabTiengViet.hide();
            }
        });
    }

    private void showSitting() {
        fabTiengViet.animate().translationX(-200);
        fabTiengViet.animate().translationY(-200);
        fabTiengViet.show();
    }

    private void hideSitting() {
        fabTiengViet.animate().translationX(0);
        fabTiengViet.animate().translationY(0);
        fabTiengViet.show();
    }

    private void HieuUngHinh() {
       String url="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/04/Anh-cute.jpg?resize=560%2C560&ssl=1";
        Picasso.get().load(url).into(imgView);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.hinh);

        imgView.startAnimation(animation);
    }

    private void savePass() {
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("username", edtUserName.getText().toString());
        editor.putString("password", edtPass.getText().toString());
        editor.commit();

    }

    private void readPass() {
        edtUserName.setText(sharedPreferences.getString("username",""));
        edtPass.setText(sharedPreferences.getString("password",""));


    }
    private void setControl() {
        imgView = findViewById(R.id.imgView);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPass);
        edtUserName = findViewById(R.id.edtUserName);
        cbSavePass = findViewById(R.id.cbSavePass);
        fabSitting=findViewById(R.id.fabSitting);
        fabTiengViet=findViewById(R.id.fabTiengViet);
    }
}