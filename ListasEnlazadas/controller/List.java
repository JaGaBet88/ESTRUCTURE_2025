package controller;

import model.Node;

public class List {

    // Atributos de la clase
    private Node firstPte; // Apuntador al primer nodo de la lista
    private Node currentPte; // Apuntador al nodo actual de la lista

    // Constructor de la clase
    public List() {
        this.firstPte = null; // Al inicio la lista está vacía
        this.currentPte = null; // Al inicio la lista está vacía
    }

    // Métodos de la clase para validar si la lista está vacía
    private boolean empty() {
        return this.firstPte == null; // Si el primer nodo es nulo, la lista está vacía
    }

    public boolean insertList(int age) throws Exception {
        boolean result = true; // Variable para validar si se ingresó correctamente el nodo

        try {
            Node newNode = new Node();

            newNode.setInfo(age);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.firstPte = newNode;
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte = newNode;
            }

            this.currentPte = this.firstPte;

            return result; // Se ingresó correctamente el nodo
        } catch (Exception e) {
            throw new Exception("No se logro ingresar nodo al inicio de la lista!...");
        }
    }

    public int iteratorTravel(boolean first) throws Exception {
        int info = 0;
        try {
            if (this.empty()) {
                return info;
            } else {
                if (first) {
                    this.currentPte = this.firstPte;
                }

                if (this.currentPte != null) {
                    info = this.currentPte.getInfo();
                    this.currentPte = this.currentPte.getNextPte();
                    return info;
                } else {
                    this.currentPte = this.firstPte;
                    return info;
                }
            }
        } catch (Exception e) {
            throw new Exception("No se logro recorrer la lista!...");
        }
    }

    public boolean destroy() {
        if (!this.empty()) {
            this.currentPte = this.firstPte;

            while (this.currentPte != null) {
                this.currentPte = this.currentPte.getNextPte();
                this.firstPte.setNextPte(null);
                this.firstPte = this.currentPte;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean insertAtEnd(int value) throws Exception {
        boolean result = true; // Variable para validar si se ingresó correctamente el nodo
        try {
            Node newNode = new Node();

            newNode.setInfo(value);
            newNode.setNextPte(null); // Porque será el último nodo.

            if (this.empty()) {
                this.firstPte = newNode;
            } else {
                // Recorro la lista hasta el último nodo
                this.currentPte = this.firstPte;
                while (this.currentPte.getNextPte() != null) {
                    this.currentPte = this.currentPte.getNextPte();
                }

                this.currentPte.setNextPte(newNode);
            }
            return result; // Se ingresó correctamente el nodo
        } catch (Exception e) {
            throw new Exception("Error al ingresar el dato al final");
        }
    }

    public boolean deleteLastNode() throws Exception {
        try {
            if (this.empty()) {
                return false;
            } else {
                this.currentPte = this.firstPte;
                if (this.currentPte != this.firstPte) {
                    Node previewPte = null;
                    do {
                        previewPte = this.currentPte;
                        this.currentPte = this.currentPte.getNextPte();
                    } while (this.currentPte != this.firstPte);

                    previewPte.setNextPte(null);
                    this.currentPte = this.firstPte;
                    previewPte = null;
                } else {
                    this.currentPte = null;
                    this.firstPte = null;
                }
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el último nodo");
        }
    }

    public int deleteSpecificNode(int value) throws Exception {
        int counTimes = 0, result = 0;

        try {
            if (this.empty()){
                return result;
            }else{
                result = 200;
                this.currentPte = this.firstPte;
                Node previewPte = this.currentPte;
                Node temPte = null;

                while (this.currentPte != null) {
                    if () {
                        
                    }
                    
                }
            }
        } catch (Exception e) {
            
        }
    }
}
