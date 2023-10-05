package com.example.appagendamentoat4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        Intent itAgend = getIntent();
        Bundle dadosAgendamento = itAgend.getExtras();
        String nome = "";
        String dataNascimento = "";
        String cpf = "";
        String sexo = "";
        String escolaridade = "";
        String local = "";
        String data = "";
        String hora = "";


        if (dadosAgendamento != null) {
            nome = dadosAgendamento.getString("nome");
            dataNascimento = dadosAgendamento.getString("dataNascimento");
            cpf = dadosAgendamento.getString("cpf");
            sexo = dadosAgendamento.getString("sexo");
            escolaridade = dadosAgendamento.getString("escolaridade");
            local = dadosAgendamento.getString("local");
            data = dadosAgendamento.getString("data");
            hora = dadosAgendamento.getString("hora");
        }

        TextView txvnome = findViewById(R.id.txvNome2C);
        txvnome.setText(nome);

        TextView txvdataNasc = findViewById(R.id.txvDataNascimento2C);
        txvdataNasc.setText(dataNascimento);

        TextView txvCpf = findViewById(R.id.txvCPF2C);
        txvCpf.setText(cpf);

        TextView txvSexo = findViewById(R.id.txvSexo2C);
        txvSexo.setText(sexo);

        TextView txvEscolaridade = findViewById(R.id.txvEscolaridade2C);
        txvEscolaridade.setText(escolaridade);

        TextView txvLocal = findViewById(R.id.txvLocal2C);
        txvLocal.setText(local);

        TextView txvdata = findViewById(R.id.txvData2C);
        txvdata.setText(data);

        TextView txvHora = findViewById(R.id.txvHora2C);
        txvHora.setText(hora);


        Button encerar = findViewById(R.id.btnEncerrar);
        encerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmacaoActivity.this, MainActivity.class));
            }
        });

    }
}