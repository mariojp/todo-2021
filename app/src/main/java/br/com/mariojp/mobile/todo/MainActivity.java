package br.com.mariojp.mobile.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    public static List<Tarefa> bd = new ArrayList<>();

    private FloatingActionButton botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tarefas");

        //view
        lista = findViewById(R.id.main_list_lista);
        botao = findViewById(R.id.id_main_button_add);


        bd.addAll(Arrays.asList(new Tarefa("TITULO", "DESCRICAO",1),
                new Tarefa("TAREFA 1", "DESCRICAO 1",2),
                new Tarefa("TAREFA 2", "DESCRICAO 2",1)));



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 999);
            }
        });



    }


    @Override
    protected void onResume() {
        super.onResume();
        //tarefas
        List<Tarefa> tarefas = new ArrayList<>(bd);
        ListAdapter adapter = new TarefaAdapter(tarefas,this);
        lista.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999){
            if(resultCode == 200) {
                String nome = data.getStringExtra("NOME_TAREFA");
                Tarefa tarefa = new Tarefa();
                tarefa.setNome(nome);
                bd.add(tarefa);
            }
        }
    }
}