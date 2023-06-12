package com.example.ejercicioSpringBoot.Controller;

import com.example.ejercicioSpringBoot.DAO.AlumnosDAO;
import com.example.ejercicioSpringBoot.DAO.UsuariosDAO;
import com.example.ejercicioSpringBoot.Modelo.Alumnos;
import com.example.ejercicioSpringBoot.Modelo.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    AlumnosDAO alumnosDAO;

    @Autowired
    UsuariosDAO usuariosDAO;

    @GetMapping("/listar")
    public List<Alumnos> listar(){
        return alumnosDAO.listar();
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable int id){
        alumnosDAO.delete(id);
    }

    @PostMapping("/añadirAlumnos")
    public void add(@RequestBody Alumnos alumno){
        alumnosDAO.add(alumno);
    }

    @PostMapping("/añadirUsuarios")
    public void add(@RequestBody Usuarios usuario){
        usuariosDAO.add(usuario);
    }

    @GetMapping("/buscar/{nombre}/{contraseña}")
    public Usuarios buscar(@PathVariable String nombre, @PathVariable String contraseña){
        return usuariosDAO.buscar(nombre, contraseña);
    }

    @GetMapping("/rol/{id}")
    public int rol(@PathVariable int id){
        return usuariosDAO.recogerRol(id);
    }

    @PutMapping("/edit/{nombre}/{nota}")
    public void edit(@PathVariable String nombre, @PathVariable int nota) {
        alumnosDAO.edit(nombre, nota);
    }
}
