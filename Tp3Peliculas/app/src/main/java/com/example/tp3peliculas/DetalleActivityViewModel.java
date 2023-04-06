package com.example.tp3peliculas;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp3peliculas.databinding.ActivityDetalleBinding;
import com.example.tp3peliculas.modelo.Pelicula;

public class DetalleActivityViewModel extends AndroidViewModel {

    private TextView tv1,tv2,tv3,tv4;
    private ImageView im;
    private Pelicula peliculas;

    public DetalleActivityViewModel(@NonNull Application application) {
        super(application);
    }

    /*public void cargar(Bundle bun){
        peliculas= (Pelicula) bun.getSerializable("pelis");
        tv1.setText(peliculas.getTitulo());
        im.setImageResource(peliculas.getPortada());
        tv2.setText(peliculas.getDirector());
        tv3.setText(peliculas.getDescripcion());
        tv4.setText(peliculas.getActores());
    }*/

    public void cargarTodo(ActivityDetalleBinding binding, Bundle bun){
        peliculas= (Pelicula) bun.getSerializable("pelis");
        Log.d("Salida", peliculas.getDescripcion());
        binding.tvTituloD.setText(peliculas.getTitulo());
        binding.ivPortadaD.setImageResource(peliculas.getPortada());
        binding.tvDirectorD.setText(peliculas.getDirector());
        binding.tvDescripD.setText(peliculas.getDescripcion());
        binding.tvActoresD.setText(peliculas.getActores());
    }

    /*
    */

}
