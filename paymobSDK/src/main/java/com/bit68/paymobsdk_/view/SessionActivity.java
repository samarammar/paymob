package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bit68.paymobsdk.R;

public class SessionActivity  extends BaseActivity {
    Button btn_gotit;
    ProgressBar progressBar;
    ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        progressBar=findViewById(R.id.progress);
        progressBar.setProgress(100);

        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        btn_gotit=findViewById(R.id.btn_gotit);
        btn_gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SessionActivity.this,PaymentMerthodsActivity.class));
            }
        });
    }
}

