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
            } while (opc > 7);

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
                case 4: {
                    sumRow();
                    break;
                }
                case 5: {
                    getFirst();
                    break;
                }
                case 6: {
                    getLast();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opc != 7);
    }

    private static void menu() {
        System.out.println("\nMenu de Colas");
        System.out.println("1. Ingresar dato al final");
        System.out.println("2. Retirar el primer dato");
        System.out.println("3. Mostrar los datos de la cola");
        System.out.println("4. Mostrar la suma de los datos de la cola");
        System.out.println("5. Mostrar el dato del nodo a la cabeza");
        System.out.println("6. Mostrar el dato del nodo a la cola");
        System.out.println("7. Salir");
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
                restoreBackup();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sumRow() {
        System.out.println("\nMostrando la suma de los datos de la cola");

        int data, sumData = 0;
        try {
            data = objRow.retireFirst();
            if (data == 0) {
                System.out.println("La lista esta vacia!..");
            } else {
                while (data > 0) {
                    sumData += data;
                    objRowBackup.insertLast(data);
                    data = objRow.retireFirst();
                }
                System.out.println("La suma de los datos de la cola es: " + sumData);
                restoreBackup();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getFirst() {
        try {
            int data = objRow.getFirst();
            if (data > 0) {
                System.out.println("\nMostrando el primer dato de la cola " + data);
            } else {
                System.out.println("\nLa cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getLast() {
        try {
            int data = objRow.getLast();
            if (data > 0) {
                System.out.println("\nMostrando el ultimo dato de la cola " + data);
            } else {
                System.out.println("\nLa cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void restoreBackup() {
        int data;
        try {
            data = objRowBackup.retireFirst();
            if (data == 0) {
                System.out.println("La lista esta vacia!..");
            } else {
                while (data > 0) {
                    objRow.insertLast(data);
                    data = objRowBackup.retireFirst();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    } 

}
