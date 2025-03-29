package doublylinkedlists;

import java.util.Scanner;
import controller.DoubleList;

public class DoublyLinkedLists {

    private static Scanner scan = new Scanner(System.in);

    private static DoubleList objDoubleList = new DoubleList();

    public static void main(String[] args) {
        byte opc;

        do {
            System.out.println("\n==>> MENU <<==");
            System.out.println("1. Insertar a la cabeza");
            System.out.println("2. Mostrar el contenido de las edades");
            System.out.println("3. Mostrar el contenido de forma recursiva");
            System.out.println("4. Destruir la lista doblemente ligada");
            System.out.println("5. Para Salir");

            do {
                System.out.println("\nIngrese la opcion: ");
                opc = scan.nextByte();
            } while (opc > 5);

            switch (opc) {
                case 1: {
                    headInsert();
                    break;
                }
                case 2: {
                    iteratorTravel();
                    break;
                }
                case 3: {
                    triggerTravel();
                    break;
                }
                case 4: {
                    destroy();
                    break;
                }                
                default: {
                    break;
                }
            }

        } while (opc != 5);
    }

    private static void headInsert() {
        char sw;
        int age;
        System.out.println("\n");

        do {
            System.out.println("Ingrese una edad: ");
            age = scan.nextInt();

            try {
                if (objDoubleList.headInsert(age)) {
                    System.out.println("Edad ingresada correctamente! ...");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.println("Desea ingresar otra edad S para Si o N para No :");
                sw = scan.next().toUpperCase().charAt(0);
            } while (sw != 'S' && sw != 'N');

        } while (sw == 'S');
    }

    private static void iteratorTravel() {
        System.out.println("\nMostrar el contenido de la lista");
        try {
            byte count = 1;
            boolean first = true;
            int data = objDoubleList.iteratorTravel(first);
            while (data != 0) {
                System.out.println("La edad " + count + " es : " + data);
                count++;
                first = false;
                data = objDoubleList.iteratorTravel(first);
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
            int data = objDoubleList.iteratorTravel(first);
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
                recursiveTravel(objDoubleList.iteratorTravel(false), count);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void destroy() {
        try{
            if ( objDoubleList.destroy() ) {
                System.out.println("La lista doblemente ligada ha sido destruida!...");
            } else {
                System.out.println("La lista doblemente ligada esta vacia!...");
            }
            
        }catch( Exception e ){ System.out.println(e.getMessage()); }
    }

}
