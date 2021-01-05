package com.example.NestedReclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeamazon.R;

import java.util.ArrayList;

public class HorizontalMoview extends RecyclerView.Adapter<HorizontalMoview.ViewHolder> {
    private Context context;
    private ArrayList<Moviemodel>moviemodels;
    public HorizontalMoview(Context context, ArrayList<Moviemodel> singlemovie) {
        this.context=context;
        this.moviemodels=singlemovie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.movie_layou,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          Moviemodel moviemodel=moviemodels.get(position);
        holder.imageView.setImageResource(moviemodel.getMovieimg());
    }



    @Override
    public int getItemCount() {
        return moviemodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
