package com.techelevator.service;


import com.techelevator.model.Player;
import com.techelevator.model.Standing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class SportsService {

    private RestClient restClient;

    @Value("${sportsdata.io.key}")
    private String SPORTS_KEY;

    public SportsService(){
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("sports.properties")) {
            properties.load(fis);
            SPORTS_KEY = properties.getProperty("sportsdata.io.key");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public Standing[] getStandings(){
        String apiUrl = "https://api.sportsdata.io/v3/nfl/scores/json/Standings/2025REG?key=" + SPORTS_KEY;
//        String key = "YOUR API KEY";

        restClient = RestClient.create(apiUrl);

        return restClient.get().uri("").retrieve().body(Standing[].class);

    }

    public List<Player> getPlayersByTeam(String team) {
        String url =
                "https://api.sportsdata.io/v3/nfl/scores/json/PlayersBasic/" + team +
                        "?key=" + SPORTS_KEY;
        restClient = RestClient.create(url);

        return Arrays.asList(restClient.get().uri("").retrieve().body(Player[].class));
    }
}
