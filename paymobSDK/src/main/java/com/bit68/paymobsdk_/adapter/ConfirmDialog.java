package com.bit68.paymobsdk_.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.view.SuccessActivity;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

public class ConfirmDialog extends Dialog {

    private OtpTextView otpTextView;
    private Button btn_submit;
    public Activity c;

    public ConfirmDialog(@NonNull Activity a) {
        super(a);
        this.c = a;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_card_cvv);
        btn_submit=findViewById(R.id.btn_submit);
        otpTextView = findViewById(R.id.otp_verify);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                // fired when user types something in the Otpbox
            }
            @Override
            public void onOTPComplete(String otp) {
                // fired when user has entered the OTP fully.
//                Toast.makeText(MainActivity.this, "The OTP is " + otp,  Toast.LENGTH_SHORT).show();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.startActivity(new Intent(c, SuccessActivity.class));

                c.finish();
                dismiss();

            }
        });

    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btn_submit) {
//
//
//        }
//    }
}
