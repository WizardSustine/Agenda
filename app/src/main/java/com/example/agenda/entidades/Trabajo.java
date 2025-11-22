package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "trabajo")
public class Trabajo extends Tarea{
    public Trabajo(){
        categoria = "trabajo";
    }
    @ColumnInfo(name =  "tienehora")
    public boolean tienehora;
    @ColumnInfo(name =  "notifica")
    public boolean notifica;
    @ColumnInfo(name = "inicio")
    public String inicio;
    @ColumnInfo(name = "fin")
    public String fin;
}
