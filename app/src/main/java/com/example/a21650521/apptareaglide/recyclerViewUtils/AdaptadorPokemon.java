package com.example.a21650521.apptareaglide.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a21650521.apptareaglide.R;

import java.util.ArrayList;

/**
 * Created by 21650521 on 05/02/2018.
 */

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.VHPokemon> implements View.OnClickListener {
    private ArrayList<ItemPokemon> datos;
    private View.OnClickListener listener;

    public AdaptadorPokemon(ArrayList<ItemPokemon> datos) {
        this.datos = datos;
    }

    @Override
    public VHPokemon onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent,false);
                v.setOnClickListener(this);
        VHPokemon vhp = new VHPokemon(v);
        return vhp;
    }

    @Override
    public void onBindViewHolder(VHPokemon holder, int position) {

        holder.tvCodigo.setText(datos.get(position).getCodigo());
        holder.tvNombre.setText(datos.get(position).getNombre());
    }

    public static class VHPokemon extends RecyclerView.ViewHolder{
        private TextView tvCodigo;
        private TextView tvNombre;

        public TextView getTvCodigo() {
            return tvCodigo;
        }

        public TextView getTvNombre() {
            return tvNombre;
        }

        public VHPokemon(View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNombre = itemView.findViewById(R.id.tvNombre);
        }
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener !=null){
            listener.onClick(v);
        }
    }
}
