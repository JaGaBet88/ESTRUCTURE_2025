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
            System.out.println("5. Eliminar el primer nodo de la lista");
            System.out.println("6. Eliminar el ulitmo nodo de la lista");
            System.out.println("7. Eliminar un nodo especifico de la lista");
            System.out.println("8. Insertar un nodo después de un valor");
            System.out.println("9. Insertar un nodo antes de un valor");
            System.out.println("10. Convertir lista a circular");
            System.out.println("11. Para Salir");

            do {
                System.out.println("\nIngrese la opcion: ");
                opc = scan.nextByte();
            } while (opc > 11);

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
                case 5: {
                    deleteFirst();
                    break;
                }
                case 6: {
                    deleteLast();
                    break;
                }
                case 7: {
                    deleteSpecifictNode();
                    break;
                }
                case 8: {
                    insertAfter();
                    break;
                }
                case 9: {
                    insertBefore();
                    break;
                }
                case 10: {
                    makeCircularList();
                    break;
                }
                default: {
                    break;
                }
            }

        } while (opc != 11);
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
                    iteratorTravel();
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

    /*private static void iteratorTravel() {
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
    }*/

    private static void iteratorTravel() {
        System.out.println("\nMostrar el contenido de la lista");
        try {
            objDoubleList.displayAll();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }    

    /*private static void triggerTravel() {
        System.out.println("\nMostrando Datos de Forma Recursiva");
        boolean first = true;
        try {
            byte count = 1;
            int data = objDoubleList.iteratorTravel(first);
            recursiveTravel(data, count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/

    private static void triggerTravel() {
        try {
            objDoubleList.recursiveDisplay();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }    

    /*private static void recursiveTravel(int data, byte count) {
        if (data != 0) {
            System.out.println("El dato del nodo " + count + " es : " + data);
            count++;

            try {
                recursiveTravel(objDoubleList.iteratorTravel(false), count);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }*/

    private static void destroy() {
        try {
            if (objDoubleList.destroy()) {
                System.out.println("La lista doblemente ligada ha sido destruida!...");
            } else {
                System.out.println("La lista doblemente ligada esta vacia!...");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteFirst() {
        try {
            if (objDoubleList.deleteFirst()) {
                System.out.println("Se eliminó el primer nodo de la lista!...");
                iteratorTravel();
            } else {
                System.out.println("La lista esta vacia!....");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteLast() {
        try {
            if (objDoubleList.deleteLast()) {
                System.out.println("Se eliminó el ultimo nodo de la lista!...");
                iteratorTravel();
            } else {
                System.out.println("La lista esta vacia!....");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteSpecifictNode() {
        System.out.println("\nEliminar un nodo especifico de la lista");

        System.out.println("\nIngrese un dato a eliminar de la lista: ");
        int value = scan.nextInt();

        try {
            int result = objDoubleList.deleteSpecifictNode(value);

            if (result == value) {
                System.out.println("\nEl dato se ha eliminado de la lista!...");
                iteratorTravel();
            } else if (result == 200) {
                System.out.println("\nEl dato no se encontro en la lista!...");
            } else {
                System.out.println("\nLa lista esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertAfter() {
        System.out.println("\nInsertar un nodo después de un valor específico");

        System.out.print("Ingrese el valor objetivo: ");
        int target = scan.nextInt();

        System.out.print("Ingrese el nuevo valor a insertar: ");
        int value = scan.nextInt();

        try {
            if (objDoubleList.insertAfter(target, value)) {
                System.out.println("El nodo se insertó correctamente!");
                iteratorTravel();
            } else {
                System.out.println("El valor objetivo no se encontró en la lista.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertBefore() {
        System.out.println("\nInsertar un nodo antes de un valor específico");

        System.out.print("Ingrese el valor objetivo: ");
        int target = scan.nextInt();

        System.out.print("Ingrese el nuevo valor a insertar: ");
        int value = scan.nextInt();

        try {
            if (objDoubleList.insertBefore(target, value)) {
                System.out.println("El nodo se insertó correctamente!");
                iteratorTravel();
            } else {
                System.out.println("El valor objetivo no se encontró en la lista.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void makeCircularList() {
        try {
            objDoubleList.makeCircular();
            iteratorTravel();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
