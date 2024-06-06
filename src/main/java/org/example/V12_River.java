package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class River {
    private String name;
    private String location;
    private double length;

    public River(String name, String location, double length) {
        this.name = name;
        this.location = location;
        this.length = length;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", length=" + length +
                '}';
    }

    // Метод для определения самой короткой реки
    public static River findShortestRiver(List<River> rivers) {
        return Collections.min(rivers, Comparator.comparingDouble(River::getLength));
    }

    // Метод для вывода информации о реках с длиной больше средней
    public static List<River> findRiversWithLengthAboveAverage(List<River> rivers) {
        double averageLength = rivers.stream().mapToDouble(River::getLength).average().orElse(0);
        return rivers.stream().filter(river -> river.getLength() > averageLength).collect(Collectors.toList());
    }

    // Метод для упорядочивания списка рек по названиям в алфавитном порядке
    public static void sortRiversByName(List<River> rivers) {
        rivers.sort(Comparator.comparing(River::getName));
    }

    // Метод для поиска по названию реки, исправления одного из полей и вывода полной информации о реке после редактирования
    public static River findAndEditRiver(List<River> rivers, String name, String field, Object newValue) {
        for (River river : rivers) {
            if (river.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        river.setName((String) newValue);
                        break;
                    case "location":
                        river.setLocation((String) newValue);
                        break;
                    case "length":
                        river.setLength((Double) newValue);
                        break;
                }
                return river;
            }
        }
        return null;
    }
}