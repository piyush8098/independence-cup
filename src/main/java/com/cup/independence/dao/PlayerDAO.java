package com.cup.independence.dao;

import com.cup.independence.model.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Player player) {
        entityManager.persist(player);
    }

    public void update(Player player) {
        entityManager.merge(player);
    }

    public Player getPlayerById(long id) {
        return entityManager.find(Player.class, id);
    }

    public void delete(long id) {
        Player player = getPlayerById(id);
        if (player != null) {
            entityManager.remove(player);
        }
    }
}
