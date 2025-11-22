package com.example.agenda.basededatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.agenda.DAO.InstitucionDao;
import com.example.agenda.DAO.TrabajoDao;
import com.example.agenda.entidades.Institucion;
import com.example.agenda.entidades.Trabajo;

@Database(entities = {Trabajo.class, Institucion.class}, version = 1)
public abstract class AppBaseDeDatos extends RoomDatabase {
    public abstract TrabajoDao trabajoDao();
    public abstract InstitucionDao institucionDao();

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
