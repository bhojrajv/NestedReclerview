package com.example.NestedReclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeamazon.R;

import java.util.ArrayList;

import Details.DetailsActivity;

public class HoriAddapter extends RecyclerView.Adapter<HoriAddapter.Viewholder> {
    private Context context;
    private ArrayList<Moviemodel>arrayList;
    public HoriAddapter(Context context, ArrayList<Moviemodel> horizontdata) {
  this.context=context;
  this.arrayList=horizontdata;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.hori_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.imageView.setImageResource(arrayList.get(position).getMovieimg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context=holder.itemView.getContext();
                //int position=holder.getAdapterPosition();
                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("value",arrayList.get(position).getMovieimg());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview3);
        }
    }
}
