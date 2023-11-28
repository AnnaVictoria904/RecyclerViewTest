package com.vscribelka.m7_uf1_examen;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<TodoItem> todos;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem item = todos.get(position);
        holder.title.setText(item.title);
        holder.check.setChecked(item.hasDueDate);
        if (item.hasDueDate) {
            holder.date.setText(item.dueDate);
        }
        else {
            holder.date.setText("No due date.");
        }
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CreateTodo.class);
                intent.putExtra("Id", item.id);
                intent.putExtra("Title", item.title);
                intent.putExtra("Date", item.dueDate);
                intent.putExtra("Done", false);
                intent.putExtra("IsChecked", item.hasDueDate);
                v.getContext().startActivity(intent);
            }
        });
    }

    public TodoAdapter(List<TodoItem> todos) {
        this.todos = todos;
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox check;
        TextView title;
        TextView date;
        Button edit, delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            check = itemView.findViewById(R.id.checkBox2);
            title = itemView.findViewById(R.id.textView);
            date = itemView.findViewById(R.id.textView2);
            edit = itemView.findViewById(R.id.button2);
            delete = itemView.findViewById(R.id.button3);
        }
    }
}
