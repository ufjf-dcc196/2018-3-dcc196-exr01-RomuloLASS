package br.ufjf.dcc196.exercicio06;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_SIAPE = 1;
    public static final int REQUEST_MATRICULA = 2;
    public static final int REQUEST_EMAIL = 3;

    public int count = 0;

    EditText editNome;
    TextView txtMensagemProfessor;
    TextView txtMensagemAluno;
    TextView txtMensagemExterno;
    List<String> aluno;
    List<String> professor = new ArrayList<>();
    List<String> externo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAluno = findViewById(R.id.btn_aluno);
        Button btnProfessor = findViewById(R.id.btn_professor);
        Button btnExterno = findViewById(R.id.btn_externo);

        editNome = findViewById(R.id.editText2);

        txtMensagemProfessor = findViewById(R.id.txt_professor);
        txtMensagemAluno = findViewById(R.id.txt_aluno);
        txtMensagemExterno = findViewById(R.id.txt_externo);

        aluno = new ArrayList<>();

        externo = new ArrayList<>();


        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfessorActivity.class);
                String nome = editNome.getText().toString();
                intent.putExtra("nome", nome);
                startActivityForResult(intent, MainActivity.REQUEST_SIAPE);
            }
        });

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                String nome = editNome.getText().toString();
                intent.putExtra("nome", nome);
                startActivityForResult(intent, MainActivity.REQUEST_MATRICULA);
            }
        });

        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExternoActivity.class);
                String nome = editNome.getText().toString();
                intent.putExtra("nome", nome);
                startActivityForResult(intent, MainActivity.REQUEST_EMAIL);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == MainActivity.REQUEST_SIAPE && resultCode == Activity.RESULT_OK){
            if(data != null){
                Bundle bundle = data.getExtras();
                String siape = (String) bundle.get("siape");
                this.professor.add(siape);
                count +=1;
                txtMensagemProfessor.setText("Professor: " + this.professor.size());
            }
        }else if(requestCode == MainActivity.REQUEST_MATRICULA && resultCode == Activity.RESULT_OK){
            if(data != null){
                Bundle bundle = data.getExtras();
                String matricula = (String) bundle.get("matricula");
                this.aluno.add(matricula);
                txtMensagemAluno.setText("Aluno: " + this.aluno.size());
            }
        }else if(requestCode == MainActivity.REQUEST_EMAIL && resultCode == Activity.RESULT_OK){
            if(data != null){
                Bundle bundle = data.getExtras();
                String email = (String) bundle.get("email");
                this.externo.add(email);
                txtMensagemExterno.setText("Externo: " + this.externo.size());
            }
        }
    }
}
