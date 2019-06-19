package com.example.controledehorarios.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.controledehorarios.R;
import com.example.controledehorarios.adapters.ListaAusenciaAdapter;
import com.example.controledehorarios.models.Ausencia;
import com.example.controledehorarios.models.Turma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class declararAusencia extends AppCompatActivity {

    public Spinner spinnerTurma;
    public EditText edit_justificativa;
    public EditText edit_data;
    public EditText edit_hora;
    public Switch switch_ausencia;
    public Button salvar_ausencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ausencia);
        spinnerTurma = findViewById(R.id.spinner_turma);
        edit_justificativa = findViewById(R.id.edt_justificativa);
        edit_data = findViewById(R.id.edt_data);
        edit_hora = findViewById(R.id.edt_hora);
        switch_ausencia = findViewById(R.id.switch_ausencia);
        salvar_ausencia = findViewById(R.id.cadastrar_ausencia_button);

        atualizarSpinner();



    }

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



    public void selecionarAusencia(View view) {

        Switch switchAusencia = (Switch) view;

        if ( switchAusencia.isChecked()){
            Toast.makeText(this, "Ausente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Não selecionado", Toast.LENGTH_SHORT).show();
        }

    }

    public void cadastrar_ausencia(View view) {


        String justificativa = edit_justificativa.getText().toString();
        String data = edit_data.getText().toString();
        String hora = edit_hora.getText().toString();
        Boolean switchAusencia = switch_ausencia.isChecked();

        if (justificativa.trim().isEmpty()) {
            edit_justificativa.setError("O campo não pode estar vazio!");
        }

        if (data.trim().isEmpty()) {
            edit_data.setError("O campo não pode estar vazio!");
        }
        if (hora.trim().isEmpty()) {
            edit_hora.setError("O campo não pode estar vazio!");
        } else {
           Ausencia ausencia = new Ausencia(justificativa, data, hora);

           Intent intent = new Intent(this, Mostrarausencia.class);

            intent.putExtra("justificativa", ausencia.getJustificativa());
            intent.putExtra("data", ausencia.getData());
            intent.putExtra("hora", ausencia.getHoraInicio());
            Toast toast = Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            startActivity(intent);





        }


    }
}
