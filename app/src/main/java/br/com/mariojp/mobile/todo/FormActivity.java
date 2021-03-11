package br.com.mariojp.mobile.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    private EditText nome;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("Form");
        nome = findViewById(R.id.form_edit_nome);
        salvar = findViewById(R.id.form_button_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Não Fazer
//                Intent intent = new Intent(FormActivity.this, MainActivity.class);
//                startActivity(intent);

                //Activity anterior não espera um retorno
//                MainActivity.bd.add(nome.getText().toString());
//                finish();

                //Activity anterior espera um retorno
                Intent data = new Intent();
                data.putExtra("NOME_TAREFA",nome.getText().toString());
                setResult(200, data);
                finish();
            }
        });

    }
}