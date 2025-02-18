package Clase_07_02_2025;

import java.util.Scanner;
import model.Sedan;

public class Clase_07_02_2025 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        register();

    }

    private static void register() {
        byte kindCar;
        do {
            System.out.println("Ingresar tipo de auto 1 para Sedan o 2 para Suv");
            kindCar = scan.nextByte();
        } while (kindCar != 1 && kindCar != 2);

        byte doors;

        do {
            System.out.println("Ingresar el numero de puertas: ");
            doors = scan.nextByte();
        } while (doors < 2 || doors > 5);

        byte wheels;

        do {
            System.out.println("Ingresar el numero de ruedas: ");
            wheels = scan.nextByte();
        } while (wheels != 4);

  
        System.out.println("Ingresar la placa: ");
        String license = scan.next();

        boolean convert;
        byte weight;

        if (kindCar == 1) {
            char swConvertible;
            do {
                System.out.println("Ingrese S si es convertible o N de otra forma: ");
                swConvertible = scan.next().toUpperCase().charAt(0);
            } while (swConvertible != 'S' && swConvertible != 'N');

            convert = swConvertible == 'S'; // Operador ternario
            
//            Vehicle objVehicle = new Vehicle();
//            objVehicle.setdoors(doors);
//            objVehicle.setNumWheels(wheels);

            Sedan objSedan = new Sedan(convert, doors, wheels, license);

        } else {
            System.out.println("Ingrese la capacidad de carga: ");
            weight = scan.nextByte();
        }
    }
}
