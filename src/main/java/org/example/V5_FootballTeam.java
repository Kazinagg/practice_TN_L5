package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FootballTeam {
    private String name;
    private String city;
    private int leaguePosition;
    private int victories;

    public FootballTeam(String name, String city, int leaguePosition, int victories) {
        this.name = name;
        this.city = city;
        this.leaguePosition = leaguePosition;
        this.victories = victories;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", leaguePosition=" + leaguePosition +
                ", victories=" + victories +
                '}';
    }

    // Метод для определения команды с самым большим количеством побед
    public static FootballTeam findTeamWithMostVictories(List<FootballTeam> teams) {
        return Collections.max(teams, Comparator.comparingInt(FootballTeam::getVictories));
    }

    // Метод для определения команд с количеством побед больше среднего
    public static List<FootballTeam> findTeamsWithAboveAverageVictories(List<FootballTeam> teams) {
        double averageVictories = teams.stream().mapToInt(FootballTeam::getVictories).average().orElse(0);
        return teams.stream().filter(team -> team.getVictories() > averageVictories).collect(Collectors.toList());
    }

    // Метод для упорядочивания массива по убыванию мест в лиге
    public static void sortTeamsByLeaguePositionDescending(List<FootballTeam> teams) {
        teams.sort((team1, team2) -> Integer.compare(team2.getLeaguePosition(), team1.getLeaguePosition()));
    }

    // Метод для поиска по названию команды, исправления одного из полей и вывода полной информации о команде после редактирования
    public static FootballTeam findAndEditTeam(List<FootballTeam> teams, String name, String field, Object newValue) {
        for (FootballTeam team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        team.setName((String) newValue);
                        break;
                    case "city":
                        team.setCity((String) newValue);
                        break;
                    case "leagueposition":
                        team.setLeaguePosition((Integer) newValue);
                        break;
                    case "victories":
                        team.setVictories((Integer) newValue);
                        break;
                }
                return team;
            }
        }
        return null;
    }
}