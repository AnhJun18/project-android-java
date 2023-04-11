package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainThongTinCaNhan extends AppCompatActivity {
    EditText edtCMND, edtHoTen, edtTTK;
    RadioButton radDaiHoc, radCaoDang, radTrungCap;
    CheckBox cbGame, cbSach, cbDocBao;
    Button btnSend;
    TextView twResult;
    RadioGroup rgBangCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thong_tin_ca_nhan);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtHoTen.getText().length() <= 3) {
                    edtHoTen.selectAll();
                    edtHoTen.requestFocus();
                    edtHoTen.setError("Nhập họ tên phải lớn hơn 3 ký tự");
                    return;
                }
                if (edtCMND.getText().length() <= 10) {
                    edtCMND.selectAll();
                    edtCMND.requestFocus();
                    edtCMND.setError("CMND phải lớn hơn 12 ký tự");
                    return;
                }
                String msg = "Thong tin tai khoan \n";
                msg += "Họ Tên: " + edtHoTen.getText().toString() + "\n";
                msg += "CMND : " + edtCMND.getText().toString() + "\n";
                int selectedRadioButtonId = rgBangCap.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedText = selectedRadioButton.getText().toString();
                    msg += "Bang Cap : " + selectedText + "\n";
                }
                msg += "Sở thích : ";
                if (cbGame.isChecked())
                    msg += "" + cbGame.getText().toString();
                if (cbDocBao.isChecked())
                    msg += "" + cbDocBao.getText().toString();
                if (cbSach.isChecked())
                    msg += "" + cbSach.getText().toString() + "\n";
                msg += "Thông tin khác: " + edtTTK.getText().toString() + "\n";
                twResult.setText(msg);
            }
        });
    }

    private void setControl() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtTTK = findViewById(R.id.edtTTK);
        radDaiHoc = findViewById(R.id.radDaiHoc);
        radCaoDang = findViewById(R.id.radCaoDang);
        radTrungCap = findViewById(R.id.radTrungCap);
        rgBangCap = findViewById(R.id.rgBangCap);
        cbGame = findViewById(R.id.cbGame);
        cbSach = findViewById(R.id.cbSach);
        cbDocBao = findViewById(R.id.cbDocBao);
        twResult = findViewById(R.id.twResult);
        btnSend = findViewById(R.id.btnSend);

    }
}