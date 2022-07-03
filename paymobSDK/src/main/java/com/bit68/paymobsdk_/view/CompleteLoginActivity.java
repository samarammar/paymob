package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bit68.paymobsdk.R;

public class CompleteLoginActivity extends BaseActivity {

    Button btn_continue_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_login);

        btn_continue_login=findViewById(R.id.btn_continue_login);
        btn_continue_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompleteLoginActivity.this,PaymentMerthodsActivity.class));
            }
        });
    }
}

