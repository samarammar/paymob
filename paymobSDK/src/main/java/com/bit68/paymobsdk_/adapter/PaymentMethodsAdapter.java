package com.bit68.paymobsdk_.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.model.MethodsModel;
import com.bit68.paymobsdk_.view.NewCardActivity;
import com.bit68.paymobsdk_.view.PaymentDetailsActivity;
import com.bit68.paymobsdk_.view.WalletDetailsActivity;

import java.util.List;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.MyViewHolder>  {

    public List<MethodsModel> itemsList;
    private ClickListener clickListener;
    Context context;

    public PaymentMethodsAdapter(List<MethodsModel> mItemList,Context context){
        this.itemsList = mItemList;
        this. context=context;
    }
    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public PaymentMethodsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_methods,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaymentMethodsAdapter.MyViewHolder holder, final int position) {
        final MethodsModel item = itemsList.get(position);
        holder.name.setText(item.getMethodName());
        holder.image.setImageResource(item.getMethodImage());
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getMethodId().equals("0")) {
                    context.startActivity(new Intent(context, NewCardActivity.class));
                }else if (item.getMethodId().equals("1")){
                    context.startActivity(new Intent(context, WalletDetailsActivity.class));

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public ImageView image;
        private ConstraintLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_method);
            image = itemView.findViewById(R.id.iv_method);
            itemLayout =  itemView.findViewById(R.id.layout_item);
            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view,itemsList.get(getPosition()) , getPosition());
            }
        }
    }
}