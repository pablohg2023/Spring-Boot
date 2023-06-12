package com.example.ejercicioSpringBoot.DAO;

import com.example.ejercicioSpringBoot.Modelo.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository

public class UsuariosDAOimp implements UsuariosDAO{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Usuarios buscar(String nombre, String contrasena) {
        Usuarios usuario = new Usuarios();

        List<Usuarios> usuarios = entityManager.createQuery("FROM Usuarios ").getResultList();
        for(int i=0;i< usuarios.size();i++){
            if(usuarios.get(i).getNombre().equals(nombre)){
                usuario = usuarios.get(i);
            }
        }
        return usuario;
    }

    @Override
    public void add(Usuarios usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public int recogerRol(int id) {
        Usuarios usuarios = entityManager.find(Usuarios.class,id);
        return usuarios.getAdmin();
    }

}
