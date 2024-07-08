package com.example.centrocultural;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.centrocultural.entities.Autor;
import com.example.centrocultural.entities.AutorDao;
import com.example.centrocultural.entities.Pintura;
import com.example.centrocultural.entities.PinturaDao;
import com.example.centrocultural.entities.Sala;
import com.example.centrocultural.entities.SalaDao;

@Database(entities = {Sala.class, Pintura.class, Autor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SalaDao salaDao();
    public abstract PinturaDao pinturaDao();
    public abstract AutorDao autorDao();
}
