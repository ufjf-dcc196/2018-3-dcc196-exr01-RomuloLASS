package br.ufjf.dcc196.exercicio06;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        Toast.makeText(getApplicationContext(),"ProfessorActivity criada", Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();

        Button botaoProfConfirmar = findViewById(R.id.botaoProfConfirmar);

        TextView mensagemProfessor  = findViewById(R.id.txtExternoMensagem);

        if (bundle != null){
            String nome = (String) bundle.get("nome");
            mensagemProfessor.setText("Bem vindo professor " + nome);
        }

        botaoProfConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editSiape = findViewById(R.id.editText);
                String siape = editSiape.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("siape", siape);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
