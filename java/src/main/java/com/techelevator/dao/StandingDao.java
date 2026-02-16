package com.techelevator.dao;

import com.techelevator.model.Standing;

import java.time.LocalDate;
import java.util.List;

public interface StandingDao {

    // CRUD
    public Standing saveStanding(Standing standing, int userId, LocalDate date);

    public List<Standing> getTeamStandingsByUserId(int userId);

    public Standing getStandingById(int standingId);
}
