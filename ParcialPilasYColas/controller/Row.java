// package controller; // Se mantiene el paquete
// import model.Node; // Se mantiene la importación

package controller;

import model.Node;

public class Row {

    private Node firstPte;
    private Node lastPte;

    private boolean empty() {
        return this.firstPte == null && this.lastPte == null;
    }

    public Row() {
        this.firstPte = null;
        this.lastPte = null;
    }

    public boolean insertLast(String value) throws Exception { // Cambiado de int a String
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.firstPte = this.lastPte = newNode;
            } else {
                this.lastPte.setNextPte(newNode);
                this.lastPte = this.lastPte.getNextPte();
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Error al ingresar el nombre!"); // Mensaje adaptado
        }
    }

    public String retireFirst() throws Exception { // Cambiado de int a String
        String data = null; // Inicializado a null

        try {
            if (!this.empty()) {
                data = this.firstPte.getInfo();
                Node tmPte = this.firstPte;
                this.firstPte = this.firstPte.getNextPte();

                if (this.firstPte == null) {
                    this.lastPte = this.firstPte;
                }

                tmPte.setNextPte(null);
                tmPte = null;
            }
            return data;
        } catch (Exception e) {
            throw new Exception("Error al retirar el primer nombre!"); // Mensaje adaptado
        }
    }

    public String getFirst() throws Exception { // Cambiado de int a String
        try {
            if (this.empty()) {
                return null; // Devuelve null si está vacía
            } else {
                return this.firstPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el primer nombre de la cola!"); // Mensaje adaptado
        }
    }

    public String getLast() throws Exception { // Cambiado de int a String
        try {
            if (this.empty()) {
                return null; // Devuelve null si está vacía
            } else {
                return this.lastPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el ultimo nombre de la cola!"); // Mensaje adaptado
        }
    }

    // Método adicional para el ejercicio 2 y 3, que permite concatenar colas
    public void concatenate(Row otherRow) throws Exception {
        if (otherRow.empty()) {
            return; // No hay nada que concatenar si la otra cola está vacía
        }

        if (this.empty()) { // Si la cola actual está vacía, simplemente se vuelve la otra cola
            this.firstPte = otherRow.firstPte;
            this.lastPte = otherRow.lastPte;
        } else {
            this.lastPte.setNextPte(otherRow.firstPte);
            this.lastPte = otherRow.lastPte;
        }

        // Importante: vaciar la cola que se concatenó para evitar referencias dobles
        otherRow.firstPte = null;
        otherRow.lastPte = null;
    }

    // Método para buscar y eliminar (punto 1 y 3)
    public boolean removeSpecific(String nameToFind) throws Exception {
        if (this.empty()) {
            return false; // La cola está vacía, no se puede eliminar
        }

        // Si el elemento a eliminar es el primero
        if (this.firstPte.getInfo().equalsIgnoreCase(nameToFind)) {
            String removedName = retireFirst(); // Usar el método existente para retirar el primero
            System.out.println("Se eliminó a " + removedName + " de la cola.");
            return true;
        }

        Node current = this.firstPte;
        Node previous = null;

        // Recorrer la cola para encontrar el nombre
        while (current != null && !current.getInfo().equalsIgnoreCase(nameToFind)) {
            previous = current;
            current = current.getNextPte();
        }

        // Si se encontró el nombre
        if (current != null) {
            // Si el nodo a eliminar es el último
            if (current == this.lastPte) {
                this.lastPte = previous;
                if (previous != null) {
                    previous.setNextPte(null);
                } else { // Si solo había un elemento y era el que se eliminó
                    this.firstPte = null;
                }
            } else { // Si el nodo a eliminar está en el medio
                previous.setNextPte(current.getNextPte());
            }
            current.setNextPte(null); // Desvincular el nodo
            System.out.println("Se eliminó a " + current.getInfo() + " de la cola.");
            return true;
        } else {
            return false; // El nombre no se encontró
        }
    }
}