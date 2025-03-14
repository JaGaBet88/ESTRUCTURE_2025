package listsimplelink;

//Importamos las clases necesarias
import java.util.Scanner;
import controller.List;

//Clase ListSimpleLink
//Clase principal que contiene el metodo main
public class ListSimpleLink {

    // Atributo de tipo Scanner
    // Se inicializa en nulo
    static Scanner scan = new Scanner(System.in);

    // Atributo de tipo List
    // Se inicializa en nulo
    static List objList = new List();

    public static void main(String[] args) {
        insertHead();
        iteratorTravel();
        triggerTravel();
        insertAtEnd();
    }

    // Metodo para insertar datos al inicio de la lista
    // El metodo no recibe parametros
    private static void insertHead() {

        // Variable de tipo char
        // Se inicializa en nulo
        char opcInsert;

        // Mensaje en consola
        System.out.println("Ingresando datos al Inicio de la Lista");

        // Ciclo do-while
        // Se ejecuta al menos una vez
        do {
            // Mensaje en consola
            System.out.println("Ingrese edad: ");
            int age = scan.nextInt();

            // Bloque try-catch para manejar excepciones
            try {
                // Condicion para verificar si se logro insertar la edad
                // Se invoca el metodo insertList de la clase List
                if (objList.insertList(age)) {
                    System.out.println("Edad ingresada correctamente....");
                } else {
                    System.out.println("Error al ingresar la edad, intentelo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ciclo do-while
            // Se ejecuta al menos una vez
            do {
                // Mensaje en consola
                System.out.println("\nDesea ingresar una edad S para Si o N para No: ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');
        } while (opcInsert == 'S');
    }

    // Metodo para recorrer la lista de forma iterativa
    // El metodo no recibe parametros
    private static void iteratorTravel() {

        // Mensaje en consola
        System.out.println("\nMostrar el contenido de la lista");

        // Bloque try-catch para manejar excepciones
        try {

            // Variable de tipo byte
            // Se inicializa en 1
            byte count = 1;
            // Variable de tipo boolean
            // Se inicializa en verdadero
            boolean first = true;
            // Variable de tipo entero
            // Se inicializa en 0
            int data = objList.iteratorTravel(first);

            // Ciclo while
            // Se ejecuta mientras data sea diferente de 0
            while (data != 0) {
                // Mensaje en consola
                System.out.println("El dato del " + count + " es : " + data);
                // Incremento de la variable count
                count++;
                // Variable de tipo boolean
                // Se asigna falso
                first = false;
                // Se invoca el metodo iteratorTravel de la clase List
                data = objList.iteratorTravel(first);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para recorrer la lista de forma recursiva
    // El metodo no recibe parametros
    private static void triggerTravel() {

        // Mensaje en consola
        System.out.println("\nMostrando Datos de Forma Recursiva");
        // Variable de tipo boolean
        // Se inicializa en verdadero
        boolean first = true;

        // Bloque try-catch para manejar excepciones
        try {
            // Variable de tipo byte
            // Se inicializa en 1
            byte count = 1;
            // Variable de tipo entero
            // Se inicializa en 0
            int data = objList.iteratorTravel(first);
            // Se invoca el metodo recursiveTravel
            recursiveTravel(data, count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para recorrer la lista de forma recursiva
    // El metodo recibe un entero y un byte
    private static void recursiveTravel(int data, byte count) {
        // Condicion para verificar si data es diferente de 0
        if (data != 0) {
            System.out.println("El dato del nodo " + count + " es : " + data);
            count++;
            // Bloque try-catch para manejar excepciones
            try {
                // Se invoca el metodo iteratorTravel de la clase List
                recursiveTravel(objList.iteratorTravel(false), count);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void insertAtEnd() {
        System.out.println("Ingresar los datos al final de la lista");

        char opcInsert;
        do{
            System.out.println("Ingrese un número: ");
            int value = scan.nextInt();

            try {
                if (objList.insertAtEnd(value)) {
                    System.out.println("Número ingresado correctamente al final...");
                }else{
                    System.out.println("Error al ingresar el número, intentelo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do{
                System.out.println("\n¿Desea ingresar otro número? (S/N): ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            }while(opcInsert !='S' || opcInsert !='N');
        }while (opcInsert == 'S');
            
        }
}
