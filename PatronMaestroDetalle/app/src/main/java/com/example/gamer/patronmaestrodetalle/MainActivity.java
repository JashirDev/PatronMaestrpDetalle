package com.example.gamer.patronmaestrodetalle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamer.patronmaestrodetalle.fragmentos.ListaPersonajeFragment;

public class MainActivity extends AppCompatActivity implements ListaPersonajeFragment.OnFragmentInteractionListener{
ListaPersonajeFragment listaPersonajeFragment;
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
}
