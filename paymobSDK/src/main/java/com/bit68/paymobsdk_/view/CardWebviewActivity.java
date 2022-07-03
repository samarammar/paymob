package com.bit68.paymobsdk_.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.bit68.paymobsdk.R;

public class CardWebviewActivity extends AppCompatActivity {
    Button btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_webview);
        WebView browser = (WebView) findViewById(R.id.wv_card);
        btn_done=findViewById(R.id.btn_done);
        Intent urlIntent= getIntent();
        String url=urlIntent.getStringExtra("url");
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        browser.loadUrl(url);
        Log.i("url",urlIntent.getStringExtra("url"));


//        Payment+Declined.+Please+refer+back+to+your+bank+or+use+an+alternative+card
        browser.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i("url",url);

                if(url.contains("Payment+Declined.")){
                    Log.i("url","Payment+Declined.");
                    btn_done.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(CardWebviewActivity.this,FailActivity.class));
                            finish();
                        }
                    });
                }else if (url.contains("data.message=Approved&txn_response_code=APPROVED")){
                    startActivity(new Intent(CardWebviewActivity.this,SuccessActivity.class));
                    finish();
                }
            }
        });
    }
}