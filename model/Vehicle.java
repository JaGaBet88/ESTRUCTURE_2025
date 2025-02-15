package model;

abstract class Vehicle {

    protected byte doors;
    protected byte numWheels;

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

    public Vehicle(byte doors, byte wheels) {
        this.doors = doors;
        this.numWheels = wheels;
    }
    
    abstract boolean register();
    abstract boolean update();
}
