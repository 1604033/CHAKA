package com.example.sibbir.cyclesharingapps;

import android.app.Activity;
import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cycle_list extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CycleItem> CycleList = new ArrayList<>();
    RecyclerView.Adapter adapter;
    String Url = "http://sibbir.ourcuet.com/cyclelist.php";
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_list);
         recyclerView=findViewById(R.id.recyclerview);
       recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ParseData();


    }

    private void ParseData() {
        Map<String, String> map = new HashMap<>();
        System.out.println("PARSE DATA");
        JsonArrayRequest customJsonArrayRequest = new JsonArrayRequest(Request.Method.POST, Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response.length());
                for (int i = 0; i < response.length(); i++) {
                    System.out.println("PARSE DATA");
                    try {
                        JSONObject joson = response.getJSONObject(i);
                        System.out.println(joson.getString("phone"));
                        CycleItem cycleItem = new CycleItem(joson.getString("bid"), joson.getString("phone"), joson.getString("location"));
                        CycleList.add(cycleItem);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new CycleRecyclerAdapter(CycleList,cycle_list.this);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        MySingleton.getmInstance(this).AddToRequestQueue(customJsonArrayRequest);
    }
}
