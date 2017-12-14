package com.cup.independence.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Clob;

@Entity
@Table(name = "inning")
public class Inning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batting_inning_id")
    private InningBattingDetails inningBattingDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bowling_inning_id")
    private InningBowlingDetails inningBowlingDetails;

    private String battingTeamName;
    private String bowlingTeamName;
    private Integer extras;
    private Integer totalRuns;
    private BigDecimal totalOversBowled;
    private Integer totalWicketsFallen;
    private Clob fallOfWickets;
    private Clob didNotBat;

    public Inning(String battingTeamName, String bowlingTeamName, Integer extras, Integer totalRuns, BigDecimal totalOversBowled, Integer totalWicketsFallen, Clob fallOfWickets, Clob didNotBat) {
        this.battingTeamName = battingTeamName;
        this.bowlingTeamName = bowlingTeamName;
        this.extras = extras;
        this.totalRuns = totalRuns;
        this.totalOversBowled = totalOversBowled;
        this.totalWicketsFallen = totalWicketsFallen;
        this.fallOfWickets = fallOfWickets;
        this.didNotBat = didNotBat;
    }

    public Inning() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InningBattingDetails getInningBattingDetails() {
        return inningBattingDetails;
    }

    public void setInningBattingDetails(InningBattingDetails inningBattingDetails) {
        this.inningBattingDetails = inningBattingDetails;
    }

    public InningBowlingDetails getInningBowlingDetails() {
        return inningBowlingDetails;
    }

    public void setInningBowlingDetails(InningBowlingDetails inningBowlingDetails) {
        this.inningBowlingDetails = inningBowlingDetails;
    }

    public String getBattingTeamName() {
        return battingTeamName;
    }

    public void setBattingTeamName(String battingTeamName) {
        this.battingTeamName = battingTeamName;
    }

    public String getBowlingTeamName() {
        return bowlingTeamName;
    }

    public void setBowlingTeamName(String bowlingTeamName) {
        this.bowlingTeamName = bowlingTeamName;
    }

    public Integer getExtras() {
        return extras;
    }

    public void setExtras(Integer extras) {
        this.extras = extras;
    }

    public Integer getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(Integer totalRuns) {
        this.totalRuns = totalRuns;
    }

    public BigDecimal getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(BigDecimal totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }

    public Integer getTotalWicketsFallen() {
        return totalWicketsFallen;
    }

    public void setTotalWicketsFallen(Integer totalWicketsFallen) {
        this.totalWicketsFallen = totalWicketsFallen;
    }

    public Clob getFallOfWickets() {
        return fallOfWickets;
    }

    public void setFallOfWickets(Clob fallOfWickets) {
        this.fallOfWickets = fallOfWickets;
    }

    public Clob getDidNotBat() {
        return didNotBat;
    }

    public void setDidNotBat(Clob didNotBat) {
        this.didNotBat = didNotBat;
    }

    @Override
    public String toString() {
        return "Inning{" +
                "id=" + id +
                ", inningBattingDetails=" + inningBattingDetails +
                ", inningBowlingDetails=" + inningBowlingDetails +
                ", battingTeamName='" + battingTeamName + '\'' +
                ", bowlingTeamName='" + bowlingTeamName + '\'' +
                ", extras=" + extras +
                ", totalRuns=" + totalRuns +
                ", totalOversBowled=" + totalOversBowled +
                ", totalWicketsFallen=" + totalWicketsFallen +
                ", fallOfWickets=" + fallOfWickets +
                ", didNotBat=" + didNotBat +
                '}';
    }
}
