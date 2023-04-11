package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainDemoImage extends AppCompatActivity {
   ToggleButton toggle;
   Switch switchQuat;
   ImageView imQuat,imDen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo_image);
        setControl();
        setEvent();
    }

    private void setEvent() {
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle.isChecked()){
                    imDen.setImageResource(R.drawable.i2);
                    Toast.makeText(MainDemoImage.this,"Đèn bật",Toast.LENGTH_SHORT);
                }else{
                    imDen.setImageResource(R.drawable.i1);
                    Toast.makeText(MainDemoImage.this,"Đèn tắt",Toast.LENGTH_SHORT);

                }
            }
        });
        switchQuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchQuat.isChecked()){
                    imQuat.setImageResource(R.drawable.quat2);
                    Toast.makeText(MainDemoImage.this,"Đèn bật",Toast.LENGTH_SHORT);
                }else{
                    imQuat.setImageResource(R.drawable.quat1);
                    Toast.makeText(MainDemoImage.this,"Đèn tắt",Toast.LENGTH_SHORT);

                }
            }
        });
    }

    private void setControl() {
        toggle=findViewById(R.id.toggle);
        switchQuat=findViewById(R.id.switchQuat);
        imQuat=findViewById(R.id.imQuat);
        imDen=findViewById(R.id.imDen);

    }
}