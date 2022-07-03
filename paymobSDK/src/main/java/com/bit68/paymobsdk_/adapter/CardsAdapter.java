package com.bit68.paymobsdk_.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bit68.paymobsdk.R;
import com.bit68.paymobsdk_.model.CardsModel;

import java.util.ArrayList;

public class CardsAdapter  extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {

    // Initialize variable
    ArrayList<CardsModel> arrayList;
    ItemClickListener itemClickListener;
    int selectedPosition = -1;

    // Create constructor
    public CardsAdapter(ArrayList<CardsModel> arrayList,
                       ItemClickListener itemClickListener)
    {
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        // Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent,
                        false);
        // Pass holder view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 int position)
    {
        // Set text on radio button
        holder.radioButton.setText(arrayList.get(position).getCardName());
        holder.radioButton.setButtonDrawable(arrayList.get(position).getCardPhoto());

        // Checked selected radio button
        holder.radioButton.setChecked(position
                == selectedPosition);

        // set listener on radio button
        holder.radioButton.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton compoundButton,
                            boolean b)
                    {
                        // check condition
                        if (b) {
                            // When checked
                            // update selected position
                            selectedPosition
                                    = holder.getAdapterPosition();
                            // Call listener
                            itemClickListener.onClick(
                                    holder.radioButton.getText()
                                            .toString());
                        }
                    }
                });
    }

    @Override public long getItemId(int position)
    {
        // pass position
        return position;
    }
    @Override public int getItemViewType(int position)
    {
        // pass position
        return position;
    }

    @Override public int getItemCount()
    {
        // pass total list size
        return arrayList.size();
    }

    public class ViewHolder
            extends RecyclerView.ViewHolder {
        // Initialize variable
        RadioButton radioButton;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // Assign variable
            radioButton
                    = itemView.findViewById(R.id.radio_button);
        }
    }
}

class GFG {
    public static void main(String[] args)
    {
        System.out.println("GFG!");
    }
}