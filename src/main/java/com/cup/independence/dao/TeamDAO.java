package com.cup.independence.dao;

import com.cup.independence.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Team> getTeamsByTournamentId(long tourneyId) {

        List<Team> teams = entityManager.createQuery("select team from Team as t where t.tournament_id = ?1")
                .setParameter(1, tourneyId)
                .getResultList();
        return teams;
    }

    public void delete(long id) {
        Team team = getTeamById(id);
        if (team != null) {
            entityManager.remove(team);
        }
    }
}
