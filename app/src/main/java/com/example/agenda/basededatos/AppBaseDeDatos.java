package com.example.agenda.basededatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.agenda.DAO.CategoriaDao;
import com.example.agenda.DAO.InstitucionDao;
import com.example.agenda.DAO.NotificaDao;
import com.example.agenda.DAO.SubcategoriaDao;
import com.example.agenda.DAO.TareaDao;
import com.example.agenda.entidades.Categoria;
import com.example.agenda.entidades.Institucion;
import com.example.agenda.entidades.Notifica;
import com.example.agenda.entidades.Subcategoria;
import com.example.agenda.entidades.Tarea;

@Database(entities = {Tarea.class, Categoria.class, Subcategoria.class, Notifica.class, Institucion.class}, version = 1)
public abstract class AppBaseDeDatos extends RoomDatabase {
    public abstract TareaDao tareaDao();
    public abstract InstitucionDao institucionDao();
    public abstract CategoriaDao categoriaDao();
    public abstract SubcategoriaDao subcategoriaDao();
    public abstract NotificaDao notificaDao();

    private static volatile AppBaseDeDatos INSTANCE;

    public static AppBaseDeDatos getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppBaseDeDatos.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppBaseDeDatos.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
