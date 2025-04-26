package model;

public class Employee {
    private double ordinaryHourValue;
    private int extraHourType;

    public Employee(double ordinaryHourValue, int extraHourType) {
        this.ordinaryHourValue = ordinaryHourValue;
        this.extraHourType = extraHourType;
    }

    public double getOrdinaryHourValue() {
        return ordinaryHourValue;
    }

    public int getExtraHourType() {
        return extraHourType;
    }
}