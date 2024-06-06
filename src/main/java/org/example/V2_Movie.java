package org.example;

public class Movie {
    private String title;
    private int releaseYear;
    private String country;
    private String genre;
    private double rentalCost;

    public Movie(String title, int releaseYear, String country, String genre, double rentalCost) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.country = country;
        this.genre = genre;
        this.rentalCost = rentalCost;
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", rentalCost=" + rentalCost +
                '}';
    }

    // Метод для определения фильмов со стоимостью проката выше средней
    public static List<Movie> findMoviesAboveAverageRentalCost(List<Movie> movies) {
        double average = movies.stream().mapToDouble(Movie::getRentalCost).average().orElse(0);
        return movies.stream().filter(movie -> movie.getRentalCost() > average).collect(Collectors.toList());
    }

    // Метод для вывода информации о фильме самого раннего года выпуска
    public static Movie findOldestMovie(List<Movie> movies) {
        return Collections.min(movies, Comparator.comparingInt(Movie::getReleaseYear));
    }

    // Метод для упорядочивания массива по названиям фильмов в алфавитном порядке
    public static void sortMoviesAlphabetically(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getTitle));
    }

    // Метод для поиска по названию, исправления одного из полей и вывода полной информации о фильме после редактирования
    public static Movie findAndEditMovie(List<Movie> movies, String title, String field, Object newValue) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                switch (field.toLowerCase()) {
                    case "title":
                        movie.setTitle((String) newValue);
                        break;
                    case "releaseyear":
                        movie.setReleaseYear((Integer) newValue);
                        break;
                    case "country":
                        movie.setCountry((String) newValue);
                        break;
                    case "genre":
                        movie.setGenre((String) newValue);
                        break;
                    case "rentalcost":
                        movie.setRentalCost((Double) newValue);
                        break;
                }
                return movie;
            }
        }
        return null;
    }
}
