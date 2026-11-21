package ru.urfu.student.autopark.model;

public record Owner(String firstName, String lastName, int age) implements Comparable<Owner>{
    public Owner {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }
    @Override
    public int compareTo(Owner other) {
        return Integer.compare(this.age, other.age);
    }
}