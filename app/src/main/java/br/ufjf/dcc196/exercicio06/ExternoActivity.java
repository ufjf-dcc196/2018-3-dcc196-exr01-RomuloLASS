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

public class ExternoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);
        Toast.makeText(getApplicationContext(),"ExternoActivity criada", Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();

        Button botaoExternoConfirmar = findViewById(R.id.botaoExternoConfirma);

        TextView mensagemExterno  = findViewById(R.id.txtExternoMensagem);

        if (bundle != null){
            String nome = (String) bundle.get("nome");
            mensagemExterno.setText("Bem vindo! " + nome);
        }

        botaoExternoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editEmail = findViewById(R.id.editText);
                String email = editEmail.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("email", email);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
