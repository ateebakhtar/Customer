package com.example.admin.customer;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class paymentAdapter extends RecyclerView.Adapter<paymentAdapter.ExampleViewHolder>
{

    private  ArrayList<paymentitem>mpaymentlist;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {

        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mTextView1=itemView.findViewById(R.id.Item);
            mTextView2=itemView.findViewById(R.id.price);
        }




    }
    public paymentAdapter(ArrayList<paymentitem> exampleItemArrayList)
    {
        mpaymentlist =exampleItemArrayList;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.final_list,viewGroup,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        paymentitem currentItem=mpaymentlist.get(i);
        exampleViewHolder.mTextView1.setText(currentItem.getText1());
        exampleViewHolder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mpaymentlist.size();
    }
}

