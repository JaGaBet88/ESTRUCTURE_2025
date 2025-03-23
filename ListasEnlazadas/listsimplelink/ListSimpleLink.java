package listsimplelink;

import java.util.Scanner;
import controller.List;

public class ListSimpleLink {

    static Scanner scan = new Scanner(System.in);

    static List objList = new List();

    public static void main(String[] args) {
        insertHead();
        insertAtEnd();
        insertAfter();
        insertBefore();
        iteratorTravel();
        triggerTravel();
        deleteLastNode();
        removeAnyNode();
        destroy();
    }

    private static void insertHead() {
        char opcInsert;

        System.out.println("Ingresando datos al Inicio de la Lista");

        do {
            System.out.println("Ingrese edad: ");
            int age = scan.nextInt();

            try {
                if (objList.insertList(age)) {
                    System.out.println("Edad ingresada correctamente....");
                    iteratorTravel();
                } else {
                    System.out.println("Error al ingresar la edad, intentelo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do {
                System.out.println("\nDesea ingresar una edad S para Si o N para No: ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');
        } while (opcInsert == 'S');
    }

    private static void iteratorTravel() {
        System.out.println("\nMostrar el contenido de la lista");
        try {
            byte count = 1;
            boolean first = true;
            int data = objList.iteratorTravel(first);
            while (data != 0) {
                System.out.println("El dato del " + count + " es : " + data);
                count++;
                first = false;
                data = objList.iteratorTravel(first);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void triggerTravel() {
        System.out.println("\nMostrando Datos de Forma Recursiva");
        boolean first = true;
        try {
            byte count = 1;
            int data = objList.iteratorTravel(first);
            recursiveTravel(data, count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void recursiveTravel(int data, byte count) {
        if (data != 0) {
            System.out.println("El dato del nodo " + count + " es : " + data);
            count++;

            try {
                recursiveTravel(objList.iteratorTravel(false), count);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void destroy() {
        System.out.println("\nDestruyendo la lista");
        if (objList.destroy()) {
            System.out.println("La lista fue destruida!...");
            iteratorTravel();
        } else {
            System.out.println("La lista esta vacia!...");
        }
    }

    private static void insertAtEnd() {

        System.out.println("\nIngresar edad al final de la lista");

        int newAge;

        do {
            do {
                System.out.println("\nIngrese una edad: ");
                newAge = scan.nextInt();
            } while (newAge < 0 && newAge > 120);

            try {
                if (objList.insertAtEnd(newAge)) {
                    System.out.println("Edad ingresada correctamente al final...");
                    iteratorTravel();
                } else {
                    System.out.println("Error al ingresar el número, intentelo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do {
                System.out.println("\n¿Desea ingresar otro número? (S/N): ");
                newAge = scan.next().toUpperCase().charAt(0);
            } while (newAge != 'S' && newAge != 'N');
        } while (newAge == 'S');
    }

    public static void deleteLastNode() {
        System.out.println("Eliminando el último nodo de la lista");
        try {
            if (objList.deleteLastNode()) {
                System.out.println("El último nodo fue eliminado correctamente...");
                iteratorTravel();
            } else {
                System.out.println("La lista esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeAnyNode() {
        System.out.println("\nIngrese la edad que desea eliminar: ");
        int edad = scan.nextInt();

        try {
            if (objList.removeAnyNode(edad)) {
                System.out.println("El nodo fue eliminado correctamente.");
                iteratorTravel();
            } else {
                System.out.println("El valor no se encontró en la lista.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertAfter() {
        char opcInsert;
        do {
            System.out.println("\nIngrese el valor después del cual quiere insertar: ");
            int target = scan.nextInt();

            System.out.println("Ingrese la edad a insertar: ");
            int newAge = scan.nextInt();

            try {
                if (objList.insertAfter(target, newAge)) {
                    System.out.println("Nodo insertado correctamente después de: " + target);
                    iteratorTravel(); // Muestra la lista
                } else {
                    System.out.println("No se encontró el nodo con el valor: " + target);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.println("\n¿Desea realizar un nuevo intento? (S/N): ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');

        } while (opcInsert == 'S');
    }

    public static void insertBefore() {
        char opcInsert;
        do {
            System.out.println("Ingrese el valor antes del cual quiere insertar:");
            int target = scan.nextInt();

            System.out.println("\nIngrese la edad a insertar: ");
            int newValue = scan.nextInt();

            try {
                if (objList.insertBefore(target, newValue)) {
                    System.out.println("Nodo insertado correctamente antes de " + target);
                    iteratorTravel();
                } else {
                    System.out.println("No se encontró el nodo con el valor " + target);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            do {
                System.out.println("\n¿Desea realizar un nuevo intento? (S/N): ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');

        } while (opcInsert == 'S');
    }
}
