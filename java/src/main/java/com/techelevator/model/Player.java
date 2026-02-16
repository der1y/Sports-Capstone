package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

    @JsonProperty("PlayerId")
    private int playerId;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Position")
    private String position;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("College")
    private String college;
    @JsonProperty("Age")
    private int age;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
