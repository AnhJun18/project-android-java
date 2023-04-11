package com.example.caculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainProductDetail extends AppCompatActivity {
    ImageView ivSP;
    TextView txtGia,txtTenSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_detail);
        setControl();
        setEvent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setEvent() {
        Product pr = (Product) getIntent().getSerializableExtra("product_selected");
        System.out.println(pr.toString());
        Picasso.get().load(pr.urlImg).into(ivSP);
        txtGia.setText(pr.price);
        txtTenSP.setText(pr.name);

    }

    private void setControl() {
        ivSP=findViewById(R.id.ivSP);
        txtGia=findViewById(R.id.txtGia);
        txtTenSP=findViewById(R.id.txtTenSP);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case  android.R.id.home:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}