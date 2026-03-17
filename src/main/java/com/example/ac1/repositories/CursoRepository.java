package com.example.ac1.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ac1.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Curso curso) {
        entityManager.persist(curso);
    }

    @Transactional
    public void editar(Curso curso) {
        entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Long id) {
        Curso c = selecionarPorId(id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public List<Curso> selecionarTodos() {
        return entityManager.createQuery("from Curso", Curso.class).getResultList();
    }

    public Curso selecionarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }
}
