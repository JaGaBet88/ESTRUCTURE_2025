package Clase_07_02_2025;
import java.util.Scanner;
import model.Sedan;

public class Clase_07_02_2025 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        register();

    }

    private static void register() {
        System.out.println("Ingresar tipo de auto 1 para Sedan o 2 para Suv");
        byte kindCar = scan.nextByte();

        System.out.println("\n Ingrese el numero de puertas: ");
        byte doors = scan.nextByte();

        System.out.println("Ingrese el numero de ruedas: ");
        byte wheels = scan.nextByte();

        boolean convert;
        byte weight;

        if (kindCar == 1) {
            System.out.println("Ingrese S si es convertible o N de otra forma: ");
            char swConvertible = scan.next().toUpperCase().charAt(0);

            convert = swConvertible == 'S'; // Operador ternario
            
//            Vehicle objVehicle = new Vehicle();
//            objVehicle.setdoors(doors);
//            objVehicle.setNumWheels(wheels);

            Sedan objSedan = new Sedan(doors, wheels, swConvertible);

            System.out.println("\nLos datos recuperados son: ");
            System.out.println("Nro. puertas: " + objSedan.getdoors());
            System.out.println("Nro. ruedad: " + objSedan.getNumWheels());

        } else {
            System.out.println("Ingrese la capacidad de carga: ");
            weight = scan.nextByte();
        }
    }
}
