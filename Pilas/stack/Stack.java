package stack;

import controller.StackController;
import java.util.Scanner;

public class Stack {

    static Scanner scan = new Scanner(System.in);
    static StackController objStackController = new StackController();
    static StackController objStackBackup = new StackController();

    public static void main(String[] args) {
        byte opc;

        do {
            menu();

            do {
                System.out.println("Ingrese la opcion: ");
                opc = scan.nextByte();
            } while (opc > 5);

            switch (opc) {
                case 1: {
                    insertTop();
                    break;
                }
                case 2: {
                    removeTop();
                    break;
                }
                case 3: {
                    takeFirstTopData();
                    break;
                }
                case 4: {
                    quantiyOfNodes();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opc != 5);
    }

    private static void menu() {
        System.out.println("\nMenu de Pilas");
        System.out.println("1. Ingresar dato a la cima");
        System.out.println("2. Mostrar los datos de la pila");
        System.out.println("3. Mostrar el dato de la cima de la pila");
        System.out.println("4. Mostrar la cantidad de nodos de la pila");
        System.out.println("5. Salir");
    }

    private static void insertTop() {
        try {
            int data = 0;

            System.out.println("\nIngrese una edad: ");
            data = scan.nextInt();

            if (objStackController.insertTop(data)) {
                System.out.println("La edad se ingreso correctamente!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeTop() {
        System.out.println("\nMostrando el contenido de la pila");

        try {
            int data = objStackController.removeTop();
            int countData = 1;

            if (data != 0) {
                while (data != 0) {
                    System.out.println("El dato " + countData + " es: " + data);

                    objStackBackup.insertTop(data);
                    data = objStackController.removeTop();

                    countData++;
                }

                restoreBackup();

            } else {
                System.out.println("La pila esta vacia!...");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void restoreBackup() {
        try {
            int data = objStackBackup.removeTop();

            if (data != 0) {
                while (data != 0) {
                    objStackController.insertTop(data);
                    data = objStackBackup.removeTop();
                }
            } else {
                System.out.println("La pila esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void takeFirstTopData() {
        try {
            System.out.println("\nMostrando el dato de la cime de la pila: "
                    + objStackController.takeFirstTopData());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void quantiyOfNodes() {
        try {
            int data = objStackController.removeTop();
            int countNodos = 0;

            if (data != 0) {
                while (data != 0) {
                    objStackBackup.insertTop(data);
                    data = objStackController.removeTop();

                    countNodos++;
                }

                restoreBackup();
                
                System.out.println("\nLa cantidad de datos de la pila es: " + countNodos);

            } else {
                System.out.println("La pila esta vacia!...");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
