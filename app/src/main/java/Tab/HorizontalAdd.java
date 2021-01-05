package Tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;

import java.util.ArrayList;

public class HorizontalAdd extends RecyclerView.Adapter<HorizontalAdd.Viewholder> {
    private Context context;
    private ArrayList<Moviemodel>moviemodels;
    public HorizontalAdd(Context context, ArrayList<Moviemodel> horidata) {
        this.context=context;
        this.moviemodels=horidata;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                                     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.hordata_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
       Moviemodel moviemodel=moviemodels.get(position);
       TitlModel titlModel=new TitlModel();
       ArrayList<TitlModel>arrayList=new ArrayList<>();
       holder.textView.setText(titlModel.getTitle());
        holder.textView.setText(titlModel.getTitle());
       holder.imageView.setImageResource(moviemodel.getMovieimg());
    }



    @Override
    public int getItemCount() {
        return moviemodels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.hortxt);
            imageView=itemView.findViewById(R.id.horimage);
        }
    }
}
