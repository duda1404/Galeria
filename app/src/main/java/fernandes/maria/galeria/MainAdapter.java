package fernandes.maria.galeria;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Classe Adapter, a qual será responsável por construir e preencher cada item da lista do RecycleView
public class MainAdapter extends RecyclerView.Adapter {

    MainActivity mainActivity;
    List<String> photos;

    public MainAdapter(MainActivity mainActivity, List<String> photos) {
        this.mainActivity = mainActivity;
        this.photos = photos;
    }

    //Responsável por criar os elementos de interface para um item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    //Recebe o ViewHolder criado por onCreateViewHolder e preenche os elementos de UI com os dados do item
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        //A função preenche o ImageView com a foto correspondente
        ImageView imPhoto = holder.itemView.findViewById(R.id.imItem);
        int w = (int) mainActivity.getResources().getDimension(R.dimen.itemWidth);
        int h = (int) mainActivity.getResources().getDimension(R.dimen.itemHeight);
        Bitmap bitmap = Utils.getBitmap(photos.get(position), w, h);
        imPhoto.setImageBitmap(bitmap);
        imPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.startPhotoActivity(photos.get(position));
            }
        });
    }


    //Informa quantos elementos a lista possui
    @Override
    public int getItemCount() {
        return photos.size(); //Retorna quantos itens o Recycle view tem na lista.
    }


}



