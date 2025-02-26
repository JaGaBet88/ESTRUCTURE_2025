
package controller;

import model.Sedan;

abstract class VehicleController {
    abstract boolean register(Sedan objSedan) throws Exception;
    abstract String search(String license) throws Exception;
    abstract boolean upate(String license, Sedan objSedan) throws Exception;
    abstract boolean remove (String license) throws Exception;
    abstract String list() throws Exception;
}


