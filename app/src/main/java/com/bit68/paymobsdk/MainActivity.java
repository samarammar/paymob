package com.bit68.paymobsdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bit68.paymobsdk_.adapter.Checkout;


public class MainActivity extends AppCompatActivity {
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkout=findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add your public key and amount here
                new Checkout().startCheckout(MainActivity.this,"pkl_iCkDYopU6LIibxzIGjqmKOiW0kYAPCx8",1);
            }
        });
    }
}