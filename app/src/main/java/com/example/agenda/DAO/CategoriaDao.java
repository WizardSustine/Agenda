package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.agenda.entidades.Categoria;
import com.example.agenda.entidades.Institucion;

import java.util.List;

@Dao
public interface CategoriaDao {
    @Query("SELECT * FROM categoria")
    List<Categoria> getAll();

    @Query("SELECT * FROM categoria WHERE c_id IN (:categoriaIds)")
    List<Categoria> loadAllByIds(int[] categoriaIds);

    @Query("SELECT * FROM categoria WHERE nombre LIKE :name")
    List<Categoria> findByName(String name);

    @Query("SELECT * FROM categoria WHERE c_id LIKE :id")
    Categoria findById(long id);

    @Query("SELECT * FROM categoria WHERE subcategoria LIKE :subcategoria")
    List<Categoria> findBySubcategory(int subcategoria);

    @Query("UPDATE categoria SET nombre= :nombre AND subcategoria= :subcategoria WHERE c_id= :id")
    void updateCategoria(int id, String nombre, int subcategoria);

    @Insert
    void insertAll(Categoria... categorias);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Categoria categoria);

    @Delete
    void delete(Categoria categoria);

}
