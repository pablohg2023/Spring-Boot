package com.example.ejercicioSpringBoot.DAO;

import com.example.ejercicioSpringBoot.Modelo.Alumnos;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository

public class AlumnosDAOimp implements AlumnosDAO{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Alumnos> listar() {
        String query = "FROM Alumnos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Alumnos alumno = entityManager.find(Alumnos.class, id);
        entityManager.remove(alumno);
    }

    @Override
    public void add(Alumnos alumno) {
        entityManager.merge(alumno);
    }

    @Override
    public void edit(String nombre, int nota) {
        Alumnos alumnos = entityManager.find(Alumnos.class, nombre);
        alumnos.setNombre(nombre);
        alumnos.setNota(nota);
        add(alumnos);
        entityManager.merge(alumnos);
    }

}
