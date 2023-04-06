package com.example.tp3peliculas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3peliculas.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private DetalleActivityViewModel mv;

    private Context context;

    private ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.context=this;
        Intent intent=getIntent();
        Bundle bun=intent.getBundleExtra("pelis");
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleActivityViewModel.class);
        mv.cargarTodo(binding,bun);
        //opcion 2
        //mv.cargar(bun);
        //que cada uno de los textview tenga getters
        // y empezar a modificar con el binding.tvActoresD.setText(); asi uno por uno
        binding.btVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }
}