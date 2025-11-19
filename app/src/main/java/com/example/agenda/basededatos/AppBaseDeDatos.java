package com.example.agenda.basededatos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.agenda.DAO.TareaDao;
import com.example.agenda.entidades.Tarea;

@Database(entities = {Tarea.class}, version = 1)
public abstract class AppBaseDeDatos extends RoomDatabase {
    public abstract TareaDao tareaDao();
}
