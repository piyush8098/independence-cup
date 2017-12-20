package com.cup.independence.dao;

import com.cup.independence.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TournamentDAO extends BaseDAO {
    @Autowired
    TournamentRepository tournamentRepository;

    public void create(Tournament tournament) {
        entityManager.persist(tournament);
    }

    public void update(Tournament tournament) {
        entityManager.merge(tournament);
    }

    public Tournament getTournamentById(long id) {
        return entityManager.find(Tournament.class, id);
    }

    public void delete(long id) {
        Tournament tournament = getTournamentById(id);
        if (tournament != null) {
            entityManager.remove(tournament);
        }
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
}
