package com.cup.independence;

import com.cup.independence.dao.PlayerDAO;
import com.cup.independence.dao.TeamDAO;
import com.cup.independence.model.Player;
import com.cup.independence.model.Team;
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

    public void createPlayer(Player player) {
        playerDAO.create(player);
    }

    public void createTeam(Team team) {
        teamDAO.create(team);
    }

    public Player getPlayer(long id) {
        return playerDAO.getPlayerById(id);
    }

    public Iterable<Team> getAllTeams() {
        return teamDAO.getAllTeams();
    }
}
