package com.cup.independence.dao;

import com.cup.independence.model.Fixture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FixtureDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Fixture fixture) {
        entityManager.persist(fixture);
    }

    public void update(Fixture fixture) {
        entityManager.merge(fixture);
    }

    public Fixture getFixtureById(long id) {
        return entityManager.find(Fixture.class, id);
    }

    public void delete(long id) {
        Fixture fixture = getFixtureById(id);
        if (fixture != null) {
            entityManager.remove(fixture);
        }
    }
}
