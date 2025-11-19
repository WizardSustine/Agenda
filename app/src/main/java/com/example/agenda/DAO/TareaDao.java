package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agenda.entidades.Tarea;

import java.util.List;

@Dao
public interface TareaDao {
    @Query("SELECT * FROM tarea")
    List<Tarea> getAll();

    @Query("SELECT * FROM tarea WHERE t_id IN (:tareaIds)")
    List<Tarea> loadAllByIds(int[] tareaIds);

    @Query("SELECT * FROM tarea WHERE descripcion LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Tarea findByName(String descripcion, String last);

    @Query("UPDATE tarea SET descripcion= :descripcion WHERE tarea= :tarea")
    void updateTarea(String tarea, String descripcion);

    @Insert
    void insertAll(Tarea... tareas);

    @Delete
    void delete(Tarea tarea);
}
