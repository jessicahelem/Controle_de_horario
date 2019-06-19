package com.example.controledehorarios.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.controledehorarios.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void add_aulas(View view) {
        startActivity(new Intent(this,ActivityMostrarAula.class ));
    }

    public void add_ausencia(View view) {
        startActivity(new Intent(this,Mostrarausencia.class ));
    }
}
