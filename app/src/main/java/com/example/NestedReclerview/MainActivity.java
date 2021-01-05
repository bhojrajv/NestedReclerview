package com.example.NestedReclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.primeamazon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import Tab.ViewpagerAddapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
   private HomedataAdapter adapterdata;
  private   ArrayList<Object> objects;
  private   BottomNavigationView bottomNavigationView;
   private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.homdataRec);
        toolbar=findViewById(R.id.homeToolbar);
         tabLayout=findViewById(R.id.tablayout);
         bottomNavigationView=findViewById(R.id.homenav);
         pager=findViewById(R.id.viewpager);
         setSupportActionBar(toolbar);
         getSupportActionBar();
         ViewpagerAddapter viewpagerAddapter=new ViewpagerAddapter(getSupportFragmentManager());
         pager.setAdapter(viewpagerAddapter);
         tabLayout.setupWithViewPager(pager);

        objects=new ArrayList<>();
        adapterdata=new HomedataAdapter(this,getObjects());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterdata);
        adapterdata.notifyDataSetChanged();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
 bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
     @Override
     public void onNavigationItemReselected(@NonNull MenuItem item) {
         switch (item.getItemId()){
             case R.id.home:
                 pager.setVisibility(View.GONE);
                 recyclerView.setVisibility(View.VISIBLE);
         }
     }
 });

    }
    public ArrayList<Object>getObjects()
    {
        objects.add(caroseldatq().get(0));
        objects.add(verticaldata().get(0));
       objects.add(horizontdata().get(0));
        return objects;
    }

    public static ArrayList<TitlModel> verticaldata() {
             ArrayList<TitlModel>titlModels=new ArrayList<>();
             for(int i=1;i<=10;i++){
                 TitlModel titlModel=new TitlModel();
                 titlModels.add(titlModel);
                 titlModel.setTitle("titile"+i);
                 ArrayList<Moviemodel>moviemodels=null;
                 for (int j=0;j<5;j++){
                     Moviemodel moviemodel =new Moviemodel();
                     moviemodels=new ArrayList<>();
                     moviemodels.add(moviemodel);
                     moviemodel.setMovieimg(R.drawable.movie+j);
                     titlModel.setMoviemodels(moviemodels);

                 }


             }

        return titlModels;
    }

    public static ArrayList<CarouselModel> caroseldatq() {
           ArrayList<CarouselModel>arrayList=new ArrayList<>();
           for(int i=1;i<=4;i++){
               arrayList.add(new CarouselModel(R.drawable.movie+i));
           }
         return arrayList;
    }

    public  static ArrayList<Moviemodel> horizontdata() {
        ArrayList<Moviemodel>moviemodels=new ArrayList<>();
        for(int i=1;i<=10;i++){
          Moviemodel moviemodel=new Moviemodel();
          moviemodel.setMovieimg(R.drawable.movie+i);
          moviemodels.add(moviemodel);

        }

        return moviemodels;
    }

}