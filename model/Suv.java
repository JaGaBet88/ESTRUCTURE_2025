
package model;


public class Suv extends Vehicle {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Suv() {
    }
    
    public Suv(byte doors, byte numWheels, String license, Brand brand) {
        super(doors, numWheels, license, brand);
    }
}
