package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Singer {
    private String name;
    private double rating;
    private int albumsReleased;

    public Singer(String name, double rating, int albumsReleased) {
        this.name = name;
        this.rating = rating;
        this.albumsReleased = albumsReleased;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAlbumsReleased() {
        return albumsReleased;
    }

    public void setAlbumsReleased(int albumsReleased) {
        this.albumsReleased = albumsReleased;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", albumsReleased=" + albumsReleased +
                '}';
    }

    // Метод для определения самого популярного исполнителя
    public static Singer findMostPopularSinger(List<Singer> singers) {
        return Collections.max(singers, Comparator.comparingDouble(Singer::getRating));
    }

    // Метод для определения среднего количества выпущенных альбомов и исполнителей с количеством выпущенных альбомов больше среднего
    public static double calculateAverageAlbumsReleased(List<Singer> singers) {
        return singers.stream().mapToInt(Singer::getAlbumsReleased).average().orElse(0);
    }

    public static List<Singer> findSingersWithAlbumsAboveAverage(List<Singer> singers, double averageAlbums) {
        return singers.stream().filter(singer -> singer.getAlbumsReleased() > averageAlbums).collect(Collectors.toList());
    }

    // Метод для упорядочивания массива по фамилиям исполнителей в порядке, обратном алфавитному
    public static void sortSingersByNameDescending(List<Singer> singers) {
        singers.sort((singer1, singer2) -> singer2.getName().compareTo(singer1.getName()));
    }

    // Метод для поиска по фамилии, исправления одного из полей записи и вывода полной информации о песне после редактирования
    public static Singer findAndEditSinger(List<Singer> singers, String name, String field, Object newValue) {
        for (Singer singer : singers) {
            if (singer.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        singer.setName((String) newValue);
                        break;
                    case "rating":
                        singer.setRating((Double) newValue);
                        break;
                    case "albumsreleased":
                        singer.setAlbumsReleased((Integer) newValue);
                        break;
                }
                return singer;
            }
        }
        return null;
    }
}
