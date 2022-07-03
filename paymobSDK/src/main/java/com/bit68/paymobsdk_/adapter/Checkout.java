package com.bit68.paymobsdk_.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.bit68.paymobsdk_.view.WelcomeActivity;

public class Checkout {
    public void startCheckout(Activity activity,String public_key,int amount){
        SharedPreferences mPrefs = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("public_key", public_key);
        prefsEditor.putInt("amount", amount);
        prefsEditor.apply();
        activity.startActivity(new Intent(activity, WelcomeActivity.class));
    }
}

