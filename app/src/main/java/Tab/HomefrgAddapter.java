package Tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NestedReclerview.CarouselModel;
import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class HomefrgAddapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Object>objects;
    private static final int carousel=1;
    private static final  int hori=2;
    private static final int vert=3;
    private ImageListener imageListener;
    public HomefrgAddapter(FragmentActivity activity, ArrayList<Object> objects) {
        this.objects=objects;
        this.context=activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
         RecyclerView.ViewHolder myvieholder=null;
         switch (viewType){
             case carousel:
                 view=layoutInflater.inflate(R.layout.carousel_layout2,parent,false);
                 myvieholder=new Carouseldata(view);
                 break;
             case hori:
                 view =layoutInflater.inflate(R.layout.hori_layout2,parent,false);
                 myvieholder=new horiViewdata(view);
                 break;
             case vert:
                 view =layoutInflater.inflate(R.layout.vertical_layout2,parent,false);
                 myvieholder=new Vertviewdata(view);
         }
         return myvieholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==carousel){
            getCarouselveiw((Carouseldata)holder);
        }else if(holder.getItemViewType()==hori){
            getHoriView((horiViewdata)holder);

        }else if(holder.getItemViewType()==vert){
            getVertView((Vertviewdata)holder);
        }

    }

    @Override
    public int getItemViewType(int position) {
       if (objects.get(position)instanceof CarouselModel){
           return carousel;
       }else if(objects.get(position)instanceof Moviemodel){
           return hori;
       }
       else if (objects.get(position)instanceof TitlModel){
           return vert;
       }
       return 3;
    }

    private void getVertView(Vertviewdata holder) {

        ArrayList<TitlModel>titlModels=new ArrayList<>();
        for(int i=1;i<=10;i++) {
            TitlModel titlModel = new TitlModel();
            titlModels.add(titlModel);
            titlModel.setTitle("titile" + i);
            ArrayList<Moviemodel> moviemodels = null;
            for (int j = 0; j < 5; j++) {
                Moviemodel moviemodel = new Moviemodel();
                moviemodels = new ArrayList<>();
                moviemodels.add(moviemodel);
                moviemodel.setMovieimg(R.drawable.movie + j);

            }
            titlModel.setMoviemodels(moviemodels);
        }

        VertviewAddapter addapter=new VertviewAddapter(context,Homefrg.horidata());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        holder.recyclerView.setLayoutManager(gridLayoutManager);
        holder.recyclerView.setAdapter(addapter);
        addapter.notifyDataSetChanged();
    }

    private void getHoriView(horiViewdata holder) {
        HorizontalAdd add=new  HorizontalAdd(context,Homefrg.horidata());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(add);
    }

    private void getCarouselveiw(Carouseldata holder) {
        imageListener=new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(Homefrg.carousedata().get(position).getImg());
            }
        };
        holder.carouselView.setImageListener(imageListener);
        holder.carouselView.setPageCount(Homefrg.carousedata().size());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    private class Carouseldata extends RecyclerView.ViewHolder {
        CarouselView carouselView;
        public Carouseldata(View view) {
            super(view);
            carouselView=view.findViewById(R.id.carouselView2);
        }
    }

    private class horiViewdata extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public horiViewdata(View view) {
            super(view);
            recyclerView=view.findViewById(R.id.horiRec);
        }
    }

    private class Vertviewdata extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public Vertviewdata(View view) {
            super(view);

            recyclerView=view.findViewById(R.id.vertcalrec2);
        }
    }
}
