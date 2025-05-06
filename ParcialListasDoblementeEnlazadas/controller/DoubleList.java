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
        return this.firstPte == null;
    }

    public void headInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setPrevPte(null);
            newNode.setNextPte(this.firstPte);

            if (this.empty()) {
                this.lastPte = this.currentPte = this.firstPte = newNode;
            } else {
                this.firstPte.setPrevPte(newNode);
                this.firstPte = newNode;
            }
            this.currentPte = this.firstPte; // Mantener currentPte actualizado
        } catch (Exception e) {
            throw new Exception("Error al insertar el valor a la cabeza: " + e.getMessage());
        }
    }

    public Integer getFirstValue() {
        return (this.firstPte != null) ? this.firstPte.getInfo() : null;
    }

    public Integer getNextValue() {
        if (this.currentPte != null) {
            int value = this.currentPte.getInfo();
            this.currentPte = this.currentPte.getNextPte();
            return value;
        }
        return null;
    }

    public void resetIterator() {
        this.currentPte = this.firstPte;
    }

    public Integer findLowestValue() throws Exception {
        try {
            if (this.empty()) {
                return null; // O lanzar una excepción indicando que la lista está vacía
            }
            int lowest = Integer.MAX_VALUE;
            this.currentPte = this.firstPte;
            while (this.currentPte != null) {
                if (this.currentPte.getInfo() < lowest) {
                    lowest = this.currentPte.getInfo();
                }
                this.currentPte = this.currentPte.getNextPte();
            }
            return lowest;
        } catch (Exception e) {
            throw new Exception("Error al encontrar el valor más bajo: " + e.getMessage());
        } finally {
            this.currentPte = this.firstPte; // Resetear el iterador
        }
    }
}