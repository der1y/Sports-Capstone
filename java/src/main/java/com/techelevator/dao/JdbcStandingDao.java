package com.techelevator.dao;

import com.techelevator.model.Standing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStandingDao implements StandingDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcStandingDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Standing saveStanding(Standing standing, int userId, LocalDate date) {
        String sql = "INSERT INTO standing " +
                "(standing_date, season, conference, division, team, " +
                "team_name, wins, losses, ties, division_rank) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        int standingId = jdbcTemplate.queryForObject(sql, int.class,
                date, standing.getSeason(), standing.getConference(), standing.getDivision(),
                standing.getTeam(), standing.getTeamName(), standing.getWins(),
                standing.getLosses(), standing.getTies(), standing.getDivisionRank());
        sql = "INSERT INTO users_standing (user_id, standing_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, standingId);

        return getStandingById(standingId);
    }

    @Override
    public List<Standing> getTeamStandingsByUserId(int userId) {
        String sql = "SELECT * FROM standing s JOIN users_standing us ON s.id = us.standing_id " +
                "WHERE us.user_id = ?";
        SqlRowSet set = jdbcTemplate.queryForRowSet(sql, userId);
        List<Standing> standingList = new ArrayList<>();
        while (set.next()) {
            standingList.add(mapRowToStanding(set));
        }
        return standingList;
    }

    @Override
    public Standing getStandingById(int standingId) {
        String sql = "SELECT * FROM standing WHERE id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, standingId);

        if (sqlRowSet.next()) {
            return mapRowToStanding(sqlRowSet);
        }
        return null;
    }

    private Standing mapRowToStanding(SqlRowSet set){
        Standing temp = new Standing();

        temp.setStandingId(set.getInt("id"));
        temp.setSeason(set.getInt("season"));
        temp.setConference(set.getString("conference"));
        temp.setDivision(set.getString("division"));
        temp.setDivisionRank(set.getInt("division_rank"));
        temp.setWins(set.getInt("wins"));
        temp.setLosses(set.getInt("losses"));
        temp.setTeam(set.getString("team"));
        temp.setTeamName(set.getString("team_name"));
        temp.setTies(set.getInt("ties"));
        temp.setStandingDate(set.getDate("standing_date").toLocalDate());

        return temp;
    }
}
