package com.example.caculator;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ViewFlipper viewBanner;
    GridView gridView;
    RecyclerView rvBestSeller;
    RecyclerView rvProducts;

    ArrayList<String> listCategory = new ArrayList<>();
    ArrayAdapter adapterCategory;

    ArrayList<Product> listBestSeller = new ArrayList<>();
    RecyclerView.Adapter adapterBestSeller;

    ArrayList<Product> listAllProduct = new ArrayList<>();
    RecyclerView.Adapter adapterProducts;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setControl();
        setEvent();
    }


    private void setControl() {
        viewBanner = findViewById(R.id.viewBanner);
        gridView= findViewById(R.id.gridView);
        rvBestSeller= findViewById(R.id.rvBestSeller);
        rvProducts= findViewById(R.id.rvProducts);
    }

    private void setEvent() {
        requestQueue = Volley.newRequestQueue(this);
        Banner();
        adapterCategory = new CustomAdapterCategory(this, R.layout.layout_item_category, listCategory);
        gridView.setAdapter(adapterCategory);
        getlistCategory();
        adapterCategory.notifyDataSetChanged();


        adapterBestSeller = new CustomAdapterProduct(listBestSeller,this) ;
        rvBestSeller.setNestedScrollingEnabled(false);
        rvBestSeller.setFocusable(false);
        rvBestSeller.setAdapter(adapterBestSeller);
        getBestSeller();
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvBestSeller.setLayoutManager(layoutManager);
        adapterBestSeller.notifyDataSetChanged();


        adapterProducts = new CustomAdapterProduct(listAllProduct,this) ;
        rvProducts.setNestedScrollingEnabled(false);
        rvProducts.setFocusable(false);
        rvProducts.setAdapter(adapterProducts);
        getAllProducts();
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,3);
        rvProducts.setLayoutManager(gridLayoutManager2);
        adapterProducts.notifyDataSetChanged();

    }

    private void getAllProducts() {
        String url="https://pa-shop-service.azurewebsites.net/api/product/all";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listAllProduct.clear();
                for( int i=0 ; i< response.length();i++){
                    try {
                        JSONObject object=(JSONObject) response.get(i);
                        Product pr = new Product();
                        pr.setName(object.getString("name"));
                        pr.setUrlImg(object.getString("linkImg"));
                        pr.setPrice(object.getString("price"));

                        listAllProduct.add(pr);


                    } catch (JSONException e) {
                        throw  new RuntimeException(e);
                    }
                }
                adapterProducts.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeActivity.this,"Lỗi "+error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

    private void getBestSeller() {
        String url="https://pa-shop-service.azurewebsites.net/api/product/best-seller";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listBestSeller.clear();
                for( int i=0 ; i< response.length();i++){
                    try {
                        JSONObject object=(JSONObject) response.get(i);
                        Product pr = new Product();
                        pr.setName(object.getString("name"));
                        pr.setUrlImg(object.getString("linkImg"));
                        pr.setPrice(object.getString("price"));

                        listBestSeller.add(pr);


                    } catch (JSONException e) {
                        throw  new RuntimeException(e);
                    }
                }
                adapterBestSeller.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeActivity.this,"Lỗi "+error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);


    }

    private void getlistCategory() {
        listCategory.add("https://theme.hstatic.net/200000305259/1000967293/14/banner_index_1.jpg?v=12");
        listCategory.add("https://theme.hstatic.net/200000305259/1000967293/14/banner_index_2.jpg?v=12");
        listCategory.add("https://theme.hstatic.net/200000305259/1000967293/14/banner_index_4.jpg?v=12");
        listCategory.add("https://theme.hstatic.net/200000305259/1000967293/14/banner_index_4.jpg?v=12");
        listCategory.add("https://theme.hstatic.net/200000305259/1000967293/14/banner_index_4.jpg?v=12");
    }

    private void Banner() {
        ImageView view1 = new ImageView(getApplicationContext());
        String h1 = "https://theme.hstatic.net/200000305259/1000963148/14/slide_index_2.jpg?v=74";
        Picasso.get().load(h1).into(view1);
        ImageView view2 = new ImageView(getApplicationContext());
        String h2 = "https://theme.hstatic.net/200000305259/1000963148/14/slide_index_1.jpg?v=74";
        Picasso.get().load(h2).into(view2);
        viewBanner.addView(view1);
        viewBanner.addView(view2);
        viewBanner.setAutoStart(true);//tu dong chay
    }
}