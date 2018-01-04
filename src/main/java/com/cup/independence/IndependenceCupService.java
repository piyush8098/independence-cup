package com.cup.independence;

import com.cup.independence.dao.PlayerDAO;
import com.cup.independence.dao.TeamDAO;
import com.cup.independence.dao.TournamentDAO;
import com.cup.independence.model.Player;
import com.cup.independence.model.Team;
import com.cup.independence.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class IndependenceCupService {
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private TournamentDAO tournamentDAO;

    public void createPlayer(Player player) {
        playerDAO.create(player);
    }

    public Player getPlayer(long id) {
        return playerDAO.getPlayerById(id);
    }

    public void createTeam(Team team) {
        teamDAO.create(team);
    }

    public Tournament getTournament(Long id) {
        return tournamentDAO.getTournamentById(id);
    }

    public Team getTeam(Long id) {
        return teamDAO.getTeamById(id);
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentDAO.getAllTournaments();
    }

    public void createTournament(Tournament tournament) {
        tournamentDAO.create(tournament);
    }
}
