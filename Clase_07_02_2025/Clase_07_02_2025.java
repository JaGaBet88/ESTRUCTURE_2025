package Clase_07_02_2025;

import java.util.Scanner;
import model.Sedan;
import model.Brand;
import model.Suv;
import controller.SedanController;
import controller.SuvController;

public class Clase_07_02_2025 {

    static Scanner scan = new Scanner(System.in);
    static SedanController objSedanController = new SedanController();
    static SuvController objSuvController = new SuvController();

    public static void main(String[] args) {
        register();
        search();
        remove();
        showAll();
    }

    private static void register() {
        byte kindCar;
        char swOtherVehicle;

        do {
            do {
                System.out.println("Ingresar tipo de auto 1 para Sedan o 2 para Suv");
                kindCar = scan.nextByte();
            } while (kindCar < 1 || kindCar > 2);

            byte doors;
            do {
                System.out.println("\nIngrese el numero de puertas: ");
                doors = scan.nextByte();
            } while (doors < 2 || doors > 5);

            byte wheels;
            do {
                System.out.println("Ingrese el numero de ruedas: ");
                wheels = scan.nextByte();
            } while (wheels != 4);

            System.out.println("Ingrese la placa del vehiculo: ");
            String license = scan.next();

            String name = "";
            do {
                System.out.println("Ingrese la marca del vehiculo: ");
                name = scan.next();
            } while (name.equals(""));

            Brand objBrand = new Brand(name);

            if (kindCar == 1) {
                registerSedan(doors, wheels, license, objBrand);
            } else {
                registerSuv(doors, wheels, license, objBrand);
            }

            do {
                System.out.println("Ingrese S para ingresar otro auto o N para No. ");
                swOtherVehicle = scan.next().toUpperCase().charAt(0);
            } while (swOtherVehicle != 'S' && swOtherVehicle != 'N');

        } while (swOtherVehicle == 'S');
    }

    private static void registerSedan(byte doors, byte wheels, String license, Brand objBrand) {
        char swConvertible;
        do {
            System.out.println("Ingrese S si es convertible o N de otra forma: ");
            swConvertible = scan.next().toUpperCase().charAt(0);
        } while (swConvertible != 'S' && swConvertible != 'N');

        boolean convert = swConvertible == 'S'; // Operador ternario

        Sedan objSedan = new Sedan(convert, doors, wheels, license, objBrand);

        try {
            Suv objSuv = new Suv();
            if (objSedanController.register(objSedan, objSuv)) {
                System.out.println("El Sedan fue registrado!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerSuv(byte doors, byte wheels, String license, Brand objBrand) {
        byte weight;
        do {
            System.out.println("Ingrese el peso del vehiculo: ");
            weight = scan.nextByte();
        } while (weight < 1 || weight > 5);

        Suv objSuv = new Suv(weight, doors, wheels, license, objBrand);

        try {
            Sedan objSedan = new Sedan();
            if (objSuvController.register(objSedan, objSuv)) {
                System.out.println("El Suv fue registrado!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void search() {
        System.out.println("\n---CONSULTAR VEHICULOS---");
        byte kindCar;

        do {
            System.out.println("\nIngresar tipo de auto 1 para Sedan o 2 para Suv");
            kindCar = scan.nextByte();
        } while (kindCar < 1 || kindCar > 2);

        System.out.println("Ingrese la placa del vehiculo: ");
        String license = scan.next();

        if (kindCar == 1) {
            try {
                String result = objSedanController.search(license);

                if (result != "") {
                    System.out.println(result);
                    updateSedan(license);
                } else {
                    System.out.println("No se encontro Sedan con esa placa!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            try {
                String result = objSuvController.search(license);

                if (result != "") {
                    System.out.println(result);
                    updateSuv(license);
                } else {
                    System.out.println("No se encontro Suv con esa placa!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }    

    private static void updateSedan(String license) {
        System.out.println("\nActualizar Sedan");
        char swUpdate;	
        do {
            System.out.println("Ingrese S Si desea Actualizar o N si No lo desea.");
            swUpdate = scan.next().toUpperCase().charAt(0);
        } while (swUpdate != 'S' && swUpdate != 'N');

        if (swUpdate == 'S') {
            byte doors;
            do {
                System.out.println("\nIngrese el numero de puertas: ");
                doors = scan.nextByte();
            } while (doors < 2 || doors > 5);

            byte wheels;
            do {
                System.out.println("Ingrese el numero de ruedas: ");
                wheels = scan.nextByte();
            } while (wheels != 4);

            System.out.println("Ingrese la placa del vehiculo: ");
            String strlicense = scan.next();

            String name = "";
            do {
                System.out.println("Ingrese la marca del vehiculo: ");
                name = scan.next();
            } while (name == "");

            Brand objBrand = new Brand(name);

            char swConvertible;
            do {
                System.out.println("Ingrese S si es convertible o N de otra forma: ");
                swConvertible = scan.next().toUpperCase().charAt(0);
            } while (swConvertible != 'S' && swConvertible != 'N');

            boolean convert = swConvertible == 'S'; // Operador ternario

            Sedan objSedan = new Sedan(convert, doors, wheels, strlicense, objBrand);

            try {
                Suv objSuv = new Suv();
                if (objSedanController.update(license, objSedan, objSuv)) {
                    System.out.println("Sedan Actualizado correctamente!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void updateSuv(String license) {
        System.out.println("\nActualizar Suv");
        char swUpdate;	
        do {
            System.out.println("Ingrese S Si desea Actualizar o N si No lo desea.");
            swUpdate = scan.next().toUpperCase().charAt(0);
        } while (swUpdate != 'S' && swUpdate != 'N');

        if (swUpdate == 'S') {
            byte doors;
            do {
                System.out.println("\nIngrese el numero de puertas: ");
                doors = scan.nextByte();
            } while (doors < 2 || doors > 5);

            byte wheels;
            do {
                System.out.println("Ingrese el numero de ruedas: ");
                wheels = scan.nextByte();
            } while (wheels != 4);

            System.out.println("Ingrese la placa del vehiculo: ");
            String strlicense = scan.next();

            String name = "";
            do {
                System.out.println("Ingrese la marca del vehiculo: ");
                name = scan.next();
            } while (name == "");

            Brand objBrand = new Brand(name);

            byte weight;
            do {
                System.out.println("Ingrese el peso del vehiculo: ");
                weight = scan.nextByte();
            } while (weight < 1 || weight > 5);

            Suv objSuv = new Suv(weight, doors, wheels, strlicense, objBrand);

            try {
                Sedan objSedan = new Sedan();
                if (objSuvController.update(license, objSedan, objSuv)) {
                    System.out.println("Suv Actualizado correctamente!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void remove() {
        System.out.println("\nRemover vehiculos");
        byte kindCar;

        do {
            System.out.println("\nIngresar tipo de auto 1 para Sedan o 2 para Suv");
            kindCar = scan.nextByte();
        } while (kindCar < 1 || kindCar > 2);

        System.out.println("Ingrese la placa del vehiculo: ");
        String license = scan.next();

        if (kindCar == 1) {
            try {
                if (objSedanController.remove(license)) {
                    System.out.println("\nEl vehiculo fue removido de la lista!...");
                } else {
                    System.out.println("\nEl numero de la placa no es valido. Verifique!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                if (objSuvController.remove(license)) {
                    System.out.println("\nEl vehiculo fue removido de la lista!...");
                } else {
                    System.out.println("\nEl numero de la placa no es valido. Verifique!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    private static void showAll() {
        System.out.println("\nListar vehiculos");
        byte kindCar;

        do {
            System.out.println("\nIngresar tipo de auto 1 para Sedan o 2 para Suv");
            kindCar = scan.nextByte();
        } while (kindCar < 1 || kindCar > 2);

        if (kindCar == 1) {
            try {
                String result = objSedanController.list();

                if (result != "") {
                    System.out.println(result);
                } else {
                    System.out.println("No hay sedans registrados!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            try {
                String result = objSuvController.list();

                if (result != "") {
                    System.out.println(result);
                } else {
                    System.out.println("No hay suv registrados!...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
