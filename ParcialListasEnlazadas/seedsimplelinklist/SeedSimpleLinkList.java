package seedsimplelinklist;

import java.util.Scanner;
import controller.SimpleList;

public class SeedSimpleLinkList {

    static Scanner scan = new Scanner(System.in);
    static SimpleList objSimpleList = new SimpleList();

    public static void main(String[] args) {
        insertHead();      // Insertar notas
        objSimpleList.showList();  // Mostrar la lista de notas
        showAverage();     // Mostrar el promedio de las notas
    }

    // Método para ingresar las notas
    private static void insertHead() {
        try {
            System.out.print("Ingrese la cantidad de notas a ingresar: ");
            int n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese la nota " + (i + 1) + ": ");
                double nota = scan.nextDouble();
                objSimpleList.insertList(nota);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para mostrar el promedio
    private static void showAverage() {
        try {
            double promedio = objSimpleList.showAverage();
            System.out.println("\nEl promedio de las notas es: " + promedio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
