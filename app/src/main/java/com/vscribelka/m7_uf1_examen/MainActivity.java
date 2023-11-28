package com.vscribelka.m7_uf1_examen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton addItem;
    private RecyclerView recyclerView;
    private List<TodoItem> todos;
    private TodoAdapter adapter;
    private Intent newIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItem = findViewById(R.id.imageButton);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateTodo.class);
                startActivity(i);
                finish();
            }
        });
        if (todos != null && !todos.isEmpty()) {
            loadItems();
        }
    }
    public void loadItems() {
        newIntent = getIntent();
        /*todos = new ArrayList<>();
        //todos.add(new TodoItem(newIntent.getStringExtra("Title"), newIntent.getStringExtra("Date"), newIntent.getBooleanExtra("Done", false), newIntent.getBooleanExtra("IsChecked", false)));
        adapter = new TodoAdapter(todos);
        recyclerView.setAdapter(adapter);*/

        todos = new ArrayList<>();
        for (int i = 0; i < todos.size(); i++) {
            TodoItem todoItem = new TodoItem();
            todoItem.id = newIntent.getStringExtra("Id");
            todos.add(todoItem);
        }

        adapter = new TodoAdapter(todos);
        recyclerView.setAdapter(adapter);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}