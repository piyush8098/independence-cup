package com.cup.independence.dao;

import com.cup.independence.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TeamDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    TeamRepository teamRepository;

    public void create(Team team) {
        entityManager.persist(team);
    }

    public void update(Team team) {
        entityManager.merge(team);
    }

    public Team getTeamById(long id) {
        return entityManager.find(Team.class, id);
    }

    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void delete(long id) {
        Team team = getTeamById(id);
        if (team != null) {
            entityManager.remove(team);
        }
    }
}
