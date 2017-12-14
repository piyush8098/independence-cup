package com.cup.independence.model;

import javax.persistence.*;

@Entity
@Table(name = "fixture")
public class Fixture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateAndTime;
    private String team1;
    private String team2;
    private String venue;
    private String round;
    private String result;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "first_inning_id")
    private Inning firstInning;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_inning_id")
    private Inning secondInning;
    private String manOfTheMatch;
    private String tossWonBy;
    private String tossDecision;

    public Fixture(String dateAndTime, String team1, String team2, String venue, String round, String result, String manOfTheMatch, String tossWonBy, String tossDecision) {
        this.dateAndTime = dateAndTime;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.round = round;
        this.result = result;
        this.manOfTheMatch = manOfTheMatch;
        this.tossWonBy = tossWonBy;
        this.tossDecision = tossDecision;
    }

    public Fixture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Inning getFirstInning() {
        return firstInning;
    }

    public void setFirstInning(Inning firstInning) {
        this.firstInning = firstInning;
    }

    public Inning getSecondInning() {
        return secondInning;
    }

    public void setSecondInning(Inning secondInning) {
        this.secondInning = secondInning;
    }

    public String getManOfTheMatch() {
        return manOfTheMatch;
    }

    public void setManOfTheMatch(String manOfTheMatch) {
        this.manOfTheMatch = manOfTheMatch;
    }

    public String getTossWonBy() {
        return tossWonBy;
    }

    public void setTossWonBy(String tossWonBy) {
        this.tossWonBy = tossWonBy;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "id=" + id +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", venue='" + venue + '\'' +
                ", round='" + round + '\'' +
                ", result='" + result + '\'' +
                ", firstInning=" + firstInning +
                ", secondInning=" + secondInning +
                ", manOfTheMatch='" + manOfTheMatch + '\'' +
                ", tossWonBy='" + tossWonBy + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                '}';
    }
}
