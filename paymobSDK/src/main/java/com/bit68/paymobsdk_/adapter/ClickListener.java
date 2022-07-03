package com.bit68.paymobsdk_.adapter;

import android.view.View;

public interface ClickListener<T> {

    void onClick(View view, T data, int position);
}
