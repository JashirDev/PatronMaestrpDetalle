package com.example.gamer.patronmaestrodetalle.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamer.patronmaestrodetalle.entidades.Personajes;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonaje>{
   ArrayList<Personajes>lista;

    public AdaptadorPersonajes(ArrayList<Personajes> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderPersonaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonaje holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderPersonaje extends RecyclerView.ViewHolder {
        public ViewHolderPersonaje(View itemView) {
            super(itemView);
        }
    }
}
