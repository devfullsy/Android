package com.kingkmotivation.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingkmotivation.todo.entities.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> todos;
    public TodoAdapter(List<Todo> todos){
        this.todos= todos;
    }
    public class TodoViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvUrgence;
        public TodoViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvnamerv);
            tvUrgence = itemView.findViewById(R.id.tvurgencerv);
        }
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.tvName.setText(todo.getName());
        holder.tvUrgence.setText(todo.getUrgency());

    }

//cette methode gere la pagination en fonction du nombre de elements de la liste
    @Override
    public int getItemCount() {
        return todos.size();
    }
}
