package com.cup.independence.dao;

import com.cup.independence.model.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {
}
