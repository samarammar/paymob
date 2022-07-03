package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.adapter.CardsAdapter;
import com.bit68.paymobsdk_.adapter.ConfirmDialog;
import com.bit68.paymobsdk_.adapter.ItemClickListener;
import com.bit68.paymobsdk_.model.CardsModel;

import java.util.ArrayList;

public class PaymentDetailsActivity extends BaseActivity {

    // Initialize variable
    RecyclerView recyclerView;
    ItemClickListener itemClickListener;
    CardsAdapter adapter;
    TextView tv_add_new,tv_edit;
Button btn_pay_now;

ImageView iv_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_datails);

        // Assign variable
        tv_add_new =findViewById(R.id.tv_add_new);
        recyclerView = findViewById(R.id.rv_cards);
        btn_pay_now=findViewById(R.id.btn_pay_now);
        iv_add=findViewById(R.id.iv_add);
        tv_edit=findViewById(R.id.tv_edit);

        btn_pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDialog cdd = new ConfirmDialog(PaymentDetailsActivity.this);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });

        // initialize array list
        ArrayList<CardsModel> arrayList = new ArrayList<>();


            arrayList.add(new CardsModel("1234 1234 **** ****",R.drawable.master));
            arrayList.add(new CardsModel("1234 1234 **** ****",R.drawable.master));

        // Initialize listener

        tv_add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentDetailsActivity.this,NewCardActivity.class));
            }
        });
        itemClickListener = new ItemClickListener() {
            @Override public void onClick(String s)
            {
                // Notify adapter
                recyclerView.post(new Runnable() {
                    @Override public void run()
                    {
                        adapter.notifyDataSetChanged();
                    }
                });
                // Display toast
//                Toast
//                        .makeText(getApplicationContext(),
//                                "Selected : " + s,
//                                Toast.LENGTH_SHORT)
//                        .show();


            }
        };

        // Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter
        adapter = new CardsAdapter(arrayList, itemClickListener);

        // set adapter
        recyclerView.setAdapter(adapter);


    }
}
