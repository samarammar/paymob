package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.data.RetrofitAPI;
import com.bit68.paymobsdk_.model.Confidence;
import com.bit68.paymobsdk_.model.FingerprintData;
import com.bit68.paymobsdk_.model.MarketPlaceModel;
import com.bit68.paymobsdk_.model.Meta;
import com.bit68.paymobsdk_.model.PaymentResponce;
import com.bit68.paymobsdk_.model.WalletDataModel;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WalletDetailsActivity extends BaseActivity {
Button btn_pay_now_;
String clientSecret;
EditText et_phone_number;
ProgressBar progressBar;
ImageView close;
    SharedPreferences msPrefs;
    String publicKey;
    int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_details);
        btn_pay_now_=(Button) findViewById(R.id.btn_pay_now_);
        et_phone_number=(EditText)findViewById(R.id.et_phone_number);
         msPrefs = getPreferences(MODE_PRIVATE);
     publicKey = msPrefs.getString("public_key", "");
        amount= msPrefs.getInt("amount",0);
        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        progressBar=findViewById(R.id.progress);
        progressBar.setProgress(60);
        btn_pay_now_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMarketplace();
            }
        });

    }

    void callMarketplace(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://next-stg.paymobsolutions.com/next/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call call = retrofitAPI.createClient();
        call.enqueue(new Callback<MarketPlaceModel>() {
            @Override
            public void onResponse(Call<MarketPlaceModel> call, Response<MarketPlaceModel> response) {

                if (response.code()==201) {
                    assert response.body() != null;
                    clientSecret = response.body().getClientSecret();
                    Log.i("clientSecret", clientSecret);
                    callWalletPayment(clientSecret);
                }
            }

            @Override
            public void onFailure(Call<MarketPlaceModel> call, Throwable t) {
                Log.i("error",t.toString());
            }

        });

    }

    void callWalletPayment(String clientSecret){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://next-stg.paymobsolutions.com/next/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//        pkl_iCkDYopU6LIibxzIGjqmKOiW0kYAPCx8
//        Log.i("publis",publicKey);
//        new  FingerprintData("fakeID","fakeID",new Meta("1.0"),new Confidence(22)))
        Call call = retrofitAPI.postWalletPayment(new WalletDataModel(publicKey,
                clientSecret,"wallets","WALLETS",et_phone_number.getText().toString(),
              new FingerprintData("fakeID","fakeID",new Meta("1.0"),new Confidence(22))));
        call.enqueue(new Callback<PaymentResponce>() {
            @Override
            public void onResponse(Call<PaymentResponce> call, Response<PaymentResponce> response) {

                if (response.code()==201) {
                    assert response.body() != null;
                    if (response.body().getRequirement().getStatus().equals("Declined")){
                        startActivity(new Intent(WalletDetailsActivity.this,FailActivity.class));
                    }else {
                        startActivity(new Intent(WalletDetailsActivity.this,SessionActivity.class));

                    }

                }
            }

            @Override
            public void onFailure(Call<PaymentResponce> call, Throwable t) {
                Log.i("error",t.toString());
            }

        });

    }

}
