package rows;

import java.util.Scanner;
import controller.Row;

public class Rows {

    static Scanner scan = new Scanner(System.in);
    static Row objRow = new Row();
    static Row objRowBackup = new Row();

    public static void main(String[] args) {
        byte opc;

        do {
            menu();

            do {
                System.out.println("Ingrese la opcion: ");
                opc = scan.nextByte();
            } while (opc > 4);

            switch (opc) {
                case 1: {
                    insertLast();
                    break;
                }
                case 2: {
                    retireFirst();
                    break;
                }
                case 3: {
                    showRow();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opc != 4);
    }

    private static void menu() {
        System.out.println("\nMenu de Colas");
        System.out.println("1. Ingresar dato al final");
        System.out.println("2. Retirar el primer dato");
        System.out.println("3. Mostrar los datos de la cola");
        System.out.println("4. Salir");
    }

    private static void insertLast() {
        char opcInsert;

        System.out.println("\nIngresar un nuevo nodo al final de la lista");

        do {

            System.out.println("Ingrese edad: ");
            int value = scan.nextInt();

            try {
                if (objRow.insertLast(value)) {
                    System.out.println("El dato fue ingresado correctamente! ...");
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

    private static void retireFirst() {
        System.out.println("\nDescencolando");

        try {
            int data = objRow.retireFirst();
            if (data > 0) {
                System.out.println("La edad que retiro es: " + data);
            } else {
                System.out.println("La cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void showRow() {
        System.out.println("\nMostrando los datos de la cola");

        int data, countData = 1;
        try {
            data = objRow.retireFirst();
            if (data == 0) {
                System.out.println("La lista esta vacia!..");
            } else {
                while (data > 0) {
                    System.out.println("La " + countData + " edad es: " + data);

                    objRowBackup.insertLast(data);
                    countData++;
                    data = objRow.retireFirst();
                }
                retoreBackup();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void retoreBackup() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}