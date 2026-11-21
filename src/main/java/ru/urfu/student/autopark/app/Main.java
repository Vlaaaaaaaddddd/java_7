package ru.urfu.student.autopark.app;

import ru.urfu.student.autopark.model.*;
import ru.urfu.student.autopark.exception.*;
import ru.urfu.student.autopark.service.GarageService;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Owner vlad = new Owner("Влад", "Худяков", 19);
        Owner ilon = new Owner("Илон", "Маск", 55);
        Owner maxim = new Owner("Максим", "Попкин", 13);

        Cars vesta1 = new LadaVesta(DriveType.FRONT_WHEEL, FuelType.PETROL_92,
                11.2, 162, vlad, 100_000);
        Cars modelS1 = new TeslaModelS(DriveType.ALL_WHEEL, FuelType.ELECTRIC,
                3.2, 250, ilon, 80);

        List<Owner> owners = new ArrayList<>(List.of(vlad, ilon, maxim));
        Collections.sort(owners);

        GarageService service = new GarageService(2);


        try {
            service.addCar(vesta1);
            service.addCar(modelS1);

            // Просто операции с машинами для теста
            vesta1.startEngine();
            modelS1.drift();
            modelS1.changeOwner(vlad);

            // Пытаемся добавить 3 машину в двухместный гараж
            Cars extraVesta = new LadaVesta(DriveType.FRONT_WHEEL, FuelType.PETROL_95,
                    10.5, 170, ilon, 15_000);
            service.addCar(extraVesta);
        } catch (GarageFullException e) {
            System.out.println("Ошибка гаража: " + e.getMessage());
        }

        // Пытаемся переписать машину на несовершеннолетнего
        try {
            modelS1.changeOwner(maxim);
        } catch (UnderageOwnerException e) {
            System.out.println("Ошибка переоформления: " + e.getMessage());
        }

        // Попытка создать человека с отрицательным возрастом
        try {
            Owner badOwner = new Owner("Тест", "Ошибкин", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания владельца: " + e.getMessage());
        }

        // Попытка завести разряженную теслу
        try {
            Cars deadTesla = new TeslaModelS(DriveType.ALL_WHEEL, FuelType.ELECTRIC,
                    3.2, 250, vlad, 0);
            deadTesla.startEngine();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка запуска: " + e.getMessage());
        }

        // Попытка создать машину с отрицательным пробегом
        try {
            Cars brokenVesta = new LadaVesta(DriveType.FRONT_WHEEL, FuelType.PETROL_92,
                    11.2, 162, vlad, -230);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания машины: " + e.getMessage());
        }
    }
}
