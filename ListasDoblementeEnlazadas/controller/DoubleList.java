package controller;

import model.Node;

public class DoubleList {

    private Node firstPte;
    private Node currentPte;
    private Node lastPte;

    public DoubleList() {
        this.firstPte = null;
        this.currentPte = null;
        this.lastPte = null;
    }

    private boolean empty() {
        return this.firstPte == null && this.currentPte == null && this.lastPte == null;
    }

    public boolean headInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setPrevPte(null);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.lastPte = this.currentPte = this.firstPte = newNode;
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte.setPrevPte(newNode);
                this.firstPte = newNode;
            }

            return true;
        } catch (Exception e) {
            throw new Exception("Error al ingresar el dato a la cabeza! ...");
        }
    }

    /*public int iteratorTravel(boolean first) throws Exception {
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
    }*/

    public void displayAll() throws Exception {
        try {
            if (this.empty()) {
                System.out.println("La lista está vacía.");
                return;
            }
    
            this.currentPte = this.firstPte;
            byte count = 1;
    
            do {
                System.out.println("La edad " + count + " es : " + this.currentPte.getInfo());
                this.currentPte = this.currentPte.getNextPte();
                count++;
            } while (this.currentPte != null && this.currentPte != this.firstPte); // Para circular y normal
        } catch (Exception e) {
            throw new Exception("Error al recorrer la lista...");
        }
    }

    public void recursiveDisplay() throws Exception {
        if (this.empty()) {
            System.out.println("La lista está vacía.");
            return;
        }
    
        System.out.println("\nMostrando Datos de Forma Recursiva:");
        recursivePrint(this.firstPte, this.firstPte, (byte) 1, true);
    }
    
    private void recursivePrint(Node current, Node start, byte count, boolean firstCall) {
        if (current == null || (!firstCall && current == start)) {
            return;
        }
    
        System.out.println("El dato del nodo " + count + " es : " + current.getInfo());
        recursivePrint(current.getNextPte(), start, (byte)(count + 1), false);
    }    
    
    public boolean destroy() throws Exception {
        try {
            if (!this.empty()) {
                this.currentPte = this.firstPte;

                while (this.currentPte != null) {
                    if (this.firstPte == this.lastPte) {
                        this.firstPte = this.currentPte = this.lastPte = null;
                    } else {
                        this.currentPte = this.currentPte.getNextPte();
                        this.currentPte.setPrevPte(null);
                        this.firstPte.setNextPte(null);
                        this.firstPte = this.currentPte;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro destruir la lista doblemene ligada! ...");
        }
    }

    public boolean deleteFirst() throws Exception {
        try {
            this.currentPte = this.firstPte;

            if (!this.empty()) {
                if (this.firstPte == this.lastPte) {
                    this.lastPte = this.currentPte = this.firstPte = null;
                } else {
                    this.firstPte = this.firstPte.getNextPte();
                    this.firstPte.setPrevPte(null);
                    this.currentPte.setNextPte(null);
                    this.currentPte = this.firstPte;
                }

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro destruir la lista doblemene ligada! ...");
        }
    }

    public boolean deleteLast() throws Exception {
        try {
            this.currentPte = this.firstPte;

            if (!this.empty()) {
                if (this.firstPte == this.lastPte) {
                    this.lastPte = this.currentPte = this.firstPte = null;
                } else {
                    while (this.currentPte.getNextPte() != null) {
                        this.currentPte = this.currentPte.getNextPte();
                    }

                    this.lastPte = this.lastPte.getPrevPte();
                    this.currentPte.setPrevPte(null);
                    this.lastPte.setNextPte(null);
                    this.currentPte = this.lastPte;
                }

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro eliminar el ulitmo nodo de la lista doblemene ligada! ...");
        }
    }

    public int deleteSpecifictNode(int value) throws Exception {
        try {
            if (this.empty()) {
                return 0;
            }

            Node temp = this.firstPte;

            while (temp != null) {
                if (temp.getInfo() == value) {

                    // Si es el único nodo
                    if (temp == firstPte && temp == lastPte) {
                        firstPte = lastPte = currentPte = null;
                    }

                    // Si es el primer nodo
                    else if (temp == firstPte) {
                        firstPte = firstPte.getNextPte();
                        firstPte.setPrevPte(null);
                    }

                    // Si es el último nodo
                    else if (temp == lastPte) {
                        lastPte = lastPte.getPrevPte();
                        lastPte.setNextPte(null);
                    }

                    // Nodo intermedio
                    else {
                        temp.getPrevPte().setNextPte(temp.getNextPte());
                        temp.getNextPte().setPrevPte(temp.getPrevPte());
                    }

                    // Limpieza opcional
                    temp.setPrevPte(null);
                    temp.setNextPte(null);

                    return value; // éxito
                }

                temp = temp.getNextPte();
            }

            return 200; // No se encontró
        } catch (Exception e) {
            throw new Exception("Error al eliminar un nodo específico de la lista!...");
        }
    }

    public boolean insertAfter(int targetValue, int newValue) throws Exception {
        try {
            if (this.empty())
                return false;

            this.currentPte = this.firstPte;

            while (this.currentPte != null) {
                if (this.currentPte.getInfo() == targetValue) {
                    Node newNode = new Node();
                    newNode.setInfo(newValue);

                    newNode.setPrevPte(this.currentPte);
                    newNode.setNextPte(this.currentPte.getNextPte());

                    if (this.currentPte.getNextPte() != null) {
                        this.currentPte.getNextPte().setPrevPte(newNode);
                    } else {
                        // Si es el último nodo
                        this.lastPte = newNode;
                    }

                    this.currentPte.setNextPte(newNode);
                    return true;
                }
                this.currentPte = this.currentPte.getNextPte();
            }

            return false;
        } catch (Exception e) {
            throw new Exception("Error al insertar después del nodo!...");
        }
    }

    public boolean insertBefore(int targetValue, int newValue) throws Exception {
        try {
            if (this.empty())
                return false;

            this.currentPte = this.firstPte;

            while (this.currentPte != null) {
                if (this.currentPte.getInfo() == targetValue) {
                    Node newNode = new Node();
                    newNode.setInfo(newValue);

                    newNode.setNextPte(this.currentPte);
                    newNode.setPrevPte(this.currentPte.getPrevPte());

                    if (this.currentPte.getPrevPte() != null) {
                        this.currentPte.getPrevPte().setNextPte(newNode);
                    } else {
                        // Si es el primer nodo
                        this.firstPte = newNode;
                    }

                    this.currentPte.setPrevPte(newNode);
                    return true;
                }
                this.currentPte = this.currentPte.getNextPte();
            }

            return false;
        } catch (Exception e) {
            throw new Exception("Error al insertar antes del nodo!...");
        }
    }

    public boolean insertLast(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setNextPte(null); // ya que será el último nodo

            if (this.empty()) {
                // Si la lista está vacía, el nuevo nodo es el único nodo
                this.firstPte = this.lastPte = this.currentPte = newNode;
                newNode.setPrevPte(null);
            } else {
                // Si ya hay nodos, lo enlazamos al final
                newNode.setPrevPte(this.lastPte);
                this.lastPte.setNextPte(newNode);
                this.lastPte = newNode; // Actualizamos el puntero al último nodo
            }

            return true;
        } catch (Exception e) {
            throw new Exception("Error al insertar el nodo al final de la lista.");
        }
    }

    public void makeCircular() throws Exception {
        try {
            if (!this.empty() && this.firstPte != this.lastPte) {
                this.firstPte.setPrevPte(this.lastPte);
                this.lastPte.setNextPte(this.firstPte);
                System.out.println("La lista se ha convertido en circular!");
            } else if (this.firstPte == this.lastPte && this.firstPte != null) {
                // Solo hay un nodo, él se apunta a sí mismo
                this.firstPte.setPrevPte(this.firstPte);
                this.firstPte.setNextPte(this.firstPte);
                System.out.println("La lista con un solo nodo también es circular ahora!");
            } else {
                System.out.println("La lista está vacía. No se puede hacer circular.");
            }
        } catch (Exception e) {
            throw new Exception("Error al convertir la lista en circular.");
        }
    }
  
}
