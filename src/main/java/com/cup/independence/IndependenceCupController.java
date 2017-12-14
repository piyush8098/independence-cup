package com.cup.independence;

import com.cup.independence.model.Player;
import com.cup.independence.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class IndependenceCupController {
    private static final Logger logger = LoggerFactory.getLogger(IndependenceCupController.class);

    @Autowired
    private IndependenceCupService independenceCupService;

    @GetMapping(value = "/admin")//, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView display() {
        ModelMap model = new ModelMap();
        Player player = independenceCupService.getPlayer(1);

        model.addAttribute("player", player);
        ModelAndView mv = new ModelAndView("home", model);
        return mv;
    }

    @PostMapping("/addTeam")
    public ModelAndView addTeam(@RequestParam String name, @RequestParam(required = false) String groupName) {
        ModelMap model = new ModelMap();
        Team team = new Team();
        team.setName(name);
        team.setGroupName(groupName);
        independenceCupService.createTeam(team);
        return displayTeams(model);
    }

    @GetMapping("/team")
    public ModelAndView displayTeams(ModelMap model) {
        model.addAttribute("teams", independenceCupService.getAllTeams());
        return new ModelAndView("team", model);
    }
}
