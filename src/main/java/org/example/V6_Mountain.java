package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Mountain {
    private String name;
    private String location;
    private int height;

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", height=" + height +
                '}';
    }

    // Метод для определения самой высокой вершины
    public static Mountain findHighestMountain(List<Mountain> mountains) {
        return Collections.max(mountains, Comparator.comparingInt(Mountain::getHeight));
    }

    // Метод для определения вершин с высотой более 1000 м
    public static List<Mountain> findMountainsAbove1000m(List<Mountain> mountains) {
        return mountains.stream().filter(mountain -> mountain.getHeight() > 1000).collect(Collectors.toList());
    }

    // Метод для упорядочивания массива по возрастанию высот
    public static void sortMountainsByHeightAscending(List<Mountain> mountains) {
        mountains.sort(Comparator.comparingInt(Mountain::getHeight));
    }

    // Метод для поиска по названию вершины, исправления одного из полей и вывода полной информации о вершине после редактирования
    public static Mountain findAndEditMountain(List<Mountain> mountains, String name, String field, Object newValue) {
        for (Mountain mountain : mountains) {
            if (mountain.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        mountain.setName((String) newValue);
                        break;
                    case "location":
                        mountain.setLocation((String) newValue);
                        break;
                    case "height":
                        mountain.setHeight((Integer) newValue);
                        break;
                }
                return mountain;
            }
        }
        return null;
    }
}
