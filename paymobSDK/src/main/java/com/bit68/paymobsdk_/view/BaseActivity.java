package com.bit68.paymobsdk_.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bit68.paymobsdk.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
//    SharedPreferences msPrefs = getPreferences(MODE_PRIVATE);
//    String publicKey = msPrefs.getString("public_key", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar();
//        toolbar=getSupportActionBar().



    }
    public Toolbar getToolbar() {
        return toolbar;
    }


    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
        this.toolbar = toolbar;
        setToolbarBackClickListener();
    }
    private void setToolbarBackClickListener(){
//        if(toolbar != null) {
            ImageView backButton = toolbar.findViewById(R.id.close);
//            if (backButton != null) {
//                backButton.setOnClickListener(l -> finish());

//            }
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
//        }
    }

}
