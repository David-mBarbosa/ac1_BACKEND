package com.example.ac1.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ac1.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Aluno aluno) {
        entityManager.persist(aluno);
    }

    @Transactional
    public void editar(Aluno aluno) {
        entityManager.merge(aluno);
    }

    @Transactional
    public void excluir(Long id) {
        Aluno a = selecionarPorId(id);
        if (a != null) {
            entityManager.remove(a);
        }
    }

    public List<Aluno> selecionarTodos() {
        return entityManager.createQuery("from Aluno", Aluno.class).getResultList();
    }

    public Aluno selecionarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }
}
