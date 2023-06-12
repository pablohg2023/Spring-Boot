package com.example.ejercicioSpringBoot.DAO;

import com.example.ejercicioSpringBoot.Modelo.Alumnos;

import java.util.List;

public interface AlumnosDAO {

    List<Alumnos> listar();
    void delete(int id);
    void edit(String nombre, int nota);
    void add(Alumnos alumno);

}
