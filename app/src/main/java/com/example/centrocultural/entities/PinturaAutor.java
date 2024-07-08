package com.example.centrocultural.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;

public class PinturaAutor {
    @Embedded
    public Pintura pintura;
    @Embedded
    public Autor autor;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "apellido")
    public String apellido;

    @ColumnInfo(name = "tecnica")
    public String tecnica;

    @ColumnInfo(name = "categoria")
    public String categoria;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "anio")
    public String anio;

    @ColumnInfo(name = "enlace")
    public String enlace;
}
