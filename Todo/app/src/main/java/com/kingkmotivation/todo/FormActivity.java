package com.kingkmotivation.todo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.kingkmotivation.todo.base.DatasTodo;
import com.kingkmotivation.todo.entities.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormActivity extends AppCompatActivity {
    private Spinner spinner;
    private Todo todo = new Todo();
    private EditText et;
    private Button btnadd, btncancel;
    private String nameTodo, selectedSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        btnadd = findViewById(R.id.btnAdd);
        btncancel = findViewById(R.id.btnCancel);
        spinner = findViewById(R.id.spListe);
        et = findViewById(R.id.etInfo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // tableau des urgence stocker dans le dossier ressource
        String[] tabUrgences = getResources().getStringArray(R.array.tableauUrgences);

        List<String> urgenceList = new ArrayList<>(Arrays.asList(tabUrgences));

        //tableau de la liste deroulante
        ArrayAdapter<String> spArrayAdapter
                = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                urgenceList
        );
        //liste deroulante
        spArrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spArrayAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTodo= et.getText().toString();
                selectedSpinner = spinner.getSelectedItem().toString();
                todo.setName(nameTodo);
                todo.setUrgency(selectedSpinner);
                DatasTodo.getDb(getApplicationContext()).todoRepository().add(todo);
                finish();
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return true;
    }
}