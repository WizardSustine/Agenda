package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarea", foreignKeys = {
        @ForeignKey(
            entity = Institucion.class,
            parentColumns = "i_id",
            childColumns = "institucion",
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(
            entity = Categoria.class,
            parentColumns = "c_id",
            childColumns = "categoria",
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(
            entity = Subcategoria.class,
            parentColumns = "s_id",
            childColumns = "subcategoria",
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(
            entity = Notifica.class,
            parentColumns = "n_id",
            childColumns = "notifica",
            onDelete = ForeignKey.CASCADE)})
public class Tarea {
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
    public int categoria;

    @ColumnInfo(name = "subcategoria")
    public int subcategoria;

    @ColumnInfo(name = "institucion")
    public int institucion;

    @ColumnInfo(name = "notifica")
    public int notifica;

}
