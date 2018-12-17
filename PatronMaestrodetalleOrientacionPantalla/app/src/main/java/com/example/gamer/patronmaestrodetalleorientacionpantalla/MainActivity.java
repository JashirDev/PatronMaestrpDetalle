package com.example.gamer.patronmaestrodetalleorientacionpantalla;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamer.patronmaestrodetalleorientacionpantalla.entidades.Personajes;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.fragmentos.DetallePersonajeFragment;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.fragmentos.ListaPersonajeFragment;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.interfaces.ComunicacionFragments;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity implements ComunicacionFragments,ListaPersonajeFragment.OnFragmentInteractionListener,DetallePersonajeFragment.OnFragmentInteractionListener{
    ListaPersonajeFragment listaPersonajeFragment;
    DetallePersonajeFragment detallePersonajeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedor)!=null){//si existe
            Utilidades.portrait=true;
           if(savedInstanceState !=null){
               return;
           }

            listaPersonajeFragment=new ListaPersonajeFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,listaPersonajeFragment).commit();
        }else{
            Utilidades.portrait=false;
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarpersonajes(Personajes personajes) {
        detallePersonajeFragment=(DetallePersonajeFragment) this.getSupportFragmentManager().findFragmentById(R.id.land_detallefragment);//con esto va ser igual al espacio al que le esta asignando

        if(detallePersonajeFragment!=null && findViewById(R.id.contenedor)==null){//se preunta si se genero la instancia (lanscape) y si la instancia del portrai no esta
            detallePersonajeFragment.asignarinformacion(personajes);
        }else{//de lo contratrio se hace el portrait
            detallePersonajeFragment= new DetallePersonajeFragment();
            Bundle bundleenvio = new Bundle();
            bundleenvio.putSerializable("objeto",personajes);//mando lso personajes como objetos
            detallePersonajeFragment.setArguments(bundleenvio);

            //cargar el fragment en el activity
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,detallePersonajeFragment).addToBackStack(null).commit();//backstack para un cambio mas eficiente

        }



        }
}

