package model;

import java.util.Objects;
import java.io.Serializable;

public abstract class Motor implements Serializable {

    //Declaración de variables comunes a todos los tipos de motores
    private String numeroMotor;
    private int caballosFuerza;
    private double cilindraje;

    //Método constructor
    public Motor(String numeroMotor, int caballosFuerza, double cilindraje){
        this.numeroMotor = numeroMotor;
        this.caballosFuerza = caballosFuerza;
        this.cilindraje = cilindraje;
    }

    //Getters
    public String getNumeroMotor(){
        return numeroMotor;
    }

    public int getCaballosFuerza(){
        return caballosFuerza;
    }

    public double getCilindraje(){
        return cilindraje;
    }

    //Setters
    public void setNumeroMotor(String numeroMotor){
        this.numeroMotor = numeroMotor;
    }

    public void setCaballosFuerza(int caballosFuerza){
        this.caballosFuerza = caballosFuerza;
    }

    public void setCilindraje(double cilindraje){
        this.cilindraje = cilindraje;
    }

    //Método abstracto para obtener información de cada tipo de motor
    public abstract String getInfo();

    @Override
    public String toString(){
        return "Número de motor: " + numeroMotor +
        ", Caballos de fuerza: " + caballosFuerza + 
        ", Cilindraje: " + cilindraje;
    }

    //Métodos equals y hashCode para comparar objetos Motor
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return Objects.equals(numeroMotor, motor.numeroMotor);
    }

    @Override
    public int hashCode(){
        return Objects.hash(numeroMotor);
    }

}