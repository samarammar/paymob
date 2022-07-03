package com.bit68.paymobsdk_.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.adapter.ClickListener;
import com.bit68.paymobsdk_.adapter.PaymentMethodsAdapter;
import com.bit68.paymobsdk_.model.MethodsModel;

import java.util.ArrayList;
import java.util.List;

public class PaymentMerthodsActivity extends BaseActivity {

    ProgressBar progressBar;
ImageView close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_methods);
        progressBar=findViewById(R.id.progress);
        progressBar.setProgress(60);

        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        RecyclerView rv_payment= findViewById(R.id.rv_payments);

         List<MethodsModel> itemsList =new ArrayList<>();
         itemsList.add(new MethodsModel("0","Card payment",R.drawable.card));
         itemsList.add(new MethodsModel("1","Wallet payment",R.drawable.wallet));

        PaymentMethodsAdapter recyclerviewItemAdapter = new PaymentMethodsAdapter(itemsList,this);
//        recyclerviewItemAdapter.setOnItemClickListener(new ClickListener<MethodsModel>(){
//            @Override
//            public void onClick(View view, MethodsModel data, int position) {
//                startActivity(new Intent(PaymentMerthodsActivity.this,PaymentDetailsActivity.class));
//            }
//        });
        rv_payment.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_payment.setLayoutManager(layoutManager);
        rv_payment.setItemAnimator(new DefaultItemAnimator());
        rv_payment.setAdapter(recyclerviewItemAdapter);

recyclerviewItemAdapter.setOnItemClickListener(new ClickListener() {
    @Override
    public void onClick(View view, Object data, int position) {
    }
});


    }
}
