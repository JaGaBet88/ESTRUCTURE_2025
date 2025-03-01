
package controller;

import model.Sedan;
import model.Suv;

abstract class VehicleController {
    abstract boolean register(Sedan objSedan, Suv objSuv) throws Exception;
    abstract String search(String license) throws Exception;
    abstract boolean upate(String license, Sedan objSedan, Suv objSuv) throws Exception;
    abstract boolean remove (String license) throws Exception;
    abstract String list() throws Exception;
}


