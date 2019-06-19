package com.example.controledehorarios.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controledehorarios.R;
import com.example.controledehorarios.activity.declararAusencia;
import com.example.controledehorarios.models.Ausencia;

import java.util.ArrayList;
import java.util.List;

public class ListaAusenciaAdapter extends RecyclerView.Adapter<ListaAusenciaAdapter.ViewHolder> {

    private Context context;
    private List<Ausencia>ausencias = new ArrayList<>();
    private Ausencia ausencia;
    RecyclerView rv_lista_ausencia;


    public ListaAusenciaAdapter(Context context, List<Ausencia> ausencias) {
        this.context = context;
        this.ausencias = ausencias;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView_data;
        private TextView textView_hora;
        private TextView textView_justificativa;


        public ViewHolder(View itemView) {
            super(itemView);

            textView_data = (TextView) itemView.findViewById(R.id.input_data);
            textView_hora = (TextView) itemView.findViewById(R.id.input_horario);
            textView_justificativa = (TextView) itemView.findViewById(R.id.input_justificativa);
        }

    }



    @Override
    public ListaAusenciaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Responsavel por inflar o layout dos itens
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ausencia,parent,
                false);


        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ListaAusenciaAdapter.ViewHolder holder, final int posicao) {
        //Responsavel por settar os valores na view
        ausencia = this.ausencias.get(posicao);
        holder.textView_justificativa.setText(String.valueOf(ausencia.getJustificativa()));
        holder.textView_hora.setText(String.valueOf(ausencia.getHoraInicio()));
        holder.textView_data.setText(String.valueOf(ausencia.getData()));

        setupOnClickListener(holder,ausencia);
        setupOnLongClickListener(holder,ausencia,posicao);

    }

    private void setupOnLongClickListener(final ViewHolder holder, final Ausencia ausencia,int posicao) {
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_opcoes, popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.op_editar:
                                editarAusencia(holder.itemView,ausencia, posicao);
                                break;
                            case R.id.op_remover:
                                removerAusencia(ausencia, posicao);
                                break;

                        }
                        return true;
                    }

                });
                popupMenu.show();
                return true;

            }


        });
    }



    public void editarAusencia(View view,Ausencia ausencia, int posicao) {

        Intent intent = new Intent(context, declararAusencia.class);

        intent.putExtra("ausenciaId", ausencia.getId());
        context.startActivity(intent);
        notifyItemChanged(posicao);

    }
    public void removerAusencia(Ausencia ausencia, int posicao){
        this.ausencias.remove(ausencia);
        notifyItemRemoved(posicao);
        notifyItemRangeChanged(posicao,getItemCount());

    }

    public void setupOnClickListener(ViewHolder holder, final Ausencia ausencia) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Ausencia no dia: "+ausencia.getData(),Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public long getItemId(int position){
        return ausencias.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return this.ausencias.size();
    }

}
