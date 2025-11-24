package com.example.agenda.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.agenda.entidades.Notifica;
import com.example.agenda.entidades.Subcategoria;

import java.util.List;

@Dao
public interface NotificaDao {
    @Query("SELECT * FROM notifica")
    List<Notifica> getAll();

    @Query("SELECT * FROM notifica WHERE n_id IN (:notificaIds)")
    List<Notifica> loadAllByIds(int[] notificaIds);

    @Query("SELECT * FROM notifica WHERE inicio LIKE :inicio")
    List<Notifica> findByInicio(String inicio);

    @Query("SELECT * FROM notifica WHERE fin LIKE :fin")
    List<Notifica> findByFin(String fin);

    @Query("SELECT * FROM notifica WHERE isactive LIKE :state")
    List<Notifica> findByState(boolean state);

    @Query("SELECT * FROM notifica WHERE n_id LIKE :id")
    Notifica findById(int id);

    @Query("UPDATE notifica SET inicio= :inicio AND fin= :fin AND isactive= :isactive  WHERE n_id= :id")
    void updateNotifica(int id, String inicio, String fin, boolean isactive);

    @Insert
    void insertAll(Notifica... notificas);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Notifica notifica);

    @Delete
    void delete(Notifica notifica);
}
