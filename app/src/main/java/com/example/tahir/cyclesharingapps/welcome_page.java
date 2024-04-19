package com.example.sibbir.cyclesharingapps;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.view.View;

public class welcome_page extends AppCompatActivity {
    Button bikerbtn,riderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        bikerbtn=findViewById(R.id.bikerbtn);

        riderbtn=findViewById(R.id.riderbtn);

        bikerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(welcome_page.this,blogin_page.class);
                startActivity(intent);
            }
        });
        riderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(welcome_page.this,rlogin_page.class);
                startActivity(intent);
            }
        });

    }
}
