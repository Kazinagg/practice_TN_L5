package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String lastName;
    private String firstName;
    private char gender; // 'M' для мужчин, 'F' для женщин
    private int height;

    public Person(String lastName, String firstName, char gender, int height) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.height = height;
    }

    // Геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                '}';
    }

    // Метод для определения среднего роста женщин и мужчин
    public static Map<Character, Double> findAverageHeightByGender(List<Person> people) {
        Map<Character, Double> averageHeights = new HashMap<>();
        averageHeights.put('M', people.stream()
                .filter(person -> person.getGender() == 'M')
                .mapToInt(Person::getHeight)
                .average()
                .orElse(0));
        averageHeights.put('F', people.stream()
                .filter(person -> person.getGender() == 'F')
                .mapToInt(Person::getHeight)
                .average()
                .orElse(0));
        return averageHeights;
    }

    // Метод для определения самого высокого мужчины
    public static Person findTallestMan(List<Person> people) {
        return people.stream()
                .filter(person -> person.getGender() == 'M')
                .max(Comparator.comparingInt(Person::getHeight))
                .orElse(null);
    }

    // Метод для упорядочивания списка по возрастанию роста
    public static void sortPeopleByHeightAscending(List<Person> people) {
        people.sort(Comparator.comparingInt(Person::getHeight));
    }

    // Метод для поиска по фамилии, исправления одного из полей и вывода полной информации о человеке после редактирования
    public static Person findAndEditPerson(List<Person> people, String lastName, String field, Object newValue) {
        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                switch (field.toLowerCase()) {
                    case "lastname":
                        person.setLastName((String) newValue);
                        break;
                    case "firstname":
                        person.setFirstName((String) newValue);
                        break;
                    case "gender":
                        person.setGender(((String) newValue).charAt(0));
                        break;
                    case "height":
                        person.setHeight((Integer) newValue);
                        break;
                }
                return person;
            }
        }
        return null;
    }
}
