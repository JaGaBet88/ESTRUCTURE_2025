package model;

public class MotorElectrico extends Motor {
    private int voltaje; //Ej: 400V, 800V
    private double autonomia; //Ej: 300km, 8 horas

    public MotorElectrico (String numeroMotor, int caballosFuerza, double cilindraje, int voltaje, double autonomia){
        super(numeroMotor, caballosFuerza, cilindraje);
        this.voltaje = voltaje;
        this. autonomia = autonomia;
    }

    //Getters y Setters específicos
    public int getVoltaje(){
        return voltaje;
    }

    public double getAutonomia(){
        return autonomia;
    }

    public void setVoltaje(int voltaje){
        this.voltaje = voltaje;
    }

    public void setAutonomia(double autonomia){
        this.autonomia = autonomia;
    }

    @Override
    public String getInfo(){
        return "Motor eléctrico - " + super.toString() + ", voltaje: " + voltaje + ", autonomia: " + autonomia;
    }
}
