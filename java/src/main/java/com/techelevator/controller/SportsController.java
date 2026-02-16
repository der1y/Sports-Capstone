package com.techelevator.controller;

import com.techelevator.dao.StandingDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Player;
import com.techelevator.model.Standing;
import com.techelevator.service.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController // How spring framework knows which file are controllers (files with API endpoints)
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class SportsController {

    private StandingDao standingDao;
    private UserDao userDao;
    private SportsService sportsService;

    public SportsController(StandingDao standingDao, UserDao userDao, SportsService sportsService) {
        this.standingDao = standingDao;
        this.userDao = userDao;
        this.sportsService = sportsService;
    }

    @GetMapping("/standing")
    public Standing[] getTeamStandings() {
        return sportsService.getStandings();
    }

    @GetMapping("/players/{team}")
    public List<Player> getPlayersByTeam(@PathVariable String team) {
        return sportsService.getPlayersByTeam(team);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/favorite")
    public Standing saveFavorite(@RequestBody Standing standing, Principal principal) {
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return standingDao.saveStanding(standing, userId, LocalDate.now());
    }
}
