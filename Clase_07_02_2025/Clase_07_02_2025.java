package Clase_07_02_2025;

import java.util.Scanner;
import model.Sedan;
import model.Brand;
import controller.SedanController;

public class Clase_07_02_2025 {

    static Scanner scan = new Scanner(System.in);
    static SedanController objSedanController = new SedanController();

    public static void main(String[] args) {
        register();
        searhc();
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
            } while (kindCar != 1 && kindCar != 2);

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
            } while (name == "");

            Brand objBrand = new Brand(name);

            boolean convert;
            byte weight;

            if (kindCar == 1) {
                registerSedan(doors, wheels, license, objBrand);
            } else {
                // Aca va el llamdo a metodo que registra un suv...
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
            if (objSedanController.register(objSedan)) {
                System.out.println("El Sedan fue registrado!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searhc() {
        System.out.println("\nConsultar vehiculos");
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
            // por aca se hace el search del suv.... y se hace el llamado al update del suv.
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
                if (objSedanController.upate(license, objSedan)) {
                    System.out.println("Sedan Actualizado correctamente!...");
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
            // Aca va la logica del suv....
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
            // por aca se hace el search del suv....
        }

    }
}

