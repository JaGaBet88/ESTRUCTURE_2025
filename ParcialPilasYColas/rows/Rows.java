// package rows; // Se mantiene el paquete
// import java.util.Scanner; // Se mantiene la importación
// import controller.Row; // Se mantiene la importación

package rows;

import java.util.Scanner;
import controller.Row;

/**
 * @author Tu Nombre Completo
 */
public class Rows { // Nombre de la clase principal, adaptado de Rows.java

    static Scanner scan = new Scanner(System.in);
    static Row objRow = new Row(); // Cola original/primera cola
    static Row objRowBackup = new Row(); // Cola de respaldo
    static Row objRowSecond = new Row(); // Segunda cola para el punto 2

    public static void main(String[] args) {
        // Tu Nombre Completo
        byte opc;

        // Inicializar la cola original con los nombres dados en el ejercicio 2
        try {
            objRow.insertLast("Maria");
            objRow.insertLast("Adolfo");
            objRow.insertLast("Camila");
        } catch (Exception e) {
            System.out.println("Error al inicializar la cola original: " + e.getMessage());
        }


        do {
            menu();

            do {
                System.out.println("Ingrese la opcion: ");
                opc = scan.nextByte();
            } while (opc < 1 || opc > 6); // Rango de opciones adaptado

            switch (opc) {
                case 1: {
                    searchAndRemovePerson(); // Punto 1 del ejercicio
                    break;
                }
                case 2: {
                    concatenateQueues(); // Punto 2 del ejercicio
                    break;
                }
                case 3: {
                    insertAndReorder(); // Punto 3 del ejercicio
                    break;
                }
                case 4: {
                    showRow(); // Mostrar la cola principal
                    break;
                }
                case 5: {
                    System.out.println("\nMostrando el primer elemento: ");
                    getFirst();
                    break;
                }
                case 6: {
                    System.out.println("\nMostrando el ultimo elemento: ");
                    getLast();
                    break;
                }
                default: {
                    break; // Salir (opción 7 en el menú original, ahora 6)
                }
            }
        } while (opc != 7); // La opción 7 será para salir
    }

    private static void menu() {
        System.out.println("\n--- Menu de Colas ---");
        System.out.println("1. Punto 1: Solicitar y retirar persona.");
        System.out.println("2. Punto 2: Crear y concatenar segunda cola.");
        System.out.println("3. Punto 3: Ingresar persona, mover al principio.");
        System.out.println("4. Mostrar los datos de la cola (actual).");
        System.out.println("5. Mostrar el primer dato de la cola.");
        System.out.println("6. Mostrar el ultimo dato de la cola.");
        System.out.println("7. Salir"); // Nueva opción para salir
    }

    // Adaptado del método insertLast original, ahora para fines de prueba o ingreso
    private static void insertLast() {
        char opcInsert;

        System.out.println("\nIngresar un nuevo nombre al final de la cola");

        do {
            System.out.println("Ingrese nombre: ");
            String value = scan.next(); // Leer String

            try {
                if (objRow.insertLast(value)) {
                    System.out.println("El nombre fue ingresado correctamente! ...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do {
                System.out.println("\nDesea ingresar otro nombre S para Si o N para No: ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');
        } while (opcInsert == 'S');
    }


    private static void showRow() {
        System.out.println("\nMostrando los datos de la cola");

        String data; // Cambiado a String
        int countData = 1;
        try {
            data = objRow.retireFirst(); // Obtener el primer elemento
            if (data == null) { // Si es null, la cola está vacía
                System.out.println("La cola esta vacia!...");
            } else {
                while (data != null) { // Iterar hasta que data sea null
                    System.out.println("El " + countData + " nombre es: " + data);
                    objRowBackup.insertLast(data); // Insertar en el backup
                    countData++;
                    data = objRow.retireFirst(); // Obtener el siguiente
                }
                restoreBackup(); // Restaurar la cola original
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // No se implementa sumRow ya que ahora la cola es de String, no de int.

    private static void getFirst() {
        try {
            String data = objRow.getFirst(); // Obtener String
            if (data != null) { // Si no es null, hay datos
                System.out.println("El primer nombre en la cola es: " + data);
            } else {
                System.out.println("La cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getLast() {
        try {
            String data = objRow.getLast(); // Obtener String
            if (data != null) { // Si no es null, hay datos
                System.out.println("El ultimo nombre en la cola es: " + data);
            } else {
                System.out.println("La cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void restoreBackup() {
        String data; // Cambiado a String
        try {
            data = objRowBackup.retireFirst(); // Obtener del backup
            if (data == null) { // Si es null, el backup está vacío
                // No se imprime nada, solo se sabe que el backup está vacío
            } else {
                while (data != null) { // Iterar hasta que data sea null
                    objRow.insertLast(data); // Insertar en la cola original
                    data = objRowBackup.retireFirst(); // Obtener el siguiente del backup
                }
            }
        } catch (Exception e) {
            System.out.println("Error al restaurar el backup: " + e.getMessage());
        }
    }

    // --- Implementación de los puntos del ejercicio ---

    // Punto 1: Solicitar y retirar persona
    private static void searchAndRemovePerson() {
        System.out.println("\n--- Punto 1: Retirar persona ---");
        System.out.println("Ingrese el nombre de la persona a retirar: ");
        String nameToRetire = scan.next();

        try {
            if (objRow.empty()) {
                System.out.println("La cola está vacía, no se pueden realizar búsquedas ni retiros.");
                return;
            }

            // Realizar una "búsqueda" temporal para ver si el nombre existe sin modificar la cola principal
            Row tempQueue = new Row();
            boolean foundInQueue = false;
            String currentName;

            // Mover elementos a la cola temporal para buscar
            while ((currentName = objRow.retireFirst()) != null) {
                if (currentName.equalsIgnoreCase(nameToRetire)) {
                    foundInQueue = true;
                }
                tempQueue.insertLast(currentName);
            }

            // Restaurar la cola original
            while ((currentName = tempQueue.retireFirst()) != null) {
                objRow.insertLast(currentName);
            }

            if (foundInQueue) {
                // Si la persona existe, intentar eliminarla
                if (objRow.removeSpecific(nameToRetire)) {
                    // Mensaje ya impreso dentro de removeSpecific
                } else {
                    System.out.println("El nombre '" + nameToRetire + "' no se pudo eliminar (error interno).");
                }
            } else {
                System.out.println("El nombre '" + nameToRetire + "' no se encuentra en la cola.");
            }

        } catch (Exception e) {
            System.out.println("Error en la operación de búsqueda y retiro: " + e.getMessage());
        }
    }


    // Punto 2: Crear y concatenar segunda cola
    private static void concatenateQueues() {
        System.out.println("\n--- Punto 2: Concatenar colas ---");

        // Asegurarse de que la segunda cola esté vacía antes de llenarla para este ejercicio
        try {
            while (objRowSecond.retireFirst() != null) {
                // Vaciar la segunda cola
            }
        } catch (Exception e) {
             System.out.println("Error al vaciar la segunda cola: " + e.getMessage());
        }


        try {
            // Llenar la segunda cola según la imagen
            objRowSecond.insertLast("Paulina");
            objRowSecond.insertLast("Jaime");
            System.out.println("Segunda cola creada: Paulina -> Jaime");

            System.out.print("Cola original antes de concatenar: ");
            showRow(); // Mostrar la cola original antes

            objRow.concatenate(objRowSecond);
            System.out.println("\nColas concatenadas. La nueva cola original es:");
            showRow(); // Mostrar la cola después de la concatenación

        } catch (Exception e) {
            System.out.println("Error al concatenar las colas: " + e.getMessage());
        }
    }

    // Punto 3: Ingresar persona, mover al principio
    private static void insertAndReorder() {
        System.out.println("\n--- Punto 3: Ingresar y reordenar persona ---");
        System.out.println("Ingrese el nombre de la persona que se colonó como primero de la cola: ");
        String nameToReorder = scan.next();

        try {
            // 1. Ingresar la persona al final de la cola (como indica la imagen: "el que iba de primera le estaba guardando el puesto")
            if (objRow.insertLast(nameToReorder)) {
                System.out.println("'" + nameToReorder + "' ha sido ingresado al final de la cola.");
            } else {
                System.out.println("No se pudo ingresar a '" + nameToReorder + "'.");
                return;
            }

            // 2. Simular que se movió al principio. Esto implica:
            //    a. Eliminarlo de su posición actual (el final)
            //    b. Insertarlo al principio
            //    La forma más sencilla de "mover al principio" sin una operación de insertFirst es:
            //    Crear una nueva cola temporal.
            //    Retirar todos los elementos de la cola original, excepto el que acabamos de mover.
            //    Insertar el elemento movido primero en la cola temporal.
            //    Luego, insertar los demás elementos en la cola temporal.
            //    Finalmente, restaurar la cola original desde la temporal.

            Row tempQueue = new Row();
            String currentName;
            String nameRemoved = null; // Para guardar el nombre que se "movió"

            // Buscar y remover el nombre que se reordenará (que ahora está al final)
            // Esto es un poco contraintuitivo si el enunciado implica que ya lo ingresamos.
            // La interpretación es que 'nameToReorder' *es* el que se va a mover de su posición actual al principio.
            // Si ya lo insertamos al final, ahora lo "sacamos" de ahí y lo ponemos al principio.
            // Sin embargo, si el ejercicio implica que "el que iba de primera le estaba guardando el puesto" y
            // se ingresó *a esa persona*, entonces esa persona ya está en la cola, y lo que se hace es
            // "sacarla" de su posición y ponerla de primera.

            // Vamos a reinterpretar: Se ingresa una persona y esa persona debe ir de primera.
            // Lo más directo es simplemente insertar el nombre al principio.
            // Pero el patrón de la cola que tenemos no tiene `insertFirst`.
            // La única forma de ponerlo al principio con las operaciones dadas es desapilar todo,
            // insertar el nuevo, y luego volver a apilar el resto.
            // Para colas, sería: retirar todos, insertar el nuevo primero, insertar los demás.

            System.out.println("Reordenando la cola para poner a '" + nameToReorder + "' al principio...");

            // Paso 1: Sacar todos los elementos y ponerlos en el backup, excepto el que queremos mover.
            // Si el nombre ya está en la cola, lo ignoramos al mover.
            // Si no está, se insertó al final y ahora lo movemos.
            while ((currentName = objRow.retireFirst()) != null) {
                if (!currentName.equalsIgnoreCase(nameToReorder)) {
                    tempQueue.insertLast(currentName);
                } else {
                    nameRemoved = currentName; // Si es el que queremos mover, lo "capturamos"
                }
            }

            // Paso 2: Insertar el nombre a mover al principio de la cola principal (que ahora está vacía)
            if (nameRemoved != null) { // Si se encontró o se acaba de insertar
                 objRow.insertLast(nameRemoved); // Se inserta como el nuevo "primero"
            } else {
                 // Esto no debería pasar si se insertó justo antes, pero por si acaso.
                 // Si se quiere asegurar que es el que se acaba de ingresar, se usaría nameToReorder directamente.
                 objRow.insertLast(nameToReorder);
            }


            // Paso 3: Volver a insertar los elementos restantes desde la cola temporal
            while ((currentName = tempQueue.retireFirst()) != null) {
                objRow.insertLast(currentName);
            }

            System.out.println("Cola después de reordenar:");
            showRow();

        } catch (Exception e) {
            System.out.println("Error en la operación de insertar y reordenar: " + e.getMessage());
        }
    }
}
