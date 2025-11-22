package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.agenda.entidades.Institucion;
import com.example.agenda.entidades.Tarea;

import java.util.List;

@Dao
public interface InstitucionDao {

    @Query("SELECT * FROM institucion")
    List<Institucion> getAll();

    @Query("SELECT * FROM institucion WHERE i_id IN (:institucionIds)")
    List<Institucion> loadAllByIds(int[] institucionIds);

    @Query("SELECT * FROM institucion WHERE nombre LIKE :name")
    List<Institucion> findByName(String name);

    @Query("SELECT * FROM institucion WHERE i_id LIKE :id")
    Institucion findById(long id);

    @Query("SELECT * FROM institucion WHERE direccion LIKE :address LIMIT 1")
    Institucion findByAddress(String address);

    @Query("UPDATE institucion SET nombre= :nombre AND direccion= :direccion AND tipo= :tipo WHERE i_id= :id")
    void updateTarea(long id, String nombre, String direccion, String tipo);

    @Insert
    void insertAll(Institucion... institucions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Institucion institucion);

    @Delete
    void delete(Institucion institucion);
}
