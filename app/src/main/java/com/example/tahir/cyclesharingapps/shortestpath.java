package com.example.sibbir.cyclesharingapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class shortestpath extends AppCompatActivity {
    EditText rlctn_btn,blctn_btn;
    Button regButton;
    String biker,rider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortestpath);
        rlctn_btn =  findViewById(R.id.rlctn);
        blctn_btn =  findViewById(R.id.blctn);
        regButton = findViewById(R.id.reg_btn);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biker = blctn_btn.getText().toString();
                rider = rlctn_btn.getText().toString();
                Intent intent = new Intent(getApplicationContext(), showpath.class);
                intent.putExtra("biker", biker);
                intent.putExtra("rider", rider);
                startActivity(intent);
            }
        });


    }
}
