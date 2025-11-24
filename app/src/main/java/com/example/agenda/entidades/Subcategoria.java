package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subcategoria")
public class Subcategoria {
    @PrimaryKey(autoGenerate = true)
    public int s_id;

    @ColumnInfo(name = "nombre")
    public String nombre;
}
