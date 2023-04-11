package com.example.caculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainNavigation extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;//nút menu
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    LoginFragment fragmentDangNhap;
    FragmentCaiDat fragmentCaiDat=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        setControl();
        setEvent();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void setEvent() {
    drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);
    drawerLayout.addDrawerListener(drawerToggle);
    drawerToggle.syncState();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    Banner();
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch ((item.getItemId())){
                case  R.id.mn_DangNhap:
                    Toast.makeText(MainNavigation.this,"Đăng nhâpp",Toast.LENGTH_LONG).show();
                    if(fragmentDangNhap==null)
                         fragmentDangNhap= new LoginFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.NoiDung,fragmentDangNhap)
                            .commit();
                    break;
                case  R.id.mn_CaiDat:
                    Toast.makeText(MainNavigation.this,"Đăng nhâpp",Toast.LENGTH_LONG).show();
                    if(fragmentCaiDat==null)
                        fragmentCaiDat= new FragmentCaiDat();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.NoiDung,fragmentCaiDat)
                            .commit();
                    break;
            }
            if(drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);

            return false;
        }
    });

    }

    private void Banner() {
        ImageView view1= new ImageView(getApplicationContext());
        view1.setImageResource(R.drawable.ic_baseline_account_circle_24);
        ImageView view2= new ImageView(getApplicationContext());
        view1.setImageResource(R.drawable.ic_baseline_admin_panel_settings_24);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.setAutoStart(true);//tu dong chay
    }

    //nút back vật lý của máy
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void setControl() {
        drawerLayout=findViewById(R.id.drawerLayout);
        viewFlipper=findViewById(R.id.viewFlipper);
        navigationView=findViewById(R.id.navigation);
    }
}