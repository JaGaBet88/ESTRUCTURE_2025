
package controller;

import model.Sedan;

abstract class VehicleController {
    abstract boolean register(Sedan objSedan) throws Exception;
    abstract String search(String license) throws Exception;

}


