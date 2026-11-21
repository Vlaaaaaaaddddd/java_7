package ru.urfu.student.autopark.model;

public class LadaVesta extends Cars{
    private int mileage;

    public LadaVesta(DriveType drive, FuelType fuel, double acceleration, int max_speed,
                     Owner owner, int mileage){
        super(drive, fuel, acceleration, max_speed, owner);
        if (mileage < 0) {
            throw new IllegalArgumentException("Пробег не может быть отрицательным");
        }
        this.mileage = mileage;
    }

    public int getMileage(){
        return this.mileage;
    }


    @Override
    public void startEngine() {
        System.out.println("Движок запущен. Врум-врум");
    }
}
