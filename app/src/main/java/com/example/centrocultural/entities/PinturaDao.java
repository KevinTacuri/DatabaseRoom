package com.example.centrocultural.entities;
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
    // Consulta para los campos de la pintura con el autor
    @Query("SELECT pintura.titulo, autor.nombre || ' ' || autor.apellido AS nombre_autor," +
            " pintura.tecnica, pintura.categoria, pintura.descripcion, pintura.anio, pintura.enlace " +
            "FROM pintura " + "INNER JOIN autor ON pintura.autorId = autor.id")
    List<PinturaAutor> getPinturaAutor();
    // Consulta para los campos de sala con pinturas y autor
    @Query("SELECT sala.nombre AS nombre_sala, pintura.titulo, autor.nombre || ' ' || autor.apellido AS " +
            "nombre_autor, pintura.enlace " + "FROM pintura " + "INNER JOIN sala ON pintura.salaId = sala.id "
            + "INNER JOIN autor ON pintura.autorId = autor.id")
    List<SalaPintura> getSalaPintura();
}