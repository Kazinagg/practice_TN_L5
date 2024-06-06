package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Theatre {
    private String name;
    private String artisticDirector;
    private String address;
    private double rating;

    public Theatre(String name, String artisticDirector, String address, double rating) {
        this.name = name;
        this.artisticDirector = artisticDirector;
        this.address = address;
        this.rating = rating;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtisticDirector() {
        return artisticDirector;
    }

    public void setArtisticDirector(String artisticDirector) {
        this.artisticDirector = artisticDirector;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "name='" + name + '\'' +
                ", artisticDirector='" + artisticDirector + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }

    // Метод для определения театра с самым большим рейтингом
    public static Theatre findTheatreWithHighestRating(List<Theatre> theatres) {
        return Collections.max(theatres, Comparator.comparingDouble(Theatre::getRating));
    }

    // Метод для упорядочивания массива по названиям в обратном порядке
    public static void sortTheatresByNameDescending(List<Theatre> theatres) {
        theatres.sort((theatre1, theatre2) -> theatre2.getName().compareTo(theatre1.getName()));
    }

    // Метод для поиска по фамилии художественного руководителя, исправления одного из полей и вывода полной информации о театре после редактирования
    public static Theatre findAndEditTheatre(List<Theatre> theatres, String artisticDirectorLastName, String field, Object newValue) {
        for (Theatre theatre : theatres) {
            if (theatre.getArtisticDirector().split(" ")[1].equalsIgnoreCase(artisticDirectorLastName)) {
                switch (field.toLowerCase()) {
                    case "name":
                        theatre.setName((String) newValue);
                        break;
                    case "artisticdirector":
                        theatre.setArtisticDirector((String) newValue);
                        break;
                    case "address":
                        theatre.setAddress((String) newValue);
                        break;
                    case "rating":
                        theatre.setRating((Double) newValue);
                        break;
                }
                return theatre;
            }
        }
        return null;
    }

    // Метод для вывода информации о театрах с более высоким рейтингом, чем рейтинг театра с названием, заданным пользователем
    public static List<Theatre> findTheatresWithHigherRating(List<Theatre> theatres, String theatreName) {
        Theatre referenceTheatre = theatres.stream()
                .filter(theatre -> theatre.getName().equalsIgnoreCase(theatreName))
                .findFirst()
                .orElse(null);

        if (referenceTheatre != null) {
            double referenceRating = referenceTheatre.getRating();
            return theatres.stream()
                    .filter(theatre -> theatre.getRating() > referenceRating)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
