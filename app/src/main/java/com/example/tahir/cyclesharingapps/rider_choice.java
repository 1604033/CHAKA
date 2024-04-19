package com.example.sibbir.cyclesharingapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rider_choice extends AppCompatActivity {
    Button avl_btn,path_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_choice);
        avl_btn = (Button) findViewById(R.id.avl);
        path_btn = (Button) findViewById(R.id.path);


        avl_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ///Intent intent = new Intent(getApplicationContext(), AddingFreelanceJob.class);
                Intent intent = new Intent(rider_choice.this, cycle_list.class);
                startActivity(intent);

            }
        });
        path_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ///Intent intent = new Intent(getApplicationContext(), AddingFreelanceJob.class);
                Intent intent = new Intent(rider_choice.this, shortestpath.class);
                startActivity(intent);

            }
        });
    }
}
