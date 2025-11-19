package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(
        entity = Institucion.class,
        parentColumns = "i_id",
        childColumns = "institucion",
        onDelete = ForeignKey.CASCADE)})
public abstract class Tarea {
    @PrimaryKey(autoGenerate = true)
    public int t_id;
    @ColumnInfo(name = "fecha")
    public String fecha;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "prioridad")
    public int prioridad;

    @ColumnInfo(name = "estado")
    public String estado;

    @ColumnInfo(name = "categoria")
    public String categoria;

    @ColumnInfo(name = "subcategoria")
    public String subcategoria;

    @ColumnInfo(name = "institucion")
    public int institucion;

}
