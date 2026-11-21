package ru.urfu.student.autopark.model;

public enum DriveType {
    FRONT_WHEEL("Передний привод"),
    BACK_WHEEL("Задний привод"),
    ALL_WHEEL("Полный привод");

    private final String title;

    DriveType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
