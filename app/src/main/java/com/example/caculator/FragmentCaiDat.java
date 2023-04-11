package com.example.caculator;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;


public class FragmentCaiDat extends Fragment {

    SeekBar seekBar;
    Button btnCaiDat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cai_dat, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            Toast.makeText(getContext(),""+i,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
    btnCaiDat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ProgressDialog progressDialog= new ProgressDialog(getContext());
            progressDialog.setTitle("cai dat");
            progressDialog.setMessage("Dang thiet lap");
            progressDialog.show();
            progressDialog.setCancelable(false);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    progressDialog.dismiss();
                }
            }).start();
        }
    });
    }


    private void setControl(View view) {
    seekBar= view.findViewById(R.id.seekBar);
    btnCaiDat= view.findViewById(R.id.btnCaiDat);
    }
}