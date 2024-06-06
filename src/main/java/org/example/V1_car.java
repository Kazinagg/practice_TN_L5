package org.example;
import java.util.*;

public class Car_v1 {

    private String model;
    private String registrationNumber;
    private int yearOfManufacture;
    private double mileage;
    private double cost;

    public Car_v1(String model, String registrationNumber, int yearOfManufacture, double mileage, double cost) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.cost = cost;
    }

    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", mileage=" + mileage +
                ", cost=" + cost +
                '}';
    }

    // Метод для определения самого дешевого автомобиля
    public static Car_v1 findCheapestCar(List<Car_v1> cars) {
        return Collections.min(cars, Comparator.comparing(Car_v1::getCost));
    }

    // Метод для упорядочивания массива по убыванию года выпуска
    public static void sortByYearDescending(List<Car_v1> cars) {
        cars.sort((car1, car2) -> car2.getYearOfManufacture() - car1.getYearOfManufacture());
    }

    // Метод для поиска по регистрационному номеру и редактирования
    public static Car_v1 findAndEditCar(List<Car_v1> cars, String registrationNumber, String field, Object newValue) {
        for (Car_v1 car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                switch (field.toLowerCase()) {
                    case "model":
                        car.setModel((String) newValue);
                        break;
                    case "yearofmanufacture":
                        car.setYearOfManufacture((Integer) newValue);
                        break;
                    case "mileage":
                        car.setMileage((Double) newValue);
                        break;
                    case "cost":
                        car.setCost((Double) newValue);
                        break;
                }
                return car;
            }
        }
        return null;
    }
}
