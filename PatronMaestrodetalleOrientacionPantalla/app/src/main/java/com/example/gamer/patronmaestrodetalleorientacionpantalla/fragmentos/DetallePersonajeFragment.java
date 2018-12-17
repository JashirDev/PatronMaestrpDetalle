package com.example.gamer.patronmaestrodetalleorientacionpantalla.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamer.patronmaestrodetalleorientacionpantalla.R;
import com.example.gamer.patronmaestrodetalleorientacionpantalla.entidades.Personajes;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetallePersonajeFragment extends Fragment {

    @BindView(R.id.detalle_descripcion)
    TextView textodetalle;
    @BindView(R.id.detalleimagen)
    ImageView imagendetalle;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetallePersonajeFragment() {
        // Required empty public constructor
    }

    public static DetallePersonajeFragment newInstance(String param1, String param2) {
        DetallePersonajeFragment fragment = new DetallePersonajeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_detalle_personaje, container, false);
        ButterKnife.bind(this,v);
        Bundle objetorecivido = getArguments();
        Personajes personajes=null;
        if(objetorecivido!=null){
            personajes =(Personajes) objetorecivido.getSerializable("objeto");
            asignarinformacion(personajes);


        }
        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    public void asignarinformacion(Personajes personajes){
        imagendetalle.setImageResource(personajes.getImagendetalle());
        textodetalle.setText(personajes.getDescridetalle());
    }
}
