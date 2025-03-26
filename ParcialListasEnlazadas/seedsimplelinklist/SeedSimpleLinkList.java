package seedsimplelinklist;

import java.util.Scanner;
import controller.SimpleList;

public class SeedSimpleLinkList {

    static Scanner scan = new Scanner(System.in);
    static SimpleList objSimpleList = new SimpleList();

    // Nombre estudiante: Jairo Alberto Gallego Betancur

    public static void main(String[] args) {
        insertHead();      // Insertar notas desde teclado
        insertVector();    // Insertar el vector de notas como complemento
        objSimpleList.showList();  // Mostrar la lista completa
        showAverage();     // Mostrar el promedio de las notas
    }

    // Método para ingresar las notas por teclado
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

    // Método que crea un vector de notas y las agrega al final de la lista
    private static void insertVector() {
        try {
            double[] vectorNotas = {4.5, 3.8}; // Aquí puedes modificar las notas si quieres
            System.out.println("\nInsertando las notas del vector...");
            for (int i = 0; i < vectorNotas.length; i++) {
                objSimpleList.insertEnd(vectorNotas[i]);
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


