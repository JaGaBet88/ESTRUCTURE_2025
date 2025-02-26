package model;

public class Sedan extends Vehicle {
    
    private boolean convertible;

    public boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public Sedan(boolean convertible, byte doors, byte numWheels, String license, Brand brand) {
        super(doors, numWheels, license, brand);
        this.convertible = convertible;
    }
}