package com.bit68.paymobsdk_.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.data.RetrofitAPI;
import com.bit68.paymobsdk_.model.BillingData;
import com.bit68.paymobsdk_.model.CardDataModel;
import com.bit68.paymobsdk_.model.Confidence;
import com.bit68.paymobsdk_.model.FingerprintData;
import com.bit68.paymobsdk_.model.Item;
import com.bit68.paymobsdk_.model.MarketPlaceModel;
import com.bit68.paymobsdk_.model.MarketPlaceRequest;
import com.bit68.paymobsdk_.model.Meta;
import com.bit68.paymobsdk_.model.PaymentResponce;
import com.bit68.paymobsdk_.model.WalletDataModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewCardActivity extends BaseActivity {
    private static final String EXP_DATE_REGAX = "(0[1-9]|1[0-2])[0-9]{2}";
    EditText et_expiry_date,et_card_number,
            et_card_name,et_cvv;
    String clientSecret;
    Button btn_continue_login;
    ProgressBar progressBar;
    ImageView close;

    SharedPreferences msPrefs;
    String publicKey;
    int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        et_expiry_date=findViewById(R.id.et_expiry_date);
        et_card_number=findViewById(R.id.et_card_number);
        et_card_name=findViewById(R.id.et_card_name);
        et_cvv=findViewById(R.id.et_cvv);
        progressBar=findViewById(R.id.progress);
        progressBar.setProgress(60);

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

        btn_continue_login=findViewById(R.id.btn_continue_login);

        btn_continue_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMarketplace();
            }
        });
        et_expiry_date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String working = s.toString();
                boolean isValid = true;
                if (working.length() == 2 && before == 0) {
                    if (Integer.parseInt(working) < 1 || Integer.parseInt(working) > 12) {
                        isValid = false;
                    } else {
                        working += "/";
                        et_expiry_date.setText(working);
                        et_expiry_date.setSelection(working.length());
                    }
                }else if (working.length() == 5 && before == 0) {
                    String enteredYear = working.substring(3);
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100 ;//getting last 2 digits of current year i.e. 2018 % 100 = 18
                    if (Integer.parseInt(enteredYear) < currentYear) {
                        isValid = false;
                    }
                }else if (working.length() != 5) {
                    isValid = false;
                }

                if (!isValid) {
                    et_expiry_date.setError("MM/YY Format");
                } else {
                    et_expiry_date.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void callMarketplace(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://flashapi-paymob.bit68.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        List<String> payment_methods=new ArrayList<>();
        payment_methods.add("card");

        List<Item> items=new ArrayList<>();
        items.add(new Item("ASC1124",String.valueOf(amount),"desc","1"));

        Call call = retrofitAPI.createClientLive(new MarketPlaceRequest(amount,"EGP",payment_methods,items,
                new BillingData("test@gmail.com","test","011167534360","tester")));
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://next-stg.paymobsolutions.com/next/api/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//
//        Call call = retrofitAPI.createClient();
        call.enqueue(new Callback<MarketPlaceModel>() {
            @Override
            public void onResponse(Call<MarketPlaceModel> call, Response<MarketPlaceModel> response) {
                Log.i("response.code()", String.valueOf(response.code()));

                if (response.code()==200) {
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
//                .baseUrl("https://next-stg.paymobsolutions.com/next/api/v1/")
                .baseUrl("https://flashapi.paymob.com/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
       String date= et_expiry_date.getText().toString();
       if (date.contains("/")&&date.length()==5) {
           String[] separated = date.split("/");
           separated[1] = separated[1].trim();
           separated[0] = separated[0].trim();

//           pk_live_wxMQ20qMCG1Hl2mtlIAqd3niQC9FAzBz
//           pkl_iCkDYopU6LIibxzIGjqmKOiW0kYAPCx8
//        new  FingerprintData("fakeID","fakeID",new Meta("1.0"),new Confidence(22)))
        Call call = retrofitAPI.postCardPayment(new CardDataModel("pk_live_wxMQ20qMCG1Hl2mtlIAqd3niQC9FAzBz",
                clientSecret,"card","CARD",et_card_number.getText().toString(),et_card_name.getText().toString(),
                separated[0], separated[1],et_cvv.getText().toString(),new FingerprintData("fakeID","fakeID",new Meta("1.0"),new Confidence(22))
                ));
        call.enqueue(new Callback<PaymentResponce>() {
            @Override
            public void onResponse(Call<PaymentResponce> call, Response<PaymentResponce> response) {
                Log.i("clientSecret", response.toString());

                if (response.code()==201) {
                    assert response.body() != null;
                    Log.i("clientSecret", response.body().getRequirement().getRedirection_url());
                    if (response.body().getRequirement().getStatus().equals("Declined")){
                        startActivity(new Intent(NewCardActivity.this,FailActivity.class));
                    }else if (response.body().getRequirement().getStatus().equals("Pending")) {
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
//                                Uri.parse(response.body().getRequirement().getRedirection_url()));
//                        startActivity(browserIntent);
                        Intent urlIntent= new Intent(NewCardActivity.this,CardWebviewActivity.class);
                        urlIntent.putExtra("url",response.body().getRequirement().getRedirection_url());
                        Log.i("url",response.body().getRequirement().getRedirection_url());

                        startActivity(urlIntent);
                    }else {
                        startActivity(new Intent(NewCardActivity.this,SessionActivity.class));
                    }

                }
            }

            @Override
            public void onFailure(Call<PaymentResponce> call, Throwable t) {
                Log.i("error",t.toString());
            }

        });
       }else {
           et_expiry_date.setError("MM/YY Format");
       }

    }
}
