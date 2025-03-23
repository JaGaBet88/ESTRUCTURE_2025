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
            // Si la lista está vacía retorna falso y sale del método.
            if (this.empty()) {
                return false;
            } else {
                // Validar si solo hay un nodo en la lista
                // Si el siguiente nodo del primero es nulo
                if (this.firstPte.getNextPte() == null) {
                    this.firstPte = null;
                    return true;
                }
                this.currentPte = this.firstPte;
                while (this.currentPte.getNextPte().getNextPte() != null) {
                    this.currentPte = this.currentPte.getNextPte();
                }

                this.currentPte.setNextPte(null);
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el último nodo");
        }
    }

    public boolean removeAnyNode(int value) throws Exception {
        try {
            //Si la lista está vacía retornar un falso y salir del método.
            if (this.empty()) {
                return false;
            }
            
            //Validar si el primer nodo es el que se quiere eliminar
            if (this.firstPte.getInfo() == value) {
                this.firstPte = this.firstPte.getNextPte(); //Cambio el primer apuntador al siguiente nodo
                this.currentPte = this.firstPte; //Cambio el apuntador actual al primer apuntador
                return true;
            }

            //Recorro la lista
            Node previusPte = this.firstPte;
            this.currentPte = this.firstPte.getNextPte();

            while (this.currentPte != null) {
                if(this.currentPte.getInfo() == value){
                    previusPte.setNextPte(this.currentPte.getNextPte()); //Elimino el nodo
                    return true;
                }

                previusPte = this.currentPte;
                this.currentPte = this.currentPte.getNextPte();
            }

            return false;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el nodo");
        }
    }

    public boolean insertAfter(int target, int newAge) throws Exception{
        try {
            if (this.empty()) {
                return false; //Si la lista está vacía retorna falso y sale del método.
            }

            this.currentPte = this.firstPte;

            //Busca el nodo donde insertar despues.
            while (this.currentPte != null) {
                if (this.currentPte.getInfo() == target) {
                    break;
                }
                this.currentPte = this.currentPte.getNextPte();
            }

            if (this.currentPte == null) {
                return false; //No se encontró el nodo
            }

            //Crear y enlazar el nuevo nodo
            Node newNode = new Node();
            newNode.setInfo(newAge);
            newNode.setNextPte(this.currentPte.getNextPte());
            this.currentPte.setNextPte(newNode);

            return true;
        } catch (Exception e) {
            throw new Exception("Error al insertar el nodo despues de un valor especifico.");
        }
    }

    public boolean insertBefore(int target, int newValue) throws Exception {
        try {
            if (this.empty()) {
                return false;
            }
    
            // Caso: insertar antes del primer nodo
            if (this.firstPte.getInfo() == target) {
                Node newNode = new Node();
                newNode.setInfo(newValue);
                newNode.setNextPte(this.firstPte);
                this.firstPte = newNode;
                return true;
            }
    
            Node previousPte = this.firstPte;
            this.currentPte = this.firstPte.getNextPte();
    
            while (this.currentPte != null) {
                if (this.currentPte.getInfo() == target) {
                    break;
                }
                previousPte = this.currentPte;
                this.currentPte = this.currentPte.getNextPte();
            }
    
            if (this.currentPte == null) {
                return false; // No se encontró el target
            }
    
            Node newNode = new Node();
            newNode.setInfo(newValue);
            newNode.setNextPte(this.currentPte);
            previousPte.setNextPte(newNode);
    
            return true;
        } catch (Exception e) {
            throw new Exception("Error al insertar antes del nodo");
        }
    }
    
}
