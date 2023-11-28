package com.vscribelka.m7_uf1_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.Serializable;
import java.util.UUID;

public class TodoItem implements Serializable {
    private static final long serialVersionUID = 1L; // Añade esto para garantizar una deserialización compatible
    public String id;
    public String title;
    public String dueDate; // Guardamos la fecha como un timestamp
    public boolean isDone;
    public boolean hasDueDate;

    public TodoItem() {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
    }
    public TodoItem(String title, String dueDate, boolean isDone, boolean hasDueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.hasDueDate = hasDueDate;
    }
}