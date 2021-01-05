package Details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.NestedReclerview.CarouselModel;
import com.example.NestedReclerview.MainActivity;
import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private DetailsAdapter adapterdata;
    private ArrayList<Object> objects;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        recyclerView=findViewById(R.id.detailrec);
        bottomNavigationView=findViewById(R.id.detailshomenav);
        int image=getIntent().getExtras().getInt("value");
        objects=new ArrayList<>();
        adapterdata=new DetailsAdapter(this,getObjects(),image);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterdata);
        //adapterdata.notifyDataSetChanged();

       // CarouselModel carouselModel=new CarouselModel(image);
bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent=new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
        }
    }
});
    }
    public ArrayList<Object>getObjects()
    {
        objects.add(detialmethod().get(0));
        objects.add(detailverticaldata().get(0));
        objects.add(detailhorizontdata().get(0));
        return objects;
    }

    public static ArrayList<TitlModel> detailverticaldata() {
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

    public static ArrayList<CarouselModel> detialmethod(){
        ArrayList<CarouselModel>arrayList=new ArrayList<>();
        for(int i=1;i<=4;i++){
            arrayList.add(new CarouselModel(R.drawable.movie+i));
        }
        return arrayList;
    }

    public  static ArrayList<Moviemodel> detailhorizontdata() {
        ArrayList<Moviemodel>moviemodels=new ArrayList<>();
        for(int i=1;i<=10;i++){
            Moviemodel moviemodel=new Moviemodel();
            moviemodel.setMovieimg(R.drawable.movie+i);
            moviemodels.add(moviemodel);

        }

        return moviemodels;
    }
}