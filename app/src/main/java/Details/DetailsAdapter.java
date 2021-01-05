package Details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.NestedReclerview.CarouselModel;
import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object>objects;
    public static final int vertical2=1;
    public static final int horizontal=3;
    public  static final int details=2;
    private int image;

    private Context context;
    public DetailsAdapter(DetailsActivity detailsActivity, ArrayList<Object> objects, int image) {
        this.context=detailsActivity;
        this.objects=objects;
        this.image=image;
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

            case details:
                view=layoutInflater.inflate(R.layout.detail_layout,parent,false);
                myviewHolder=new detailview(view);
                break;
            case vertical2:
                view=layoutInflater.inflate(R.layout.detials_vertical_layout,parent,false);
                myviewHolder=new detailsverticalview(view);
                break;
            case horizontal:
                view=layoutInflater.inflate(R.layout.details_hori_layout,parent,false);
                myviewHolder=new detailshoriview(view);




        }
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==details){
            getDetailsview((detailview)holder);
        }
        else if(holder.getItemViewType()==vertical2){
            getDetailsVeticalview((detailsverticalview)holder);
        }else if(holder.getItemViewType()==horizontal){
            getDetailshorizview((detailshoriview)holder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(objects.get(position)instanceof TitlModel){
            return vertical2;
        }
        if(objects.get(position)instanceof CarouselModel){
            return details;
        }if(objects.get(position)instanceof Moviemodel){
            return horizontal;
        }
        return 3;
    }
    private void getDetailshorizview(detailshoriview holder) {

    }

    private void getDetailsVeticalview(detailsverticalview holder) {

    }

    private void getDetailsview(detailview holder) {
        holder.imageView.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    private class detailview extends RecyclerView.ViewHolder {
        TabLayout tabLayout;
        ViewPager pager;
        ImageView imageView;
        public detailview(View view) {
            super(view);
            imageView=view.findViewById(R.id.detailimg);
            tabLayout=view.findViewById(R.id.detailstab);
            pager=view.findViewById(R.id.detailpager);
            DetailtabAddapter detailtabAddapter=new DetailtabAddapter(new FragmentActivity().getSupportFragmentManager());
            pager.setAdapter(detailtabAddapter);
            tabLayout.setupWithViewPager(pager);
        }
    }

    private class detailsverticalview extends RecyclerView.ViewHolder {
        public detailsverticalview(View view) {
            super(view);
        }
    }

    private class detailshoriview extends RecyclerView.ViewHolder {
        public detailshoriview(View view) {
            super(view);
        }
    }
}
