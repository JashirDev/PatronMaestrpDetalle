package com.example.gamer.patronmaestrodetalleorientacionpantalla.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamer.patronmaestrodetalleorientacionpantalla.R;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.entidades.Personajes;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.utilidades.Utilidades;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonaje> implements View.OnClickListener{
   ArrayList<Personajes>lista;
   private View.OnClickListener listener;

    public AdaptadorPersonajes(ArrayList<Personajes> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolderPersonaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.card_itemlist,null,false);
       RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);//con esto asigno ancho y alto del reciclerview de madura obligatoria
        v.setLayoutParams(layoutParams);

        v.setOnClickListener(this);
        return new ViewHolderPersonaje(v);
    }

    public void setonclickListener( View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonaje holder, int position) {
        holder.tvnombre.setText(lista.get(position).getNombre());
        if(Utilidades.portrait){
            holder.tvDescripcion.setText(lista.get(position).getInfo());

        }
        holder.tvfoto.setImageResource(lista.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        if(lista!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderPersonaje extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNombre)
        TextView tvnombre;
        @BindView(R.id.tvfoto)
        ImageView tvfoto;
       // @BindView(R.id.tvDescripcion)
        TextView tvDescripcion;

        public ViewHolderPersonaje(View itemView) {
            super(itemView);
            ButterKnife.bind(this ,itemView);
            if(Utilidades.portrait){
                tvDescripcion= itemView.findViewById(R.id.tvDescripcion);
            }
            //itemView.setOnClickListener();

        }
    }
}
