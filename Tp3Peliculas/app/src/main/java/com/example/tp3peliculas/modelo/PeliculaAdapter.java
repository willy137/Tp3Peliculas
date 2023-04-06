package com.example.tp3peliculas.modelo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3peliculas.DetalleActivity;
import com.example.tp3peliculas.R;

import java.util.ArrayList;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {

    private Context context;

    private List<Pelicula> pelis=new ArrayList<>();

    private LayoutInflater inflater;

    public PeliculaAdapter(Context context, List<Pelicula> pelis, LayoutInflater inflater) {
        this.context = context;
        this.pelis = pelis;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.item_view,parent,false);

        return new ViewHolder(root);
    }
    /*
    @SuppressLint("RecyclerView") con esto se sale el error pero no se que hace, lo probe y funciona con esta linea
    */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        holder.tvtitulo.setText((pelis.get(position)).getTitulo());
        /*Glide.with(context)
                .load(pelis.get(position).getPortada())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivportada);*/
        holder.ivportada.setImageResource(pelis.get(position).getPortada());
        holder.tvDescripcion.setText((pelis.get(position)).getDescripcion());
        holder.btdetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("pelis",pelis.get(position));
                Intent intent=new Intent(context, DetalleActivity.class);
                intent.putExtra("pelis",bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pelis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivportada;
        TextView tvtitulo,tvDescripcion;

        Button btdetalle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivportada= itemView.findViewById(R.id.ivPortada);
            tvtitulo=itemView.findViewById(R.id.tvTitulo);
            tvDescripcion=itemView.findViewById(R.id.tvDescrip);
            btdetalle=itemView.findViewById(R.id.btDetalles);
        }
    }

}
