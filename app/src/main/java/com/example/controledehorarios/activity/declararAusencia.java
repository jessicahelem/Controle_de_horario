package com.example.controledehorarios.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.controledehorarios.R;
import com.example.controledehorarios.adapters.ListaAusenciaAdapter;
import com.example.controledehorarios.models.Ausencia;
import com.example.controledehorarios.models.Turma;

import java.util.ArrayList;
import java.util.List;

public class declararAusencia extends AppCompatActivity {

    public Spinner spinnerTurma;
    public EditText edit_justificativa;
    public EditText edit_data;
    public EditText edit_hora;
    public Switch switch_ausencia;
    private Ausencia ausencia;
    public Button salvar_ausencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausencia);

        spinnerTurma = findViewById(R.id.spinner_turma);
        edit_justificativa = findViewById(R.id.edit_justificativa);
        edit_data = findViewById(R.id.edit_data);
        edit_hora = findViewById(R.id.edit_hora);
        switch_ausencia = findViewById(R.id.switch_ausencia);
        salvar_ausencia = findViewById(R.id.cadastrar_ausencia_button);
        salvar_ausencia.setOnClickListener(onSave);
    }

    private View.OnClickListener onSave = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String justificativa = edit_justificativa.getText().toString();
            String data = edit_data.getText().toString();
            String hora = edit_hora.getText().toString();
            Boolean switchAusencia = Boolean.valueOf(switch_ausencia.getText().toString());



            if (data.trim().isEmpty()) {
                edit_data.setError("O campo não pode estar vazio!");
            }
            else if (hora.trim().isEmpty()) {
                edit_hora.setError("O campo não pode estar vazio!");
            }
            else{
                ausencia.setData(data);
                ausencia.setJustificativa(justificativa);
                ausencia.setHoraInicio(hora);
                ausencia.setFaltou(switchAusencia);


            }

        }
    };

        public void atualizarSpinner(){
        ArrayAdapter<Turma> arrayAdapter = new ArrayAdapter<Turma>(this, android.R.layout.simple_spinner_dropdown_item, getListaTurma());
        ArrayAdapter<Turma> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTurma.setAdapter(spinnerArrayAdapter);
    }

    public List<Turma> getListaTurma(){
        List<Turma> turmas = new ArrayList<>();
        int i;
        for (i=0; i < turmas.size(); i++){
            turmas.get(i).getEspecificacao();

        }
        return turmas;
    }



    public void cadastrar_ausencia(View view) {

        String justificativa = edit_justificativa.getText().toString();
        String data = edit_data.getText().toString();
        String hora = edit_hora.getText().toString();
        Boolean switchAusencia = Boolean.valueOf(switch_ausencia.getText().toString());



        if (data.trim().isEmpty()) {
            edit_data.setError("O campo não pode estar vazio!");
        }
        else if (hora.trim().isEmpty()) {
            edit_hora.setError("O campo não pode estar vazio!");
        }
        else{
            ausencia.setData(data);
            ausencia.setJustificativa(justificativa);
            ausencia.setHoraInicio(hora);
            ausencia.setFaltou(switchAusencia);


        }


    }
}
