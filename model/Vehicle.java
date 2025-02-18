package model;

abstract class Vehicle {

    protected byte doors; //Puertas
    protected byte numWheels; //Número de llantas
    protected String license; //Placa

    public byte getdoors() {
        return doors;
    }

    public void setdoors(byte doors) {
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

    public Vehicle(byte doors, byte wheels, String license) {
        this.doors = doors;
        this.numWheels = wheels;
        this.license = license;
    }
    
    abstract boolean register();
    abstract boolean update();
}
