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

}
