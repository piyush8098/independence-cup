package com.cup.independence.model;

import javax.persistence.*;

@Entity
@Table(name = "player", uniqueConstraints={@UniqueConstraint(columnNames={"name", "dob"})})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dob;
    private String role;
    private Integer totalRunsScored;
    private Integer totalOversBowled;
    private Integer ranking;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(String name, String dob, String role, Integer totalRunsScored, Integer totalOversBowled, Integer ranking) {
        this.name = name;
        this.dob = dob;
        this.role = role;
        this.totalRunsScored = totalRunsScored;
        this.totalOversBowled = totalOversBowled;
        this.ranking = ranking;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team tea) {
        this.team = team;
    }

    public Integer getTotalRunsScored() {
        return totalRunsScored;
    }

    public void setTotalRunsScored(Integer totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    public Integer getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(Integer totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", role='" + role + '\'' +
                ", totalRunsScored=" + totalRunsScored +
                ", totalOversBowled=" + totalOversBowled +
                ", ranking=" + ranking +
                ", team=" + team +
                '}';
    }
}
