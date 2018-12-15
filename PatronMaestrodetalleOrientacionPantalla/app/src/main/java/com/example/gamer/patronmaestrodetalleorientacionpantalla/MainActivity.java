package com.example.gamer.patronmaestrodetalleorientacionpantalla;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamer.patronmaestrodetalleorientacionpantalla.entidades.Personajes;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.fragmentos.DetallePersonajeFragment;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.fragmentos.ListaPersonajeFragment;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.interfaces.ComunicacionFragments;

public class MainActivity extends AppCompatActivity implements ComunicacionFragments,ListaPersonajeFragment.OnFragmentInteractionListener,DetallePersonajeFragment.OnFragmentInteractionListener{
    ListaPersonajeFragment listaPersonajeFragment;
    DetallePersonajeFragment detallePersonajeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajeFragment=new ListaPersonajeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,listaPersonajeFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarpersonajes(Personajes personajes) {
        detallePersonajeFragment= new DetallePersonajeFragment();
        Bundle bundleenvio = new Bundle();
        bundleenvio.putSerializable("objeto",personajes);//mando lso personajes como objetos
        detallePersonajeFragment.setArguments(bundleenvio);

        //cargar el fragment en el activity
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,detallePersonajeFragment).addToBackStack(null).commit();//backstack para un cambio mas eficiente
    }
}

