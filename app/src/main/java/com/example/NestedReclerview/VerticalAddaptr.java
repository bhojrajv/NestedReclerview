package com.example.NestedReclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeamazon.R;

import java.util.ArrayList;

import Details.DetailsActivity;

public class VerticalAddaptr extends RecyclerView.Adapter<VerticalAddaptr.Viewholder> {
    private ArrayList<Moviemodel>singlemovie;
     ArrayList<TitlModel>titlModels;
     private Context context;
    public VerticalAddaptr(Context context, ArrayList<TitlModel> verticaldata) {
        this.context=context;
        this.titlModels=verticaldata;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.titlmodel_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAddaptr.Viewholder holder, int position) {

        TitlModel titlModel=titlModels.get(position);
        holder.textView.setText(titlModel.getTitle());

        singlemovie =new ArrayList<>();
         singlemovie=titlModel.getMoviemodels();
        HorizontalMoview moview=new  HorizontalMoview(context,singlemovie);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context
                                               ,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(moview);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context=holder.itemView.getContext();
                int position=holder.getAdapterPosition();
                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("title",titlModel.getTitle());
                intent.putExtra("image",singlemovie.get(position).getMovieimg());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return titlModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView textView;
        private RecyclerView recyclerView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.titleshow);
            recyclerView=itemView.findViewById(R.id.modelRec);
        }
    }
}
