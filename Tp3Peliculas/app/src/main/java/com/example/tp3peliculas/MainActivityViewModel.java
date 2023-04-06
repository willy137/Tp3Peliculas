package com.example.tp3peliculas;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3peliculas.databinding.ActivityMainBinding;
import com.example.tp3peliculas.modelo.Pelicula;
import com.example.tp3peliculas.modelo.PeliculaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<List<Pelicula>> pelis=null;

    private List<Pelicula> peliculas=new ArrayList<>();



    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }
//entendi que lo teniamos que hacer al grid en el viewmodel
    public void grid(ActivityMainBinding binding, Context context1, LayoutInflater layout){
        RecyclerView rv=binding.rvPelis;

        GridLayoutManager grilla=new GridLayoutManager(context1,1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grilla);

        PeliculaAdapter adap= new PeliculaAdapter(getApplication(), peliculas,layout);
        rv.setAdapter(adap);
    }

    public LiveData<List<Pelicula>> getPelis() {
        if(pelis==null){
            this.pelis=new MutableLiveData<>();
        }
        return pelis;
    }

    public void generarPelis(){
        peliculas.add(new Pelicula("End Game",
                "Días después del Chasquido de Thanos, Tony Stark y Nebula quedan" +
                        " a la deriva en el espacio exterior. Ambos son rescatados por Carol Danvers y se reúnen con los " +
                        "Vengadores―Steve Rogers, Thor, Bruce Banner, Natasha Romanoff y James Rhodes—y Rocket en el Complejo de los Vengadores."
                ,R.drawable.endgame2, "Anthony y Joe Russo","Robert Downey Jr, Scarlett Johansson,Chris Evans,Chris Hemsworth"));
        peliculas.add(new Pelicula("Scream VI",
                "Cuatro supervivientes de los asesinatos de Ghostface dejan atrás Woodsboro para empezar de nuevo en Nueva York. " +
                        "Sin embargo, no tardan en convertirse en el objetivo de un nuevo asesino en serie."
                ,R.drawable.scream, " Tyler Gillett, Matt Bettinelli-Olpin","Jenna Ortega, Melissa Barrera,Jack Champion"));
        peliculas.add(new Pelicula("The Batman",
                "Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia." +
                        " Además, entra en conflicto con un asesino en serie conocido como el Acertijo."
                ,R.drawable.batman, "Matt Reeves","Robert Pattinson, Zoe Kravitz,Paul Dani, Cristian Bale"));
        pelis.setValue(peliculas);
    }
}
