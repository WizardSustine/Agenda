package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agenda.entidades.Trabajo;

import java.util.List;

@Dao
public interface TrabajoDao {

    @Query("SELECT * FROM Trabajo")
    List<Trabajo> getAll();

    @Query("SELECT * FROM Trabajo WHERE t_id IN (:tareaIds)")
    List<Trabajo> loadAllByIds(int[] tareaIds);

    @Query("SELECT * FROM Trabajo WHERE estado LIKE :estado")
    List<Trabajo> findByState(String estado);

    @Query("SELECT * FROM Trabajo WHERE t_id LIKE :id")
    Trabajo findById(long id);

    @Query("UPDATE Trabajo " +
            "SET descripcion= :descripcion " +
            "AND fecha= :fecha " +
            "AND prioridad= :prioridad " +
            "AND estado= :estado " +
            "AND subcategoria= :subcategoria " +
            "AND institucion= :institucion " +
            "AND tienehora= :tienehora " +
            "AND notifica= :notifica " +
            "AND inicio= :inicio " +
            "AND fin= :fin WHERE t_id= :id ")
    void updateTarea(long id,
                     String descripcion,
                     String fecha,
                     int prioridad,
                     String estado,
                     String subcategoria,
                     int institucion,
                     boolean tienehora,
                     boolean notifica,
                     String inicio,
                     String fin);

    @Insert
    void insertAll(Trabajo... tareas);

    @Delete
    void delete(Trabajo trabajo);
}
