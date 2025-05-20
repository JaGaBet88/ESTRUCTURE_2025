package rows;

import java.util.Scanner;
import controller.Row;

/*
Estudiante: Jairo Alberto Gallego Betancur
 */
public class Rows {

    static Scanner scan = new Scanner(System.in);
    static Row objRow = new Row(); // Cola original, primera cola
    static Row objRowBackup = new Row(); // Cola de respaldo
    static Row objRowSecond = new Row(); // Segunda cola para el punto 2

    public static void main(String[] args) {
        byte opc;

        do {
            menu();

            do {
                System.out.println("Ingrese la opcion: ");
                opc = scan.nextByte();
            } while (opc < 1 || opc > 7);

            switch (opc) {
                case 1: {
                    insertInitialNames();
                    break;
                }
                case 2: {
                    searchAndRemovePerson();
                    break;
                }
                case 3: {
                    concatenateQueues();
                    break;
                }
                case 4: {
                    insertAndReorder();
                    break;
                }
                case 5: {
                    showRow(); 
                    break;
                }
                case 6: {
                    System.out.println("\nMostrando el primer elemento: ");
                    getFirst();
                    break;
                }
                case 7: {
                    System.out.println("Saliendo del programa...");
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opc != 7);
    }

    private static void menu() {
        System.out.println("\n--- Menu de Colas ---");
        System.out.println("1. Ingresar nombres iniciales a la cola.");
        System.out.println("2. Punto 1: Solicitar y retirar persona.");
        System.out.println("3. Punto 2: Crear y concatenar segunda cola.");
        System.out.println("4. Punto 3: Ingresar persona, mover al principio.");
        System.out.println("5. Mostrar los datos de la cola (actual).");
        System.out.println("6. Mostrar el primer dato de la cola.");
        System.out.println("7. Salir");
    }

    private static void insertInitialNames() {
        char opcInsert;
        System.out.println("\n--- Ingresar nombres a la cola principal ---");

        do {
            System.out.println("Ingresar nombre: "); // Aclaración para evitar nombres compuestos
            String value = scan.next();

            try {
                if (objRow.insertLast(value)) {
                    System.out.println("'" + value + "' fue ingresado correctamente! ...");
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

        String data;
        int countData = 1;
        try {
            data = objRow.retireFirst();
            if (data == null) {
                System.out.println("La cola esta vacia!...");
            } else {
                while (data != null) {
                    System.out.println("El " + countData + " nombre es: " + data);
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

    private static void getFirst() {
        try {
            String data = objRow.getFirst();
            if (data != null) {
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
            String data = objRow.getLast();
            if (data != null) {
                System.out.println("El ultimo nombre en la cola es: " + data);
            } else {
                System.out.println("La cola esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void restoreBackup() {
        String data;
        try {
            data = objRowBackup.retireFirst();
            if (data == null) {
                // No se imprime nada, solo se sabe que el backup está vacío
            } else {
                while (data != null) {
                    objRow.insertLast(data);
                    data = objRowBackup.retireFirst();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al restaurar el backup: " + e.getMessage());
        }
    }

    // --- Implementación de los puntos del ejercicio (sin cambios significativos, solo ajustes de flujo) ---

    // Punto 1: Solicitar y retirar persona
    private static void searchAndRemovePerson() {
        System.out.println("\n--- Punto 1: Retirar persona ---");
        if (objRow.empty()) {
            System.out.println("La cola está vacía, no se pueden realizar búsquedas ni retiros.");
            return;
        }

        System.out.println("Ingrese el nombre de la persona a retirar: ");
        String nameToRetire = scan.next();

        try {
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

        // Primero, verificar si la cola principal está vacía para concatenar
        try {
            if (objRow.empty()) {
                System.out.println("La cola principal está vacía. Ingrese nombres primero (Opción 1 del menú).");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error verificando la cola principal: " + e.getMessage());
            return;
        }


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

        try {
            if (objRow.empty()) {
                System.out.println("La cola principal está vacía. Ingrese nombres primero (Opción 1 del menú).");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error verificando la cola principal: " + e.getMessage());
            return;
        }

        System.out.println("Ingrese el nombre de la persona que se colará como primero de la cola: ");
        String nameToReorder = scan.next();

        try {
            System.out.println("Reordenando la cola para poner a '" + nameToReorder + "' al principio...");

            Row tempQueue = new Row();
            String currentName;
            String nameFoundOrNew = nameToReorder; // El nombre que se moverá al principio

            // Paso 1: Mover todos los elementos de objRow a tempQueue,
            // excluyendo el nombre que se va a reordenar si ya existe.
            // Esto asegura que si ya está, no lo dupliquemos y lo movamos.
            while ((currentName = objRow.retireFirst()) != null) {
                if (!currentName.equalsIgnoreCase(nameToReorder)) {
                    tempQueue.insertLast(currentName);
                } else {
                    // Si ya estaba en la cola, lo consideramos "encontrado" y lo usaremos.
                    // No lo insertamos en tempQueue para que no se duplique.
                }
            }

            // Paso 2: Insertar el nombre a mover al principio de la cola principal (que ahora está vacía).
            // Si el nombre no estaba inicialmente en la cola, ahora será el primero.
            objRow.insertLast(nameFoundOrNew);

            // Paso 3: Volver a insertar los elementos restantes desde la cola temporal.
            // Estos irán después del nombre que se acaba de colocar al principio.
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