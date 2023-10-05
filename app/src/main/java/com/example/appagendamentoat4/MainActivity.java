package com.example.appagendamentoat4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public String strEscolaridade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spnEsc = findViewById(R.id.spnEscolaridade);

        spnEsc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strEscolaridade = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button avancarEscolhaLocal = findViewById(R.id.btnAvancarEscolhaLocal);
        avancarEscolhaLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText dataNascimento = findViewById(R.id.edtDtNascimento);
                EditText cpf = findViewById(R.id.edtCPF);
                EditText nome = findViewById(R.id.edtNome);
                RadioButton rbnf = findViewById(R.id.rbnFeminino);
                RadioButton rbnm = findViewById(R.id.rbnMasculino);
                RadioButton rbno = findViewById(R.id.rbnOutros);


                if (nome.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Campo nome vazio",
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }
                if (dataNascimento.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Campo Data Nascimento vazio",
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }
                if (cpf.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Campo CPF vazio",
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }
                if (!rbnf.isChecked() && !rbnm.isChecked() && !rbno.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Deve escolher um sexo!",
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }
                String strNome = nome.getText().toString();
                String strDataNascimento = dataNascimento.getText().toString();
                String strCPF = cpf.getText().toString();

                String strSexo = "";

                if (rbnf.isChecked()) {
                    strSexo = "feminino";
                }
                if (rbnm.isChecked()) {
                    strSexo = "masculino";
                }
                if (rbno.isChecked()) {
                    strSexo = "outro";
                }

                Date date = new Date(
                        Calendar.getInstance().getTime().getTime());
                SimpleDateFormat formatter =
                        new SimpleDateFormat("dd/MM/yyyy");

                String strdataNascimento = formatter.format(date);

                Bundle dados = new Bundle();
                dados.putString("nome", strNome);
                dados.putString("cpf", strCPF);
                dados.putString("dataNascimento", strDataNascimento);
                dados.putString("sexo", strSexo);
                dados.putString("escolaridade", strEscolaridade);

                Intent it = new Intent(MainActivity.this, AgendamentoActivity.class);
                it.putExtras(dados);

                startActivity(it);


            }
        });


    }
}