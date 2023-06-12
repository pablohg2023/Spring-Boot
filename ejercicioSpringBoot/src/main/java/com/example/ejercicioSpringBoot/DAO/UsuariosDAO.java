package com.example.ejercicioSpringBoot.DAO;

import com.example.ejercicioSpringBoot.Modelo.Usuarios;

import java.util.List;

public interface UsuariosDAO {

    Usuarios buscar(String nombre, String contrasena);

    void add(Usuarios usuario);

    int recogerRol(int id);

}
