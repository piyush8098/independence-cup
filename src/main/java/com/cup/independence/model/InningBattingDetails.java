package com.cup.independence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InningBattingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private String howOut;
    private String bowler;
    private Integer runs;
    private Integer balls;
    private Integer numberOfFours;
    private Integer numberOfSixes;

    public InningBattingDetails(String playerName, String howOut, String bowler, Integer runs, Integer balls, Integer numberOfFours, Integer numberOfSixes) {
        this.playerName = playerName;
        this.howOut = howOut;
        this.bowler = bowler;
        this.runs = runs;
        this.balls = balls;
        this.numberOfFours = numberOfFours;
        this.numberOfSixes = numberOfSixes;
    }

    public InningBattingDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getHowOut() {
        return howOut;
    }

    public void setHowOut(String howOut) {
        this.howOut = howOut;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getNumberOfFours() {
        return numberOfFours;
    }

    public void setNumberOfFours(Integer numberOfFours) {
        this.numberOfFours = numberOfFours;
    }

    public Integer getNumberOfSixes() {
        return numberOfSixes;
    }

    public void setNumberOfSixes(Integer numberOfSixes) {
        this.numberOfSixes = numberOfSixes;
    }

    @Override
    public String toString() {
        return "InningBattingDetails{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", howOut='" + howOut + '\'' +
                ", bowler='" + bowler + '\'' +
                ", runs=" + runs +
                ", balls=" + balls +
                ", numberOfFours=" + numberOfFours +
                ", numberOfSixes=" + numberOfSixes +
                '}';
    }
}
