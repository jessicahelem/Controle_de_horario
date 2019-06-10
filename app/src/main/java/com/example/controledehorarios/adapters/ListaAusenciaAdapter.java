package com.example.controledehorarios.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.controledehorarios.R;
import com.example.controledehorarios.models.Ausencia;

import java.util.List;

public class ListaAusenciaAdapter extends RecyclerView.Adapter<ListaAusenciaAdapter.ViewHolder> {

    private Context context;
    private List<Ausencia>ausencias;



    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView textView_data;
        protected TextView textView_hora;
        protected TextView textView_justificativa;


        public ViewHolder(View itemView) {
            super(itemView);

            textView_data = (TextView) itemView.findViewById(R.id.input_data);
            textView_hora = (TextView) itemView.findViewById(R.id.input_horario);
            textView_justificativa = (TextView) itemView.findViewById(R.id.input_justificativa);
        }

    }
    public ListaAusenciaAdapter(Context context, List<Ausencia> ausencias) {
        this.context = context;
        this.ausencias = ausencias;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.item_ausencia,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

       final Ausencia ausencia = this.ausencias.get(i);
        viewHolder.textView_data.setText((CharSequence) ausencia.getData());
        viewHolder.textView_hora.setText((CharSequence) ausencia.getHoraInicio());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public int getCount(){
        return ausencias.size();
    }

}
