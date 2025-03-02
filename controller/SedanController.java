package controller;

import model.Sedan;
import java.util.ArrayList;
import model.Suv;

public class SedanController extends VehicleController {

    ArrayList<Sedan> objSedans = new ArrayList<Sedan>();

    @Override
    public boolean register(Sedan objSedan, Suv objSuv) throws Exception {
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
            for (int i = 0; i < this.objSedans.size(); i++) {
                if (this.objSedans.get(i).getLicense().equals(license)) {
                    strSedan += this.objSedans.get(i).getLicense() + " - "
                            + this.objSedans.get(i).getDoors() + " - "
                            + this.objSedans.get(i).getNumWheels() + " - ";

                    strSedan += this.objSedans.get(i).getConvertible() ? "Convertible" : "Convencional";
                }
                break;
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar un Sedan!...");
        }

        return strSedan;
    }

    @Override
    public boolean update(String license, Sedan objSedan, Suv objSuv) throws Exception {
        try {
            for (Sedan sedan : objSedans) {
                if (sedan.getLicense().equals(license)) {
                    sedan.setLicense(objSedan.getLicense());
                    sedan.setDoors(objSedan.getDoors());
                    sedan.setNumWheels(objSedan.getNumWheels());
                    sedan.setBrand(objSedan.getBrand());
                    sedan.setConvertible(objSedan.getConvertible());
                }
                break;
            }
        } catch (Exception e) {
            throw new Exception("Error al actulizar un Sedan!...");
        }
        return true;
    }

    @Override
    public boolean remove(String license) throws Exception {
        boolean result = false;

        try {
            for (Sedan sedan : objSedans) {
                if (sedan.getLicense().equals(license)) {
                    objSedans.remove(sedan);
                    result = true;
                }
                break;
            }
        } catch (Exception e) {
            throw new Exception("Error al remover un Sedan!...");
        }
        return result;
    }

    @Override
    public String list() throws Exception {
        String strSedan = "";

        try {
            for (int i = 0; i < this.objSedans.size(); i++) {
                strSedan += this.objSedans.get(i).getLicense() + " - "
                        + this.objSedans.get(i).getDoors() + " - "
                        + this.objSedans.get(i).getNumWheels() + " - "
                        + this.objSedans.get(i).getBrand() + " - ";

                strSedan += this.objSedans.get(i).getConvertible() ? "Convertible\n" : "Convencional\n";
            }
        } catch (Exception e) {
            throw new Exception("Error al listar un Sedan!...");
        }

        return strSedan;
    }

}