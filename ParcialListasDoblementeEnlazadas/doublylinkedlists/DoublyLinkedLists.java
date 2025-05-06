package doublylinkedlists;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.DoubleList;

public class DoublyLinkedLists {

    private static Scanner scan = new Scanner(System.in);
    private static DoubleList integerList = new DoubleList();

    public static void main(String[] args) {
        populateIntegerList();
        searchDataInList();
        duplicateOrTriplicate();
    }

    private static void populateIntegerList() {
        char addMore;
        System.out.println("\n--- Población de la Lista de Enteros ---");
        do {
            try {
                System.out.print("Ingrese un número entero: ");
                int number = scan.nextInt();
                integerList.headInsert(number);
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número entero.");
                scan.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("¿Desea ingresar otro número? (S/N): ");
            addMore = scan.next().toUpperCase().charAt(0);
        } while (addMore == 'S');
    }

    private static void searchDataInList() {
        if (integerList.getFirstValue() == null) {
            System.out.println("\nLa lista está vacía. No se puede buscar.");
            return;
        }

        System.out.println("\n--- Búsqueda de Datos en la Lista ---");
        try {
            System.out.print("Ingrese el dato que desea buscar: ");
            int searchData = scan.nextInt();
            int occurrences = integerList.countOccurrences(searchData);

            if (occurrences > 0) {
                System.out.println("El dato " + searchData + " se encuentra " + occurrences + " veces en la lista.");
            } else {
                System.out.println("El dato " + searchData + " no se encontró en la lista.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número entero para buscar.");
            scan.next(); // Limpiar el buffer
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Punto 2 se implementará en el siguiente bloque
    private static void duplicateOrTriplicate() {
        System.out.println("\n--- Duplicando o Triplicando Datos ---");
        DoubleList newList = new DoubleList();
        integerList.resetIterator();
        Integer currentValue;

        try {
            while ((currentValue = integerList.getNextValue()) != null) {
                if (currentValue % 2 == 0) {
                    newList.headInsert(currentValue);
                    newList.headInsert(currentValue);
                } else {
                    newList.headInsert(currentValue);
                    newList.headInsert(currentValue);
                    newList.headInsert(currentValue);
                }
            }

            System.out.println("Nueva lista creada con los datos duplicados o triplicados:");
            newList.resetIterator();
            Integer newValue;
            while ((newValue = newList.getNextValue()) != null) {
                System.out.print(newValue + " ");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error al duplicar o triplicar los datos: " + e.getMessage());
        }
    }
}
