package com.example.tp3peliculas;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3peliculas.databinding.ActivityMainBinding;
import com.example.tp3peliculas.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Context context;

    private List<Pelicula> peliculas=new ArrayList<>();

    private MainActivityViewModel mv;

    /* opcion distinta
     @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.context=this;
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getPelis().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                    RecyclerView rv=binding.rvPelis;

                    GridLayoutManager grilla=new GridLayoutManager( context,1,GridLayoutManager.VERTICAL,false);
                    rv.setLayoutManager(grilla);

                    PeliculaAdapter adap= new PeliculaAdapter(getApplication(), peliculas,getLayoutInflater());
                    rv.setAdapter(adap);
            }
        });
        mv.generarPelis();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.context=this;
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getPelis().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                mv.grid(binding,context,getLayoutInflater());
            }
        });
        mv.generarPelis();
    }

}