package com.cup.independence.dao;

import com.cup.independence.model.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAO extends BaseDAO {

    public void create(Team team) {
        entityManager.persist(team);
    }

    public void update(Team team) {
        entityManager.merge(team);
    }

    public Team getTeamById(long id) {
        return entityManager.find(Team.class, id);
    }

    public void delete(long id) {
        Team team = getTeamById(id);
        if (team != null) {
            entityManager.remove(team);
        }
    }
}
