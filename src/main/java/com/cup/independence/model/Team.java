package com.cup.independence.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="tournament_team",
            inverseJoinColumns = {@JoinColumn(name = "tournamentId")},
            joinColumns = {@JoinColumn(name = "teamId")}
    )
    private Set<Tournament> tournaments = new HashSet<>();
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Player> players;
    private Integer won;
    private Integer loss;
    private Integer draw;
    private Integer points;
    private BigDecimal nrr;
    private String groupName;
    private Integer totalRunsScored;
    private Integer totalRunsConceded;
    private BigDecimal totalOversPlayed;
    private BigDecimal totalOversBowled;

    public Team(String name, Set<Player> players, Integer won, Integer loss, Integer draw, Integer points, BigDecimal nrr, String groupName, Integer totalRunsScored, Integer totalRunsConceded, BigDecimal totalOversPlayed, BigDecimal totalOversBowled) {
        this.name = name;
        this.players = players;
        this.won = won;
        this.loss = loss;
        this.draw = draw;
        this.points = points;
        this.nrr = nrr;
        this.groupName = groupName;
        this.totalRunsScored = totalRunsScored;
        this.totalRunsConceded = totalRunsConceded;
        this.totalOversPlayed = totalOversPlayed;
        this.totalOversBowled = totalOversBowled;
    }

    public Team(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    public Team() {
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLoss() {
        return loss;
    }

    public void setLoss(Integer loss) {
        this.loss = loss;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public BigDecimal getNrr() {
        return nrr;
    }

    public void setNrr(BigDecimal nrr) {
        if (totalOversBowled != null && totalOversPlayed != null && totalRunsScored != null && totalRunsConceded != null)
            this.nrr = BigDecimal.valueOf((totalRunsScored.floatValue() / totalOversPlayed.floatValue()) - (totalRunsConceded.floatValue() / totalOversBowled.floatValue()));
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getTotalRunsScored() {
        return totalRunsScored;
    }

    public void setTotalRunsScored(Integer totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    public Integer getTotalRunsConceded() {
        return totalRunsConceded;
    }

    public void setTotalRunsConceded(Integer totalRunsConceded) {
        this.totalRunsConceded = totalRunsConceded;
    }

    public BigDecimal getTotalOversPlayed() {
        return totalOversPlayed;
    }

    public void setTotalOversPlayed(BigDecimal totalOversPlayed) {
        this.totalOversPlayed = totalOversPlayed;
    }

    public BigDecimal getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(BigDecimal totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournament(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tournaments =" + tournaments.size() +
                ", players=" + players +
                ", won=" + won +
                ", loss=" + loss +
                ", draw=" + draw +
                ", points=" + points +
                ", nrr=" + nrr +
                ", groupName='" + groupName + '\'' +
                ", totalRunsScored=" + totalRunsScored +
                ", totalRunsConceded=" + totalRunsConceded +
                ", totalOversPlayed=" + totalOversPlayed +
                ", totalOversBowled=" + totalOversBowled +
                '}';
    }
}
