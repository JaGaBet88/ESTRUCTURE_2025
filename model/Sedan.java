package model;

public class Sedan extends Vehicle {
    
    private boolean convertible;

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public Sedan(boolean convertible, byte doors, byte wheels, String license) {
        super(doors, wheels, license);
        this.convertible = convertible;
    }

}