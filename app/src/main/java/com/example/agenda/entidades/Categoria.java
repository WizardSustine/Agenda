package com.example.agenda.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "categoria",
        foreignKeys = {
            @ForeignKey(
                entity = Subcategoria.class,
                parentColumns = "s_id",
                childColumns = "subcategoria",
                onDelete = ForeignKey.CASCADE)})
public class Categoria {
    @PrimaryKey(autoGenerate = true)
    public int c_id;

    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "subcategoria")
    public int subcategoria;

}
