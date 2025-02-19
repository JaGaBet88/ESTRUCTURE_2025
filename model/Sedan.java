package model;

public class Sedan extends Vehicle {
    
    private boolean convertible;

    public Sedan(boolean convertible, byte doors, byte wheels, char swConvertible, String license) {
        super(doors, wheels, license);
        this.convertible = convertible;
    }    
}