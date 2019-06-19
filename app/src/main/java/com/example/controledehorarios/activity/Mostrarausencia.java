package com.example.controledehorarios.activity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.controledehorarios.R;
import com.example.controledehorarios.adapters.ListaAusenciaAdapter;
import com.example.controledehorarios.models.Ausencia;
import com.example.controledehorarios.models.Turma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mostrarausencia extends AppCompatActivity {

    private RecyclerView rvAusencias;
    private Ausencia ausencia;
    private TextView id_justificativa;
    private TextView id_data;
    private TextView id_hora;
    public List<Ausencia> ausencias = new ArrayList<>();


    private int adapterLayout = android.R.layout.simple_list_item_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausencia);


         rvAusencias = this.findViewById(R.id.rv_lista_ausencia);
//         id_justificativa = findViewById(R.id.input_justificativa);
//         id_data = findViewById(R.id.input_data);
//         id_hora = findViewById(R.id.input_horario);

        Intent intent = getIntent();


//        id_justificativa.setText(intent.getStringExtra("justificativa"));
//        id_data.setText(intent.getStringExtra("data"));
//        id_hora.setText(intent.getStringExtra("hora"));


        atualizaLista();

        rvAusencias.setHasFixedSize(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();




    }

    public void atualizaLista(){


        //Crio a instância do Adapter e associo com a RV
        ListaAusenciaAdapter adapter = new ListaAusenciaAdapter(this,getAusencias());
        rvAusencias.setAdapter(adapter);


        //Informar o gerenciador de layout da RV
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvAusencias.setLayoutManager(layoutManager);

    }

    private List<Ausencia> getAusencias() {
            return ausencias;
        }



    public void add_ausencia(View view) {
        startActivity(new Intent(this,declararAusencia.class ));
    }
}
