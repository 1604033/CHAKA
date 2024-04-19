package com.example.sibbir.cyclesharingapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class provide extends AppCompatActivity {
    EditText id_btn,mble_btn,lctn_btn;
    Button reg_submit_btn;
    String id, phone, location;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide);


        builder = new AlertDialog.Builder(provide.this);
        id_btn = findViewById(R.id.id);
        mble_btn = findViewById(R.id.mble);
        lctn_btn = findViewById(R.id.lctn);
        reg_submit_btn = findViewById(R.id.reg_btn);

        reg_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = id_btn.getText().toString();
                phone = mble_btn.getText().toString();
                location = lctn_btn.getText().toString();
                if ( id.equals("") || phone.equals("") || location.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please provide all information!!!", Toast.LENGTH_SHORT).show();
                } //else if( !email.endsWith(".com") || !email.contains("@")){
                //Toast.makeText(getApplicationContext(), "Please Enter valid Email!!!", Toast.LENGTH_SHORT).show();}
                else {
                    insert_data();
                }

            }
        });

    }

    /// insertng data into database
    void insert_data()
    {
        String url = "http://sibbir.ourcuet.com/provide.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                builder.setMessage(response);
                builder.setTitle("cycle Providing Status: ");
                builder.setPositiveButton("Back to previous page", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(provide.this,biker_choice.class);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(provide.this, "Something went wrong, please try again later!", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map <String, String> reg_map  = new HashMap<String, String>();
                reg_map.put("id", id);
                reg_map.put("phone", phone);
                reg_map.put("location", location);

                return reg_map;
            }
        };

        MySingleton.getmInstance(provide.this).AddToRequestQueue(stringRequest);
    }
}
