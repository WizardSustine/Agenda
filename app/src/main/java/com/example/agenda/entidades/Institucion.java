package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "institucion")
public class Institucion {
    @PrimaryKey(autoGenerate = true)
    public int i_id;
    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "direccion")
    public String direccion;

    @ColumnInfo(name = "tipo")
    public String tipo;

    public Institucion(String nombre, String direccion, String tipo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }
}
