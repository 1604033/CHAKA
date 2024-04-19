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

public class rregistration extends AppCompatActivity {

    EditText name_et, id_et, hall_et, phone_et, pass_et;
    Button reg_submit_btn;
    String name, id, hall, phone, password;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rregistration);

        builder = new AlertDialog.Builder(rregistration.this);
                name_et = findViewById(R.id.name);
                id_et = findViewById(R.id.id);
                hall_et = findViewById(R.id.hall);
                phone_et = findViewById(R.id.mble);
                pass_et = findViewById(R.id.pass);
                reg_submit_btn = findViewById(R.id.reg_btn);

                reg_submit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = name_et.getText().toString();
                        id = id_et.getText().toString();
                        hall = hall_et.getText().toString();
                        phone = phone_et.getText().toString();
                        //string to int
                        // int pass=Integer.parseInt(password);
                        password = pass_et.getText().toString();
                        if (name.equals("") || id.equals("") || hall.equals("") || phone.equals("") || password.equals("")) {
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
        String url = "http://sibbir.ourcuet.com/rregistration.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                builder.setMessage(response);
                builder.setTitle("Registration Status: ");
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(rregistration.this,rider_choice.class);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(rregistration.this, "Something went wrong, please try again later!", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map <String, String> reg_map  = new HashMap<String, String>();
                reg_map.put("rusername", name);
                reg_map.put("rid", id);
                reg_map.put("rhall", hall);
                reg_map.put("rphone", phone);
                reg_map.put("rpassword", password);

                return reg_map;
            }
        };

        MySingleton.getmInstance(rregistration.this).AddToRequestQueue(stringRequest);
    }
}
