package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Standing {


    private int id;
    private LocalDate standingDate;
    @JsonProperty("Season")
    private int season;
    @JsonProperty("Conference")
    private String conference;
    @JsonProperty("Division")
    private String division;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("Name")
    private String teamName;
    @JsonProperty("Wins")
    private int wins;
    @JsonProperty("Losses")
    private int losses;
    @JsonProperty("Ties")
    private int ties;
    @JsonProperty("DivisionRank")
    private int divisionRank;

    public int getStandingId() {
        return id;
    }

    public void setStandingId(int id) {
        this.id = id;
    }

    public LocalDate getStandingDate() {
        return standingDate;
    }

    public void setStandingDate(LocalDate standingDate) {
        this.standingDate = standingDate;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getDivisionRank() {
        return divisionRank;
    }

    public void setDivisionRank(int divisionRank) {
        this.divisionRank = divisionRank;
    }

    @Override
    public String toString() {
        return "\n****************************************\nStandings for " +
                teamName +
                "\n season: " + season +
                "\n conference: " + conference +
                "\n division: " + division +
                "\n team: " + team +
                "\n teamName: " + teamName +
                "\n wins: " + wins +
                "\n losses: " + losses +
                "\n ties: " + ties +
                "\n divisionRank: " + divisionRank +
                "\n";
    }
}
