package com.cup.independence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class InningBowlingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private BigDecimal overs;
    private Integer maidens;
    private Integer runs;
    private Integer wickets;
    private BigDecimal rating;

    public InningBowlingDetails(String playerName, BigDecimal overs, Integer maidens, Integer runs, Integer wickets, BigDecimal rating) {
        this.playerName = playerName;
        this.overs = overs;
        this.maidens = maidens;
        this.runs = runs;
        this.wickets = wickets;
        this.rating = rating;
    }

    public InningBowlingDetails() {
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

    public BigDecimal getOvers() {
        return overs;
    }

    public void setOvers(BigDecimal overs) {
        this.overs = overs;
    }

    public Integer getMaidens() {
        return maidens;
    }

    public void setMaidens(Integer maidens) {
        this.maidens = maidens;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "InningBowlingDetails{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", overs=" + overs +
                ", maidens=" + maidens +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", rating=" + rating +
                '}';
    }
}
