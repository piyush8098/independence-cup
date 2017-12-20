package com.cup.independence.dao;

import com.cup.independence.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDAO extends BaseDAO {
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
