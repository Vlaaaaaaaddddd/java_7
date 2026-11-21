package ru.urfu.student.autopark.exception;

public class GarageFullException extends Exception {
    public GarageFullException(String message) {
        super(message);
    }
}