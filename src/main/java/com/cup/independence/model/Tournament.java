package com.cup.independence.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tournament", uniqueConstraints={@UniqueConstraint(columnNames={"tournamentName", "year"})})
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tournamentName;
    private String year;
    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Team> teams;
    private String format;

    public Tournament(String tournamentName, String year, String format) {
        this.tournamentName = tournamentName;
        this.year = year;
        this.format = format;
    }

    public Tournament() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournamentName='" + tournamentName + '\'' +
                ", year='" + year + '\'' +
                ", teams=" + teams +
                ", format='" + format + '\'' +
                '}';
    }
}
