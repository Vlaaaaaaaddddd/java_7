package ru.urfu.student.autopark.service;

import ru.urfu.student.autopark.exception.GarageFullException;
import ru.urfu.student.autopark.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class GarageService {
    private final List<Cars> garage = new ArrayList<>();
    private final int maxCapacity;

    public GarageService(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addCar(Cars car) throws GarageFullException {
        if (garage.size() >= maxCapacity) {
            throw new GarageFullException("Гараж заполнен! Максимум мест: " + maxCapacity);
        }
        garage.add(car);
        System.out.println("Машина добавлена в гараж.");
    }

}