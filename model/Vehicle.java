package model;

abstract class Vehicle {

    protected byte doors;
    protected byte numWheels;
    protected String license;

    public byte getDoors() {
        return doors;
    }

    public void setDoors(byte doors) {
        this.doors = doors;
    }

    public byte getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(byte numWheels) {
        this.numWheels = numWheels;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }    

    public Vehicle(byte doors, byte numWheels, String license) {
        this.doors = doors;
        this.numWheels = numWheels;
        this.license = license;
    }
}
