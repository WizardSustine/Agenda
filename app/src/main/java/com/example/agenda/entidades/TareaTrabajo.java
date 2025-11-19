package com.example.agenda.entidades;

import androidx.room.Entity;

@Entity(tableName = "tareatrabajo")
public class TareaTrabajo extends Tarea{
    public TareaTrabajo(){
        categoria = "TRABAJO";
    }
}
