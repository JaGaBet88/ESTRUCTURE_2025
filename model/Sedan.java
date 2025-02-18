package model;

public class Sedan extends Vehicle {
    
    private char convertible;

    public Sedan(boolean convertible, byte doors, byte wheels, char swConvertible) {
        super(doors, wheels, license);
        this.convertible = convertible;
    }    
}