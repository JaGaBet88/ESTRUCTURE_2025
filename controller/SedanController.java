package controller;

import model.Sedan;
import java.util.ArrayList;

public class SedanController extends VehicleController {

    ArrayList<Sedan> objSedans = new ArrayList<Sedan>();

    @Override
    public boolean register(Sedan objSedan) throws Exception {
        try {
            objSedans.add(objSedan);
        } catch (Exception e) {
            throw new Exception("Error al registrar un Sedan!...");
        }
        return true;
    }

    @Override
    public String search(String license) throws Exception {
        String strSedan = "";

        try {
            for(int i = 0; i < this.objSedans.size(); i++){
                if(this.objSedans.get(i).getLicense().equals(license)){
                    strSedan += this.objSedans.get(i).getLicense() + " - "
                              + this.objSedans.get(i).getDoors() + " - "
                              + this.objSedans.get(i).getNumWheels() + " - ";
                    
                    strSedan += this.objSedans.get(i).getConvertible() ? "Convertible" : "Convencional";
                }
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar un Sedan!...");
        }

        return strSedan;
    }

}