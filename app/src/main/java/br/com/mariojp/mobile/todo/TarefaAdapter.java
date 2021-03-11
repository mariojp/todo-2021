package br.com.mariojp.mobile.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class TarefaAdapter extends BaseAdapter {

    private List<Tarefa> tarefas;
    private Context contexto;

    public TarefaAdapter(List<Tarefa> tarefas, Context contexto){
        this.tarefas = tarefas;
        this.contexto = contexto;

    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Tarefa getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.tarefa_item, viewGroup, false);
        }

        Tarefa tarefa = getItem(position);

        TextView titulo = view.findViewById(R.id.tarefa_item_titulo);
        titulo.setText(tarefa.getNome());
        TextView descricao =view.findViewById(R.id.tarefa_item_descricao);
        descricao.setText(tarefa.getDescricao());
        TextView prioridade =view.findViewById(R.id.tarefa_item_prioridade);
        prioridade.setText(tarefa.getPrioridade()+"");

        return view;
    }
}
