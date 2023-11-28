package com.vscribelka.m7_uf1_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTodo extends AppCompatActivity {
    private EditText title, date;
    private CheckBox checkDate;
    private Button saveButton;
    private List<TodoItem> todos;
    private TodoAdapter adapter;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        todos = new ArrayList<>();
        adapter = new TodoAdapter(todos);

        title = findViewById(R.id.editTextText);
        date = findViewById(R.id.editTextDate);
        checkDate = findViewById(R.id.checkBox);
        saveButton = findViewById(R.id.button);
        date.setEnabled(false);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> objectData = new HashMap<>();
                i = new Intent(CreateTodo.this, MainActivity.class);
                //todos.add(new TodoItem(title.getText().toString(), date.getText().toString(), false, checkDate.isChecked()));
                String id = new TodoItem().id;
                //objectData.put("Id", id);
                objectData.put("Title", title.getText().toString());
                objectData.put("Date", date.getText().toString());
                objectData.put("Done", false);
                objectData.put("IsChecked", checkDate.isChecked());
                i.putExtra("Id", id);
                i.putExtra("Title", title.getText().toString());
                i.putExtra("Date", date.getText().toString());
                i.putExtra("Done", false);
                i.putExtra("IsChecked", checkDate.isChecked());
                //new TodoItem(title.getText().toString(), date.getText().toString(), false, checkDate.isChecked());
                todos.add(new TodoItem(title.getText().toString(), date.getText().toString(), false, checkDate.isChecked()));
                adapter.notifyDataSetChanged();

                //i.putExtra("Title", title.getText().toString());
                //i.putExtra("Date", date.getText().toString());
                //i.putExtra("Done", false);
                //i.putExtra("IsChecked", checkDate.isChecked());
                //new TodoItem(title.getText().toString(), date.getText().toString(), false, checkDate.isChecked());
                startActivity(i);
                finish();
            }
        });
        checkDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkDate.isChecked()) {
                    date.setEnabled(true);
                    date.setClickable(true);
                }
                else {
                    date.setEnabled(false);
                    date.setClickable(false);
                }
            }
        });
    }
}