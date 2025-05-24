package model;

public class MotorGasolina extends Motor {
    private double consumoCombustible; //L/100km o mpg
    private String tipoGasolina; //Ej. Regular, extra, diesel, etc...

    public MotorGasolina(String numeroMotor, int caballosFuerza, double cilindraje, double consumoCombustible, String tipoGasolina){
        super(numeroMotor,caballosFuerza,cilindraje);
        this.consumoCombustible = consumoCombustible;
        this.tipoGasolina = tipoGasolina;
    }

    //Getters y Setters específicos
    public double getConsumoCombustible(){
        return consumoCombustible;
    }

    public String getTipoGasolina(){
        return tipoGasolina;
    }

    public void setConsumoCombustible(double consumoCombustible){
        this.consumoCombustible = consumoCombustible;
    }

    public void setTipoGasolina(String tipoGasolina){
        this.tipoGasolina = tipoGasolina;
    }

    @Override
    public String getInfo(){
        return "Motor a gasolina - " + super.toString() + ", consumo: " + consumoCombustible + ", tipo de gasolina: " + tipoGasolina;
    }
}
