package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityGetUser extends AppCompatActivity {
    Button btnGetUser, btnSearch;
    EditText edtLogin;
    ListView lvUsers;
    ArrayList<User> data_user = new ArrayList<>();
    ArrayAdapter adapter_user;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_get_user);
        setControl();
        setEvent();
    }

    private void setEvent() {
        adapter_user = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_user);
        lvUsers.setAdapter(adapter_user);
        requestQueue = Volley.newRequestQueue(this);
        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetUser();
            }
        });
        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtLogin.setText(data_user.get(i).getLogin());
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getSearch();
            }
        });
    }

    private void getSearch() {
        String url = "https://api.github.com/search/users?q="+edtLogin.getText().toString();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response.toString());
                    String msg="Thông tin \n";
                    msg+="Số total_account"+object.getString("total_count");
                    JSONArray jsonArray= object.getJSONArray("items");
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject object1 = jsonArray.getJSONObject(i);
                        msg+="\n login: "+ object1.getString("login");

                    }
                    System.out.println(msg);
                    Toast.makeText(MainActivityGetUser.this,msg,Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    throw  new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivityGetUser.this,"Lỗi "+error.toString(),Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(request);
    }

    private void GetUser() {
        String url="https://api.github.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                data_user.clear();
                for( int i=0 ; i< response.length();i++){
                    try {
                        JSONObject object=(JSONObject) response.get(i);
                        User user = new User();
                        user.setLogin(object.getString("login"));
                        user.setAvatar_url(object.getString("avatar_url"));
                        data_user.add(user);


                    } catch (JSONException e) {
                        throw  new RuntimeException(e);
                    }
                }
                adapter_user.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivityGetUser.this,"Lỗi "+error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

    private void setControl() {
        btnGetUser = findViewById(R.id.btnGetUser);
        btnSearch = findViewById(R.id.btnSearch);
        edtLogin = findViewById(R.id.edtLogin);
        lvUsers = findViewById(R.id.lvUsers);
    }
}