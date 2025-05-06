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
        transformAndCreateNewList();
        showHighestValue(); // Nuevo método para mostrar el valor más alto
    }

    private static void populateIntegerList() {
        char addMore;
        System.out.println("--- Ingreso de Precios de Artículos ---");
        do {
            try {
                System.out.print("Ingrese el precio del artículo: ");
                int number = scan.nextInt();
                integerList.headInsert(number);
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número entero.");
                scan.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("¿Desea ingresar otro precio? (S/N): ");
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
            System.out.print("Ingrese el precio que desea buscar: ");
            int searchData = scan.nextInt();
            int occurrences = integerList.countOccurrences(searchData);

            if (occurrences > 0) {
                System.out.println("El precio $" + searchData + " se encuentra " + occurrences + " veces en la lista.");
            } else {
                System.out.println("El precio $" + searchData + " no se encontró en la lista.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número entero para buscar.");
            scan.next(); // Limpiar el buffer
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void transformAndCreateNewList() {
        System.out.println("\n--- Transformación de Precios ---");
        DoubleList newList = new DoubleList();
        integerList.resetIterator();
        Integer currentValue;

        try {
            while ((currentValue = integerList.getNextValue()) != null) {
                int newValue;
                if (currentValue % 2 == 0) {
                    newValue = currentValue * 2;
                } else {
                    newValue = currentValue * 3;
                }
                newList.headInsert(newValue);
            }

            System.out.println("Nueva lista con los precios transformados:");
            newList.resetIterator();
            Integer transformedValue;
            while ((transformedValue = newList.getNextValue()) != null) {
                System.out.print(transformedValue + " ");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error al transformar los precios: " + e.getMessage());
        }
    }

    private static void showHighestValue() {
        System.out.println("\n--- Valor del Artículo con el Precio de Venta Más Alto ---");
        try {
            Integer highestPrice = integerList.findHighestValue();
            if (highestPrice != null) {
                System.out.println("El precio de venta más alto es: " + highestPrice);
            } else {
                System.out.println("No se ingresaron precios de artículos.");
            }
        } catch (Exception e) {
            System.out.println("Error al encontrar el precio más alto: " + e.getMessage());
        }
    }
}
