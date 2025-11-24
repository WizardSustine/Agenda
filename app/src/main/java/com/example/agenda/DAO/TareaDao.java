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

    @Query("SELECT * FROM tarea WHERE estado LIKE :estado")
    List<Tarea> findByState(String estado);

    @Query("SELECT * FROM tarea WHERE categoria LIKE :categoria")
    List<Tarea> findByCategory(int categoria);

    @Query("SELECT * FROM tarea WHERE subcategoria LIKE :subcategoria")
    List<Tarea> findBySubcategory(int subcategoria);

    @Query("SELECT * FROM tarea WHERE institucion LIKE :institucion")
    List<Tarea> findByInstitution(int institucion);

    @Query("SELECT * FROM tarea WHERE t_id LIKE :id")
    Tarea findById(int id);

    @Query("UPDATE tarea " +
            "SET descripcion= :descripcion " +
            "AND fecha= :fecha " +
            "AND prioridad= :prioridad " +
            "AND estado= :estado " +
            "AND categoria= :categoria " +
            "AND subcategoria= :subcategoria " +
            "AND institucion= :institucion " +
            "AND notifica= :notifica " +
            "WHERE t_id= :id ")
    void updateTarea(int id,
                     String descripcion,
                     String fecha,
                     int prioridad,
                     String estado,
                     int categoria,
                     int subcategoria,
                     int institucion,
                     int notifica);

    @Insert
    void insertAll(Tarea... tareas);

    @Delete
    void delete(Tarea tarea);
}
