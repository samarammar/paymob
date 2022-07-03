package com.bit68.paymobsdk_.data;

import com.bit68.paymobsdk_.model.MarketPlaceModel;
import com.bit68.paymobsdk_.model.MarketPlaceRequest;
import com.bit68.paymobsdk_.model.PaymentResponce;
import com.bit68.paymobsdk_.model.CardDataModel;
import com.bit68.paymobsdk_.model.WalletDataModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @GET("marketplace/intention/")
    Call<MarketPlaceModel> createClient();

    @POST("marketplace/secret/")
    Call<MarketPlaceModel> createClientLive(@Body MarketPlaceRequest marketPlaceRequest);

    @POST("intention/confirm/")
    Call<PaymentResponce> postCardPayment(@Body CardDataModel cardDataModel);

    @POST("intention/confirm/")
    Call<PaymentResponce> postWalletPayment(@Body  WalletDataModel walletDataModel );

}
