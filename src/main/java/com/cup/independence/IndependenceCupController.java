package com.cup.independence;

import com.cup.independence.model.Player;
import com.cup.independence.model.Team;
import com.cup.independence.model.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@Controller
@EnableAutoConfiguration
public class IndependenceCupController {
    private static final Logger logger = LoggerFactory.getLogger(IndependenceCupController.class);

    @Autowired
    private IndependenceCupService independenceCupService;

    @GetMapping(value = {"/admin", "/"})
    public ModelAndView display(ModelMap modelMap) {
        modelMap.addAttribute("tournaments", independenceCupService.getAllTournaments());
        ModelAndView mv = new ModelAndView("admin/home", modelMap);
        return mv;
    }

    @GetMapping(value = {"/get-teams"})
    public ModelAndView getTeams(ModelMap modelMap, @RequestParam Long tournamentId) {

        modelMap.addAttribute("tournaments", independenceCupService.getAllTournaments());
        ModelAndView mv = new ModelAndView("admin/home", modelMap);
        return mv;
    }

    @PostMapping("/openTeam")
    public ModelAndView openTeamTab(@RequestParam Long tournamentId) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("activeTab", "TEAM");
        Iterable<Tournament> tournaments = independenceCupService.getAllTournaments();
        Set<Team> teams = null;
        for(Tournament tournament : tournaments) {
            if(tournament.getId().equals(tournamentId)) {
                teams = tournament.getTeams();
                break;
            }
        }
        modelMap.addAttribute("teams", teams);
        modelMap.addAttribute("tournaments", independenceCupService.getAllTournaments());
        modelMap.addAttribute("tournamentId", tournamentId);
        return new ModelAndView("admin/home", modelMap);
    }


    @PostMapping("/addTeam")
    public ModelAndView addTeam(@RequestParam String name, @RequestParam Long tournamentId, @RequestParam(required = false) String groupName) {
        Team team = new Team(name, groupName);
        team.setTournament(independenceCupService.getTournament(tournamentId));
        independenceCupService.createTeam(team);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("activeTab", "TEAM");
        modelMap.addAttribute("tournamentId", tournamentId);
        modelMap.addAttribute("teams", team.getTournament().getTeams());
        modelMap.addAttribute("tournaments", independenceCupService.getAllTournaments());
        return new ModelAndView("admin/home", modelMap);
    }

    @PostMapping("/addTourney")
    public ModelAndView addTourney(@RequestParam String name, @RequestParam(required = false) String year, String format) {
        Tournament tournament = new Tournament(name, year, format);
        independenceCupService.createTournament(tournament);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("activeTab", "TOURNEY");
        return new ModelAndView("admin/home", modelMap);
    }

    @PostMapping("/addPlayer")
    public ModelAndView addPlayer(@RequestParam String name, @RequestParam(required = false) String dob, @RequestParam String role,@RequestParam Long teamId) {
        Player player = new Player(name,dob,role,0,0,0);
        player.setTeam(independenceCupService.getTeam(teamId));
        independenceCupService.createPlayer(player);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("activeTab", "PLAYER");
        return new ModelAndView("admin/home", modelMap);
    }


    /* Will complete this next change */

    /*@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/getPlayerList")
    public @ResponseBody Set<Player> getPlayerList(@RequestParam Long teamId){
        Team team = independenceCupService.getTeam(teamId);
        Set<Player> players = team.getPlayers();
        return players;
    }*/
}
