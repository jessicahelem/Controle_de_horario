package com.example.controledehorarios.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controledehorarios.R;
import com.example.controledehorarios.adapters.ListaAusenciaAdapter;
import com.example.controledehorarios.infra.api.APIService;
import com.example.controledehorarios.models.DeclaracaoAusencia;
import com.example.controledehorarios.utils.Constants;
import com.example.controledehorarios.utils.SecurityPreferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mostrarausencia extends AppCompatActivity {

    @BindView(R.id.rv_lista_ausencia) protected RecyclerView rvAusencias;


    public List<DeclaracaoAusencia> declaracaoAusenciaInteresses = new ArrayList<>();
    private APIService apiService;
    private SecurityPreferences securityPreferences;
    private long ausencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausencia);
        ButterKnife.bind(this);


         setupViews();
         this.setTitle("Ausências");


    }

    private void setupViews() {
        securityPreferences = new SecurityPreferences(this);
        apiService = new APIService(getToken());
        Intent intent = getIntent();
        ausencia = intent.getLongExtra(Constants.AUSENCIA_SELECIONADA,0);

        if (ausencia != 0){
            getAusencias();

        }
        else
            Toast.makeText(this,"Ausencia não encontrada",Toast.LENGTH_SHORT).show();

    }

    private void getAusencias() {
        Call<List<DeclaracaoAusencia>> call = apiService.ausenciaEndPoint.getAusenciaUnica();
        call.enqueue(new Callback<List<DeclaracaoAusencia>>() {
            @Override
            public void onResponse(Call<List<DeclaracaoAusencia>> call, Response<List<DeclaracaoAusencia>> response) {
                if (response.isSuccessful()){
                    exibirAusencias((List<DeclaracaoAusencia>) response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DeclaracaoAusencia>> call, Throwable t) {
                Toast.makeText(Mostrarausencia.this,"Falha na conexão",Toast.LENGTH_SHORT).show();



            }
        });
    }

    private void exibirAusencias(List<DeclaracaoAusencia> declaracaoAusencia) {


        ListaAusenciaAdapter listaAusenciaAdapter = new ListaAusenciaAdapter(this,this, declaracaoAusencia);
        rvAusencias.setAdapter(listaAusenciaAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvAusencias.setHasFixedSize(true);
        rvAusencias.setLayoutManager(linearLayoutManager);
    }

   private String getToken(){
        return securityPreferences.getSavedString(Constants.TOKEN);
   }




   public void add_ausencia(View view) {
        startActivity(new Intent(this, cadastrarAusencia.class ));
    }
}
