package ru.urfu.student.autopark.model;

import ru.urfu.student.autopark.exception.UnderageOwnerException;

public abstract class Cars implements Comparable<Cars>{
    private DriveType drive;
    private FuelType fuel;
    private double acceleration;
    private int max_speed;

    private Owner owner;

    public Cars(DriveType drive, FuelType fuel, double acceleration, int max_speed, Owner owner) {
        this.drive = drive;
        this.fuel = fuel;
        this.acceleration = acceleration;
        this.max_speed = max_speed;
        this.owner = owner;
    }

    public DriveType getDrive() {
        return this.drive;
    }

    public FuelType getFuel() {
        return this.fuel;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public int getMax_speed(){
        return this.max_speed;
    }

    public Owner getOwner() {
        return owner;
    }

    public abstract void startEngine();

    @Override
    public int compareTo(Cars other) {
        return Double.compare(this.acceleration, other.acceleration);
    }

    public void drift() {
        switch (this.drive) {
            case FRONT_WHEEL -> System.out.println(drive.getTitle() +
                                                   ": подрифтить не получится :(");
            case BACK_WHEEL, ALL_WHEEL -> System.out.println(drive.getTitle() +
                                                             ": можно навалить боком ;)");
        }
    }

    public void refuel(){
        switch (this.fuel) {
            case ELECTRIC -> System.out.println("Подключаем зарядный кабель");
            case DIESEL -> System.out.println("Заливаем дизельное топливо");
            default -> System.out.println("Заправляемся бензином");
        }
    }

    public void changeOwner(Owner newOwner) {
        if (newOwner.age() < 16) {
            throw new UnderageOwnerException("Возраст нового владельца слишком мал: " + newOwner.age());
        }
        this.owner = newOwner;
        System.out.println(this.owner.firstName() + " " + this.owner.lastName() +
                " - Новый владелец машины");
    }
}
