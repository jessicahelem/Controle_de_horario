package com.example.controledehorarios.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controledehorarios.R;
import com.example.controledehorarios.activity.Mostrarausencia;
import com.example.controledehorarios.activity.cadastrarAusencia;
import com.example.controledehorarios.models.DeclaracaoAusencia;
import com.example.controledehorarios.utils.Constants;

import java.util.List;

public class ListaAusenciaAdapter extends RecyclerView.Adapter<ListaAusenciaAdapter.ViewHolder> {

    private Activity activity;
    private Context context;
    private List<DeclaracaoAusencia> declaracaoAusenciaInteresses;


    public ListaAusenciaAdapter(Activity activity,Context context, List<DeclaracaoAusencia> declaracaoAusenciaInteresses) {
        this.activity = activity;
        this.context = context;
        this.declaracaoAusenciaInteresses = declaracaoAusenciaInteresses;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_data;
        public TextView textView_hora;
        public TextView textView_justificativa;
        public TextView text_data_declaracao;
        public TextView text_turma;
        public TextView text_professor;




        public ViewHolder(View itemView) {
            super(itemView);

            textView_data = (TextView) itemView.findViewById(R.id.input_data);
            textView_hora = (TextView) itemView.findViewById(R.id.input_horario_ausencia);
            textView_justificativa = (TextView) itemView.findViewById(R.id.input_justificativa);
            text_data_declaracao = itemView.findViewById(R.id.input_data_declaracao);
            text_turma = itemView.findViewById(R.id.input_turma_ausencia);
            text_professor = itemView.findViewById(R.id.input_professor);


        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Responsavel por inflar o layout dos itens
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_ausencia,parent,
                false);


        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }


    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        //Responsavel por settar os valores na view
        final DeclaracaoAusencia declaracaoAusencia = declaracaoAusenciaInteresses.get(position);

        holder.textView_justificativa.setText(declaracaoAusencia.getJustificativa());
        holder.textView_hora.setText((CharSequence) declaracaoAusencia.getHorario());
        holder.textView_data.setText(declaracaoAusencia.getData());
        holder.text_data_declaracao.setText(declaracaoAusencia.getDataDeclaracao());
        holder.text_turma.setText((CharSequence) declaracaoAusencia.getTurma());
        holder.text_professor.setText((CharSequence) declaracaoAusencia.getProfessor());

        setupOnLongClickListener(holder, declaracaoAusencia,position);

        holder.itemView.setOnClickListener(v -> {
            Intent intent =new Intent(activity, Mostrarausencia.class);
            intent.putExtra(Constants.AUSENCIA_SELECIONADA, declaracaoAusencia.getId());
            context.startActivity(intent);
        });

    }

    private void setupOnLongClickListener(final ViewHolder holder, final DeclaracaoAusencia declaracaoAusencia, int posicao) {
        holder.itemView.setOnLongClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu_opcoes, popupMenu.getMenu());


            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.op_editar:
                        editarAusencia(holder.itemView, declaracaoAusencia, posicao);
                        break;
                    case R.id.op_remover:
                        removerAusencia(declaracaoAusencia, posicao);
                        break;

                }
                return true;
            });
            popupMenu.show();
            return true;

        });
    }



    public void editarAusencia(View view, DeclaracaoAusencia declaracaoAusencia, int posicao) {

        Intent intent = new Intent(context, cadastrarAusencia.class);

        intent.putExtra("ausenciaId", declaracaoAusencia.getId());
        context.startActivity(intent);
        notifyItemChanged(posicao);

    }
    public void removerAusencia(DeclaracaoAusencia declaracaoAusencia, int posicao){
        this.declaracaoAusenciaInteresses.remove(declaracaoAusencia);
        notifyItemRemoved(posicao);
        notifyItemRangeChanged(posicao,getItemCount());

    }

    public void setupOnClickListener(ViewHolder holder, final DeclaracaoAusencia declaracaoAusencia) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"DeclaracaoAusencia no dia: "+ declaracaoAusencia.getData(),Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public long getItemId(int position){
        return declaracaoAusenciaInteresses.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return this.declaracaoAusenciaInteresses.size();
    }

}
