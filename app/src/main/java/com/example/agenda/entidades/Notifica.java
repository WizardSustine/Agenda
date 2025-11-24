package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notifica")
public class Notifica extends Tarea{
    @PrimaryKey(autoGenerate = true)
    public int n_id;
    @ColumnInfo(name =  "isactive")
    public boolean isActive;
    @ColumnInfo(name = "inicio")
    public String inicio;
    @ColumnInfo(name = "fin")
    public String fin;
}
