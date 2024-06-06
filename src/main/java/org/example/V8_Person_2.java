package org.example;

import java.util.*;

public class Person {
    private String lastName;
    private String firstName;
    private int birthYear;
    private int birthMonth;

    public Person(String lastName, String firstName, int birthYear, int birthMonth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                '}';
    }

    // Метод для определения самого старого человека
    public static Person findOldestPerson(List<Person> people) {
        return Collections.min(people, Comparator.comparingInt(Person::getBirthYear));
    }

    // Метод для определения среднего возраста и людей старше среднего возраста
    public static double calculateAverageAge(List<Person> people, int currentYear) {
        return people.stream().mapToInt(person -> currentYear - person.getBirthYear()).average().orElse(0);
    }

    public static List<Person> findPeopleOlderThanAverage(List<Person> people, double averageAge, int currentYear) {
        return people.stream().filter(person -> (currentYear - person.getBirthYear()) > averageAge).collect(Collectors.toList());
    }

    // Метод для упорядочивания массива по фамилиям в порядке, обратном алфавитному
    public static void sortPeopleByLastNameDescending(List<Person> people) {
        people.sort((person1, person2) -> person2.getLastName().compareTo(person1.getLastName()));
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
                    case "birthyear":
                        person.setBirthYear((Integer) newValue);
                        break;
                    case "birthmonth":
                        person.setBirthMonth((Integer) newValue);
                        break;
                }
                return person;
            }
        }
        return null;
    }
}
