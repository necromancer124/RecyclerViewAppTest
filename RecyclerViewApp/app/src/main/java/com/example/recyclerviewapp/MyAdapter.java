package com.example.recyclerviewapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<String> myList;




    private int createViewHolderCount;



    private int bindViewHolderCount;
    public MyAdapter(List<String> list)
    {
        myList = list;
        createViewHolderCount = 0;
        bindViewHolderCount = 0;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item
                ,parent,false);
        Log.d("banana","onCreateViewHolder"+ ++createViewHolderCount);

        return new MyViewHolder(item);
    }





    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(myList.get(position));
        holder.originalText = myList.get(position);
        Log.d("banana","onBindViewHolder"+ ++bindViewHolderCount);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }







    public class MyViewHolder extends RecyclerView.ViewHolder {



        private TextView textView;


        private int counter;



        private String originalText;



        public MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    textView.setText(originalText+" "+counter);
                }
            });

        }
    }
}
