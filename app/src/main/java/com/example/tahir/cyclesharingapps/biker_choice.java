package com.example.sibbir.cyclesharingapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class biker_choice extends AppCompatActivity {
Button prvd_btn,rmv_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biker_choice);
        prvd_btn = (Button) findViewById(R.id.prvd);
        rmv_btn = (Button) findViewById(R.id.rmv);
        prvd_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ///Intent intent = new Intent(getApplicationContext(), AddingFreelanceJob.class);
                Intent intent = new Intent(biker_choice.this, provide.class);
                startActivity(intent);

            }
        });
        rmv_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ///Intent intent = new Intent(getApplicationContext(), AddingFreelanceJob.class);
                Intent intent = new Intent(biker_choice.this, remove.class);
                startActivity(intent);

            }
        });

    }
}
