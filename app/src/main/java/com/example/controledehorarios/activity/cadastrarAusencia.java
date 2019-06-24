package com.example.controledehorarios.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.controledehorarios.R;
import com.example.controledehorarios.infra.api.APIService;
import com.example.controledehorarios.models.Curso;
import com.example.controledehorarios.models.DeclaracaoAusencia;
import com.example.controledehorarios.models.Disciplina;
import com.example.controledehorarios.models.Horario;
import com.example.controledehorarios.models.Professor;
import com.example.controledehorarios.models.Turma;
import com.example.controledehorarios.utils.Constants;
import com.example.controledehorarios.utils.SecurityPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static butterknife.ButterKnife.bind;
import static com.example.controledehorarios.models.DiaSemana.SEGUNDA;

public class cadastrarAusencia extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.spinner_turma)
    protected Spinner spinnerTurma;
    @BindView(R.id.edt_justificativa)
    protected EditText edit_justificativa;
    @BindView(R.id.edt_data)
    protected EditText edit_data;
    @BindView(R.id.spinner_horario)
    protected Spinner spinner_hora;
    @BindView(R.id.spinner_professor)
    protected Spinner spinner_professor;
    @BindView(R.id.cadastrar_ausencia_button)
    protected Button btn_salvar_ausencia;
    @BindView(R.id.edt_data_declaracao)
    protected EditText edit_data_declaracao;
    //JSON Array
    private JSONArray user_list;
    private ArrayList<Professor> professores;
    private ArrayList<Turma>turmas;
    private ArrayList<Horario>horarios;

    private APIService apiservice;
    private SecurityPreferences securityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ausencia);
        ButterKnife.bind(this);

        setupViews();
        professores = new ArrayList<>();

        Professor professor1 = new Professor("123","Helcio","0000-000");
        Professor professor2 = new Professor("234","Thiago","12345-000");
        professores.add(professor1);
        professores.add(professor2);


        turmas = new ArrayList<>();
        Disciplina disciplina1 =new Disciplina("Engenharia de Software II");
        Curso curso1 = new Curso("ADS","Tecnologia");
        Turma turma1 = new Turma(professor1,disciplina1,60,curso1,"V periodo");
        turmas.add(turma1);

        horarios = new ArrayList<>();
        Horario horario1 = new Horario(SEGUNDA,"15:00","16:00",turma1);
        horarios.add(horario1);



        ArrayAdapter<Professor> adapterProfessor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,professores);
        adapterProfessor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_professor.setAdapter(adapterProfessor);

        ArrayAdapter<Turma> adapterTurma = new ArrayAdapter(this,android.R.layout.simple_spinner_item,turmas);
        adapterTurma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurma.setAdapter(adapterTurma);

        ArrayAdapter<Horario> adapterHorario = new ArrayAdapter(this,android.R.layout.simple_spinner_item,horarios);
        adapterHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_hora.setAdapter(adapterHorario);



    }


    public void setupViews() {
        securityPreferences = new SecurityPreferences(this);
        apiservice = new APIService(getToken());
        btn_salvar_ausencia.setOnClickListener(this);


    }



    private void registrarAusencia(DeclaracaoAusencia declaracaoAusencia) {
        Call<DeclaracaoAusencia> call = apiservice.ausenciaEndPoint.registrarAusencia(declaracaoAusencia);

        call.enqueue((new Callback<DeclaracaoAusencia>() {
            @Override
            public void onResponse(Call<DeclaracaoAusencia> call, Response<DeclaracaoAusencia> response) {
                if (response.isSuccessful()) {
                    confirmarCadastro(response.body());
                } else {
                    try {
                        Toast.makeText(cadastrarAusencia.this, "" + response.errorBody().string(), Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onFailure(Call<DeclaracaoAusencia> call, Throwable t) {
                Toast.makeText(cadastrarAusencia.this, "Falha na conexão!", Toast.LENGTH_SHORT).show();

            }
        }));
    }

    private void confirmarCadastro(DeclaracaoAusencia declaracaoAusencia) {


        Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Mostrarausencia.class));
        finish();
    }

    private DeclaracaoAusencia criarAusencia() {


        String data = edit_data.getText().toString();
        String justificativa = edit_justificativa.getText().toString();
        Horario horario =(Horario) spinner_hora.getSelectedItem();
        String data_declaracao = edit_data_declaracao.getText().toString();
        Turma turma = (Turma)spinnerTurma.getSelectedItem();
        Professor professor = (Professor) spinner_professor.getSelectedItem();

        DeclaracaoAusencia declaracaoAusencia = new DeclaracaoAusencia(justificativa,data,horario,data_declaracao,turma,professor);
        return declaracaoAusencia;


    }

    private String getToken() {
        String token = securityPreferences.getSavedString(Constants.TOKEN);
        Toast.makeText(this, "" + token, Toast.LENGTH_SHORT).show();
        return token;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cadastrar_ausencia_button:
                registrarAusencia(criarAusencia());
                break;
            default:
                break;
        }

    }


}



