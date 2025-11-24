package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.agenda.entidades.Subcategoria;

import java.util.List;

@Dao
public interface SubcategoriaDao {
    @Query("SELECT * FROM categoria")
    List<Subcategoria> getAll();

    @Query("SELECT * FROM subcategoria WHERE s_id IN (:subcategoriaIds)")
    List<Subcategoria> loadAllByIds(int[] subcategoriaIds);

    @Query("SELECT * FROM subcategoria WHERE nombre LIKE :name")
    List<Subcategoria> findByName(String name);

    @Query("SELECT * FROM subcategoria WHERE s_id LIKE :id")
    Subcategoria findById(int id);

    @Query("UPDATE subcategoria SET nombre= :nombre  WHERE s_id= :id")
    void updateSubcategoria(int id, String nombre);

    @Insert
    void insertAll(Subcategoria... subcategorias);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Subcategoria subcategoria);

    @Delete
    void delete(Subcategoria subcategoria);

}
