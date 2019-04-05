package br.ufjf.dcc196.exercicio06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        Toast.makeText(getApplicationContext(), "AlunoActivity criada", Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();

        Button botaoAlunoConfirmar = findViewById(R.id.botaoAlunoConfirma);

        TextView mensagemProfessor = findViewById(R.id.txtExternoMensagem);

        if (bundle != null) {
            String nome = (String) bundle.get("nome");
            mensagemProfessor.setText("Bem vindo professor " + nome);
        }

        botaoAlunoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editMatricula = findViewById(R.id.editText);
                String matricula = editMatricula.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("matricula", matricula);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

