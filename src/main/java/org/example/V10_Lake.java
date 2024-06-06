package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Lake {
    private String name;
    private String location;
    private double area;

    public Lake(String name, String location, double area) {
        this.name = name;
        this.location = location;
        this.area = area;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Lake{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                '}';
    }

    // Метод для определения самого большого озера
    public static Lake findLargestLake(List<Lake> lakes) {
        return Collections.max(lakes, Comparator.comparingDouble(Lake::getArea));
    }

    // Метод для подсчета количества озер с площадью меньше средней
    public static long countLakesWithAreaBelowAverage(List<Lake> lakes) {
        double averageArea = lakes.stream().mapToDouble(Lake::getArea).average().orElse(0);
        return lakes.stream().filter(lake -> lake.getArea() < averageArea).count();
    }

    // Метод для упорядочивания списка по названиям
    public static void sortLakesByName(List<Lake> lakes) {
        lakes.sort(Comparator.comparing(Lake::getName));
    }

    // Метод для поиска по названию озера, исправления одного из полей и вывода полной информации об озере после редактирования
    public static Lake findAndEditLake(List<Lake> lakes, String name, String field, Object newValue) {
        for (Lake lake : lakes) {
            if (lake.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        lake.setName((String) newValue);
                        break;
                    case "location":
                        lake.setLocation((String) newValue);
                        break;
                    case "area":
                        lake.setArea((Double) newValue);
                        break;
                }
                return lake;
            }
        }
        return null;
    }
}

