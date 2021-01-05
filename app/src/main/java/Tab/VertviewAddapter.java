package Tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NestedReclerview.Moviemodel;
import com.example.primeamazon.R;
import com.example.NestedReclerview.TitlModel;

import java.util.ArrayList;

public class VertviewAddapter extends RecyclerView.Adapter<VertviewAddapter.Viewholder> {
    private Context context;
    private ArrayList<TitlModel>titlModels;
    private ArrayList<Moviemodel>moviemodels;
    public VertviewAddapter(Context context, ArrayList<Moviemodel> vertData) {
        this.context=context;
        this.moviemodels=vertData;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.verdata_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

       holder.imageView.setImageResource(moviemodels.get(position).getMovieimg());

    }


    @Override
    public int getItemCount() {
        return moviemodels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.verimg);
        }
    }
}
