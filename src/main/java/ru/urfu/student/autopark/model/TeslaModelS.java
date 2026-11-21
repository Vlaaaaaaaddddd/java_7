package ru.urfu.student.autopark.model;

public class TeslaModelS extends Cars{
    private int charge;

    public TeslaModelS(DriveType drive, FuelType fuel, double acceleration, int max_speed,
                       Owner owner, int charge){
        super(drive, fuel, acceleration, max_speed, owner);
        if (charge < 0) {
            throw new IllegalArgumentException("Заряд не может быть отрицательным");
        }
        this.charge = charge;
    }

    @Override
    public void startEngine() {
        if (charge <= 0) {
            throw new IllegalStateException("Невозможно завести машину: батарея разряжена!");
        }
        System.out.println("Движок запущен. пи-пи-пи");
    }
}
