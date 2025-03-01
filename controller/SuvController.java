
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean upate(String license, Sedan objSedan, Suv objSuv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(String license) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
