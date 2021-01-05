package Tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.NestedReclerview.CarouselModel;
import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;

import java.util.ArrayList;


public class Homefrg extends Fragment {

  private ArrayList<Object>objects;
  private RecyclerView recyclerView;
    public Homefrg() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_homefrg, container, false);
        objects=new ArrayList<>();
        HomefrgAddapter addapter=new  HomefrgAddapter(getActivity(),getObjects());
        recyclerView=view.findViewById(R.id.homefrgRec);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(addapter);


        // Inflate the layout for this fragment
        return view;
    }
    private ArrayList<Object>getObjects(){
            objects.add(carousedata().get(0));
            objects.add(vertData().get(0));
            objects.add(horidata().get(0));
            return  objects;
    }

    public static ArrayList<Moviemodel> horidata() {
        ArrayList<Moviemodel>moviemodels=new ArrayList<>();
        for(int i=1;i<=10;i++){
            Moviemodel moviemodel=new Moviemodel();
            moviemodel.setMovieimg(R.drawable.movie+i);
            moviemodels.add(moviemodel);

        }

        return moviemodels;
    }

    public static ArrayList<TitlModel> vertData() {
        ArrayList<TitlModel>titlModels=new ArrayList<>();
        for(int i=0;i<10;i++){
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

    public static ArrayList<CarouselModel> carousedata() {
        ArrayList<CarouselModel>arrayList=new ArrayList<>();
        for(int i=1;i<=4;i++){
            arrayList.add(new CarouselModel(R.drawable.movie+i));
        }
        return arrayList;
    }

}