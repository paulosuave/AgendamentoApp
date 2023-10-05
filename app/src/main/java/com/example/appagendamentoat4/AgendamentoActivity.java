package com.example.appagendamentoat4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgendamentoActivity extends AppCompatActivity {
    public String strLocal;
    public String strData;
    public String strHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);


        Spinner spnLocal = findViewById(R.id.spnLocal);
        spnLocal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strLocal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner spnData = findViewById(R.id.spnData);
        spnData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strData = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spnHora = findViewById(R.id.spnHora);
        spnHora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strHora = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button avancarConfirmacao = findViewById(R.id.btnAvancarConfirmacao);
        avancarConfirmacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox declaro = findViewById(R.id.chkDeclaro);

                if (!declaro.isChecked()) {
                    Toast.makeText(AgendamentoActivity.this,
                            "Os termos devem ser aceitos",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent it = getIntent();
                Bundle dados = it.getExtras();
                String nome = "";
                String dataNascimento = "";
                String cpf = "";
                String sexo = "";
                String escolaridade = "";

                if (dados != null) {
                    nome = dados.getString("nome");
                    dataNascimento = dados.getString("dataNascimento");
                    cpf = dados.getString("cpf");
                    sexo = dados.getString("sexo");
                    escolaridade = dados.getString("escolaridade");
                }


                Bundle dadosAgendamento = new Bundle();
                dadosAgendamento.putString("nome", nome);
                dadosAgendamento.putString("cpf", cpf);
                dadosAgendamento.putString("dataNascimento", dataNascimento);
                dadosAgendamento.putString("sexo", sexo);
                dadosAgendamento.putString("escolaridade", escolaridade);
                dadosAgendamento.putString("local", strLocal);
                dadosAgendamento.putString("data", strData);
                dadosAgendamento.putString("hora", strHora);


                Intent itAgend = new Intent(AgendamentoActivity.this, ConfirmacaoActivity.class);
                itAgend.putExtras(dadosAgendamento);

                startActivity(itAgend);


            }
        });


        Button voltar = findViewById(R.id.btnVoltarMain);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgendamentoActivity.this, MainActivity.class));
            }
        });



    }
}