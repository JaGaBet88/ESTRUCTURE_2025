package controller;

import model.Node;

public class Row {

    private Node firstPte;
    private Node lastPte;

    public boolean empty() {
        return this.firstPte == null && this.lastPte == null;
    }

    public Row() {
        this.firstPte = null;
        this.lastPte = null;
    }

    public boolean insertLast(String value) throws Exception {
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
            throw new Exception("Error al ingresar el nombre!");
        }
    }

    public String retireFirst() throws Exception {
        String data = null;

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
            throw new Exception("Error al retirar el primer nombre!");
        }
    }

    public String getFirst() throws Exception {
        try {
            if (this.empty()) {
                return null;
            } else {
                return this.firstPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el primer nombre de la cola!");
        }
    }

    public String getLast() throws Exception {
        try {
            if (this.empty()) {
                return null;
            } else {
                return this.lastPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el ultimo nombre de la cola!");
        }
    }

    public void concatenate(Row otherRow) throws Exception {
        if (otherRow.empty()) {
            return;
        }

        if (this.empty()) {
            this.firstPte = otherRow.firstPte;
            this.lastPte = otherRow.lastPte;
        } else {
            this.lastPte.setNextPte(otherRow.firstPte);
            this.lastPte = otherRow.lastPte;
        }

        otherRow.firstPte = null;
        otherRow.lastPte = null;
    }


    public boolean removeSpecific(String nameToFind) throws Exception {
        if (this.empty()) {
            return false; 
        }

        if (this.firstPte.getInfo().equalsIgnoreCase(nameToFind)) {
            String removedName = retireFirst(); // Usar el método existente para retirar el primero
            System.out.println("Se eliminó a " + removedName + " de la cola.");
            return true;
        }

        Node current = this.firstPte;
        Node previous = null;

        while (current != null && !current.getInfo().equalsIgnoreCase(nameToFind)) {
            previous = current;
            current = current.getNextPte();
        }

        if (current != null) {
            if (current == this.lastPte) {
                this.lastPte = previous;
                if (previous != null) {
                    previous.setNextPte(null);
                } else {
                    this.firstPte = null;
                }
            } else {
                previous.setNextPte(current.getNextPte());
            }
            current.setNextPte(null);
            System.out.println("Se eliminó a " + current.getInfo() + " de la cola.");
            return true;
        } else {
            return false;
        }
    }
}