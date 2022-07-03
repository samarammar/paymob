package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bit68.paymobsdk.R;

public class FailActivity extends BaseActivity {
    Button btn_try_again,btn_cancel;
    ProgressBar progressBar;
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        btn_try_again=(Button) findViewById(R.id.btn_try_again);
        btn_cancel=(Button) findViewById(R.id.btn_cancel);
        progressBar=findViewById(R.id.progress);
        progressBar.setProgress(100);


        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btn_try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FailActivity.this,PaymentMerthodsActivity.class));
                finish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}