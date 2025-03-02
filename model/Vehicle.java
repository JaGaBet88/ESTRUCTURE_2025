package model;

abstract class Vehicle {

    protected byte doors;
    protected byte numWheels;
    protected String license;
    protected Brand brand;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Vehicle() {
    }

    public Vehicle(byte doors, byte numWheels, String license, Brand brand) {
        this.doors = doors;
        this.numWheels = numWheels;
        this.license = license;
        this.brand = brand;
    }
}
