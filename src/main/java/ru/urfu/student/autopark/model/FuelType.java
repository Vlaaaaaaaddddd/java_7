package ru.urfu.student.autopark.model;

public enum FuelType {
    PETROL_92("92 бензин"),
    PETROL_95("95 бензин"),
    PETROL_98("98 бензин"),
    PETROL_100("100 бензин"),
    ELECTRIC("Электричество"),
    DIESEL("Дизель");

    private final String title;

    FuelType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
