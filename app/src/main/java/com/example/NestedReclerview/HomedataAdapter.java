package com.example.NestedReclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeamazon.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class HomedataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object>objects;
    public static final int vertical=1;
    public static final int horizontal=3;
    public  static final int carousel=2;
    public static final int horizontal2=4;
    public static final int horizontal3=5;
    public static final int horizonta4=6;
    public static final int horizonta5=7;
    public static final int horizonta6=8;
    public static final int horizonta8=9;
    private Context context;
    private ImageListener imageListener;
    public HomedataAdapter(MainActivity mainActivity, ArrayList<Object> objects) {
this.context=mainActivity;
this.objects=objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        layoutInflater.inflate(R.layout.main_layout, parent, false);
        View view;
        RecyclerView.ViewHolder myviewHolder =null;
            switch (viewType){

                case carousel:
                    view=layoutInflater.inflate(R.layout.carousel_layout,parent,false);
                    myviewHolder=new Carouselveiw(view);
                    break;
                case vertical:
                    view=layoutInflater.inflate(R.layout.vertical_layout,parent,false);
                    myviewHolder=new Verticalview(view);
                    break;
                case horizontal:
                    view=layoutInflater.inflate(R.layout.main_layout,parent,false);
                    myviewHolder=new Horiview(view);




            }
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==carousel){
            getcarouselview((Carouselveiw)holder);
        }
        else if(holder.getItemViewType()==vertical){
            getVeticalview((Verticalview)holder);
        }else if(holder.getItemViewType()==horizontal){
            gethorizview((Horiview)holder);
        }

    }

    private void gethorizview2(Horiview2 holder) {
        Moviemodel moviemodel=new Moviemodel();
        holder.imageView2.setImageResource(moviemodel.getMovieimg());
    }

    private void gethorizview(Horiview holder) {
       HoriAddapter addapter=new HoriAddapter(context,MainActivity.horizontdata());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
       holder.recyclerView.setLayoutManager(gridLayoutManager);
       holder.recyclerView.setAdapter(addapter);


    }

    private void getcarouselview(Carouselveiw holder) {
        imageListener=new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(MainActivity.caroseldatq().get(position).getImg());
            }
        };
         holder.carouselveiw.setImageListener(imageListener);
         holder.carouselveiw.setPageCount(MainActivity.caroseldatq().size());
    }

    @Override
    public int getItemViewType(int position) {
        if(objects.get(position)instanceof TitlModel){
            return vertical;
        }
        if(objects.get(position)instanceof CarouselModel){
            return carousel;
        }if(objects.get(position)instanceof Moviemodel){
            return horizontal;
        }
        return 3;
    }

//    private void gethoriView(Horizontalview holder) {
//
//    }

    private void getVeticalview(Verticalview holder) {
        ArrayList<TitlModel>titlModels=new ArrayList<>();
        for(int i=1;i<=10;i++){
            TitlModel titlModel=new TitlModel();
            titlModels.add(titlModel);
            titlModel.setTitle("titile"+i);
            ArrayList<Moviemodel>moviemodels=null;
            for (int j=1;j<=5;j++){
                Moviemodel moviemodel =new Moviemodel();
                moviemodels=new ArrayList<>();
                moviemodels.add(moviemodel);
                moviemodel.setMovieimg(R.drawable.movie+j);

            }
            titlModel.setMoviemodels(moviemodels);

        }

         VerticalAddaptr verticalAddaptr=new VerticalAddaptr(context, titlModels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(verticalAddaptr);
        verticalAddaptr.notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class Verticalview extends RecyclerView.ViewHolder  {
        private TextView textView;
        private RecyclerView recyclerView;
        public Verticalview(View view) {
            super(view);
            recyclerView=view.findViewById(R.id.vertcalrec);
         //   textView=view.findViewById(R.id.titleshow);
            context=view.getContext();

        }


    }

//    private class Horizontalview extends RecyclerView.ViewHolder {
//        public Horizontalview(View view) {
//            super(view);
//        }
//    }

    private class Carouselveiw extends RecyclerView.ViewHolder {
        private CarouselView carouselveiw;
        public Carouselveiw(View view) {
            super(view);
            carouselveiw=view.findViewById(R.id.carouselView);
        }
    }

    private class Horiview extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public Horiview(View view) {
            super(view);
           recyclerView=view.findViewById(R.id.mainrec);
        }
    }

    private class Horiview2 extends RecyclerView.ViewHolder {
        ImageView imageView2;
        public Horiview2(View view) {
            super(view);
            imageView2=view.findViewById(R.id.imageview3);
        }
    }


}
