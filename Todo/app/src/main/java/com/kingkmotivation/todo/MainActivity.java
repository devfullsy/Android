package com.kingkmotivation.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kingkmotivation.todo.base.DatasTodo;
import com.kingkmotivation.todo.entities.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Todo> todoList = new ArrayList<>();

    //private TextView tv;
    private RecyclerView rvTodos;
    //private List<String> liste = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);
        rvTodos = findViewById(R.id.rvTodo);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        rvTodos.setHasFixedSize(true);
        rvTodos.setLayoutManager(layoutManager);

        //affichage de la premiere vue avec le textview
        //tv = findViewById(R.id.tvData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.menuUrgenc) {
            Intent activite = new Intent(getApplicationContext(),FormActivity.class);
            startActivity(activite);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Todo> todos = DatasTodo.getDb(getApplicationContext()).todoRepository().list();
        TodoAdapter todoAdapter = new TodoAdapter(todos);
        rvTodos.setAdapter(todoAdapter);

        // boucle pour le premier affichage avec le tv
       /* for (Todo todo: todos) {
            Log.d("TODO : ",todo.toString());

        }*/
    }
}