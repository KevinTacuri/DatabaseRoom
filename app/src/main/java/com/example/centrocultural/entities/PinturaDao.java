package com.example.centrocultural.entitys;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import java.util.List;

@Dao
public interface PinturaDao {
    @Insert
    void insert(Pintura pintura);

    @Update
    void update(Pintura pintura);

    @Delete
    void delete(Pintura pintura);

    @Query("SELECT * FROM pintura")
    List<Pintura> getAllPinturas();

    @Query("SELECT * FROM pintura WHERE id = :id")
    Pintura getPinturaById(int id);

    @Query("SELECT * FROM pintura WHERE salaId = :salaId")
    List<Pintura> getPinturasBySalaId(int salaId);
}
