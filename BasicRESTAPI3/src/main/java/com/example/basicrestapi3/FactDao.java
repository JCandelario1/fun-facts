package com.example.basicrestapi3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FactDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Fact fact) {
        em.persist(fact);
    }

    public Fact getById(int id) {
        return em.find(Fact.class, id);
    }

    public void update(Fact fact) {
        em.merge(fact);
    }

    public void delete(Fact fact) {
        em.remove(fact);
    }

    public List<Fact> getLatest() {
        return em.createQuery("SELECT v FROM Fact v ORDER BY v.id DESC", Fact.class)
                .setMaxResults(10)
                .getResultList();
    }

}