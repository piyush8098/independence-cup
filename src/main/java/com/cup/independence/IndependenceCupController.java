package com.cup.independence;

import com.cup.independence.model.Player;
import com.cup.independence.model.Team;
import com.cup.independence.model.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@EnableAutoConfiguration
public class IndependenceCupController {
    private static final Logger logger = LoggerFactory.getLogger(IndependenceCupController.class);

    @Autowired
    private IndependenceCupService independenceCupService;

    @GetMapping(value = {"/admin", "/"})
    public ModelAndView display() {
        ModelMap model = new ModelMap();
        model.addAttribute("tournaments", independenceCupService.getAllTournaments());
        ModelAndView mv = new ModelAndView("admin/home", model);
        return mv;
    }

    @PostMapping("/addTeam")
    public ModelAndView addTeam(@RequestParam String name, @RequestParam Long tournamentId, @RequestParam(required = false) String groupName) {
        Team team = new Team(name, groupName);
        team.setTournament(independenceCupService.getTournament(tournamentId));
        independenceCupService.createTeam(team);
        return display();
    }

    @PostMapping("/addTourney")
    public ModelAndView addTourney(@RequestParam String name, @RequestParam(required = false) String year, String format) {
        Tournament tournament = new Tournament(name, year, format);
        independenceCupService.createTournament(tournament);
        return display();
    }

    @PostMapping("/addPlayer")
    public ModelAndView addPlayer(@RequestParam String name, @RequestParam(required = false) String dob, @RequestParam String role,@RequestParam Long teamId) {
        Player player = new Player(name,dob,role,0,0,0);
        player.setTeam(independenceCupService.getTeam(teamId));
        independenceCupService.createPlayer(player);
        return display();
    }


    /* Will complete this next change */

    /*@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/getPlayerList")
    public @ResponseBody Set<Player> getPlayerList(@RequestParam Long teamId){
        Team team = independenceCupService.getTeam(teamId);
        Set<Player> players = team.getPlayers();
        return players;
    }*/
}
