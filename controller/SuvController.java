
package controller;

import java.util.ArrayList;

import model.Sedan;
import model.Suv;

public class SuvController extends VehicleController {

    ArrayList<Suv> objSuvs = new ArrayList<Suv>();

    @Override
    public boolean register(Sedan objSedan, Suv objSuv) throws Exception {
        try {
            objSuvs.add(objSuv);
        } catch (Exception e) {
            throw new Exception("Error al registrar un Suv!...");
        }
        return true;
    }

    @Override
    public String search(String license) throws Exception {
        String strSuv = "";

        try {
            for (int i = 0; i < this.objSuvs.size(); i++) {
                if (this.objSuvs.get(i).getLicense().equals(license)) {
                    strSuv += this.objSuvs.get(i).getLicense() + " - "
                            + this.objSuvs.get(i).getDoors() + " - "
                            + this.objSuvs.get(i).getNumWheels() + " - ";
                    strSuv += this.objSuvs.get(i).getWeight() + " - ";
                }
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar un Suv!...");
        }

        return strSuv;
    }

    @Override
    public boolean update(String license, Sedan objSedan, Suv objSuv) throws Exception {
        try {
            for (Suv suv : objSuvs) {
                if (suv.getLicense().equals(license)) {
                    suv.setLicense(objSuv.getLicense());
                    suv.setDoors(objSuv.getDoors());
                    suv.setNumWheels(objSuv.getNumWheels());
                    suv.setBrand(objSuv.getBrand());
                    suv.setWeight(objSuv.getWeight());
                }
                break;
            }
        } catch (Exception e) {
            throw new Exception("Error al actulizar un Suv!...");
        }
        return true;
    }

    @Override
    public boolean remove(String license) throws Exception {
        boolean result = false;

        try {
            for (Suv suv : objSuvs) {
                if (suv.getLicense().equals(license)) {
                    objSuvs.remove(suv);
                    result = true;
                }
                break;
            }
        } catch (Exception e) {
            throw new Exception("Error al remover un Suv!...");
        }
        return result;
    }

    @Override
    public String list() throws Exception {
        String strSuv = "";

        try {
            for (int i = 0; i < this.objSuvs.size(); i++) {
                strSuv += this.objSuvs.get(i).getLicense() + " - "
                        + this.objSuvs.get(i).getDoors() + " - "
                        + this.objSuvs.get(i).getNumWheels() + " - "
                        + this.objSuvs.get(i).getBrand() + " - ";
                strSuv += this.objSuvs.get(i).getWeight() + " - ";

            }
        } catch (Exception e) {
            throw new Exception("Error al listar un Suv!...");
        }

        return strSuv;
    }

}
