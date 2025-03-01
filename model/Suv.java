
package model;


public class Suv extends Vehicle {

    private byte weight;

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public Suv() {
    }
    
    public Suv(byte weight, byte doors, byte numWheels, String license, Brand brand) {
        super(doors, numWheels, license, brand);
        this.weight = weight;
    }
}
