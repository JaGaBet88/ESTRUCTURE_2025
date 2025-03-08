//Definir paquetes
package models;

//Clase abstracta Contract
public abstract class Contract {
    protected String numContract;
    protected String date;

    public Contract(String numContract, String date) {
        this.numContract = numContract;
        this.date = date;
    }

    public abstract boolean register();
    public abstract boolean search();
}