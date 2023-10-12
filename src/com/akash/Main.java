package com.akash;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void saveToFile(List<Car> cars, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.write(car.toString());
                writer.newLine();
            }
            System.out.println("Saved " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveCarsByBrand(Car[] cars, String brand) {
        List<Car> filteredCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getMake().equals(brand)) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, "carsByBrand("+brand+").txt");
    }

    private static void saveCarsByAgeAndModel(Car[] cars, int age, String model) {
        List<Car> filteredCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getModel().equals(model) && (Year.now().getValue() - car.getYearOfManufacture() < age)) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, "carsByAge("+age+")AndModel("+model+").txt");
    }

    private static void saveManufactureYearAndPrice(Car[] cars, int year, float price) {
        List<Car> filteredCars = new ArrayList<Car>();
        for (Car car : cars) {
            if ((car.getYearOfManufacture() == year) && (car.getPrice() > price)) {
                filteredCars.add(car);
            }
        }
        saveToFile(filteredCars, "carsByYear("+year+")AndPrice("+price+").txt");
    }

    public static void main(String[] args) {

    Car[] cars = new Car[20];

    cars[0] = new Car(1, "Suzuki", "Swift", 2008, "Silver", 7000, "KA05AD32");
    cars[1] = new Car(2, "Tata", "Indica", 2015, "White", 10000, "MD30GK77");
    cars[2] = new Car(3, "Tata", "Nano", 2020, "Red", 8000, "KA05SP55");
    cars[3] = new Car(4, "Volkswagen", "Golf", 2013, "Silver", 25000, "US05UD75");
    cars[4] = new Car(5, "Lamborghini", "Aventador", 2021, "Red", 300000, "DE23GU06");
    cars[5] = new Car(6, "BMW", "X5", 2019, "Black", 150000, "JP03GY84");
    cars[6] = new Car(7, "Tata", "Indica", 2020, "Silver", 12500, "IN33DA44");
    cars[7] = new Car(8, "Tesla", "Model 3", 2020, "Blue", 65000, "SO63GJ46");
    cars[8] = new Car(9, "BMW", "M4", 2018, "Green", 180000, "HR47PQ91");
    cars[9] = new Car(10, "Lamborghini", "Huracan", 2021, "Gold", 275000, "ZX87IO45");
    cars[10] = new Car(11, "Suzuki", "Swift", 2008, "Silver", 7000, "KA05AD22");
    cars[11] = new Car(12, "Tata", "Indica", 2020, "White", 10000, "MD30GK47");
    cars[12] = new Car(13, "Tata", "Nano", 2014, "Blue", 8000, "KA05SP75");
    cars[13] = new Car(14, "Volkswagen", "Golf", 2015, "Silver", 25000, "US05UD74");
    cars[14] = new Car(15, "Lamborghini", "Aventador", 2020, "Gray", 300000, "DE23GU26");
    cars[15] = new Car(16, "BMW", "X5", 2020, "Black", 150000, "JP03GY94");
    cars[16] = new Car(17, "Tata", "Indica", 2021, "White", 12500, "IN33DA64");
    cars[17] = new Car(18, "Tata", "Indica", 2022, "Blue", 65000, "SO63GJ56");
    cars[18] = new Car(19, "BMW", "M4", 2018, "Green", 180000, "HR47PQ34");
    cars[19] = new Car(20, "Lamborghini", "Huracan", 2021, "Green", 275000, "ZX87IO35");

    saveCarsByBrand(cars, "Lamborghini");
    saveCarsByAgeAndModel(cars, 4, "Indica");
    saveManufactureYearAndPrice(cars, 2020, 50000 );

    }

}