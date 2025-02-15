package model;

public class Sedan extends Vehicle {
    
    private char swConvertible;

    public Sedan(byte doors, byte wheels, char swConvertible) {
        super(doors, wheels);
        this.swConvertible = swConvertible;
    }

    @Override
    boolean register() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}