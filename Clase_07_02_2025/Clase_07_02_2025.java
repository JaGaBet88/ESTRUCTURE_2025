package Clase_07_02_2025;

import java.util.Scanner;
import model.Sedan;
import controller.SedanController;

public class Clase_07_02_2025 {

    static Scanner scan = new Scanner(System.in);
    static SedanController objSedanController = new SedanController();

    public static void main(String[] args) {
        register();
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

            byte weight;

            if (kindCar == 1) {
                registerSedan(doors, wheels, license);
            } else {
                System.out.println("Ingrese la capacidad de carga: ");
                weight = scan.nextByte();
            }

            do {
                System.out.println("Desea registrar otro vehiculo? S/N");
                swOtherVehicle = scan.next().toUpperCase().charAt(0);
            } while (swOtherVehicle != 'S' && swOtherVehicle != 'N');

        } while (swOtherVehicle == 'S');
    }

    private static void registerSedan(byte doors, byte wheels, String license) {
        char swConvertible;
        do {
            System.out.println("Ingrese S si es convertible o N de otra forma: ");
            swConvertible = scan.next().toUpperCase().charAt(0);
        } while (swConvertible != 'S' && swConvertible != 'N');

        boolean convert = swConvertible == 'S'; // Operador ternario

        Sedan objSedan = new Sedan(convert, doors, wheels, license);

        try {
            if (objSedanController.register(objSedan)) {
                System.out.println("El Sedan fue registrado!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
