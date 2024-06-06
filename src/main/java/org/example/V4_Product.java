package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
    private String name;
    private String manufacturer;
    private int quantity;
    private double price;

    public Product(String name, String manufacturer, int quantity, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    // Метод для определения товаров с максимальным количеством единиц
    public static List<Product> findProductsWithMaxQuantity(List<Product> products) {
        int maxQuantity = products.stream().mapToInt(Product::getQuantity).max().orElse(0);
        return products.stream().filter(product -> product.getQuantity() == maxQuantity).collect(Collectors.toList());
    }

    // Метод для определения средней цены товаров и количества товаров с ценой ниже средней
    public static double findAveragePrice(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).average().orElse(0);
    }

    public static long countProductsBelowAveragePrice(List<Product> products, double averagePrice) {
        return products.stream().filter(product -> product.getPrice() < averagePrice).count();
    }

    // Метод для упорядочивания списка по убыванию цен товаров
    public static void sortProductsByPriceDescending(List<Product> products) {
        products.sort((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()));
    }

    // Метод для поиска по наименованию товара, исправления одного из полей и вывода полной информации о товаре после редактирования
    public static Product findAndEditProduct(List<Product> products, String name, String field, Object newValue) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                switch (field.toLowerCase()) {
                    case "name":
                        product.setName((String) newValue);
                        break;
                    case "manufacturer":
                        product.setManufacturer((String) newValue);
                        break;
                    case "quantity":
                        product.setQuantity((Integer) newValue);
                        break;
                    case "price":
                        product.setPrice((Double) newValue);
                        break;
                }
                return product;
            }
        }
        return null;
    }
}
