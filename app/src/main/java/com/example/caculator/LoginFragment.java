package com.example.caculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class LoginFragment extends Fragment {
    EditText userName, pass;
    Button btnLogin;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                CountDownTimer countDownTimer= new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long l) {
                        int value=progressBar.getProgress()+10;
                        progressBar.setProgress(value);
                    }

                    @Override
                    public void onFinish() {

                        if(userName.getText().toString().equals("admin")
                                && pass.getText().toString().equals("123"))
                            Toast.makeText(getContext(),"Đăng nhâpp thanh cong",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getContext(),"Sai thông tin",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);

                    }
                }.start();
            }
        });
    }

    private void setControl(View view) {
        userName = view.findViewById(R.id.edtUser);
        pass = view.findViewById(R.id.edtPass);
        btnLogin = view.findViewById(R.id.btnDangNhap);
        progressBar = view.findViewById(R.id.progressBar);
    }

}