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

    public int countOccurrences(int searchData) throws Exception {
        try {
            if (this.empty()) {
                return 0;
            }
            int count = 0;
            this.currentPte = this.firstPte;
            while (this.currentPte != null) {
                if (this.currentPte.getInfo() == searchData) {
                    count++;
                }
                this.currentPte = this.currentPte.getNextPte();
            }
            return count;
        } catch (Exception e) {
            throw new Exception("Error al contar las ocurrencias: " + e.getMessage());
        } finally {
            this.resetIterator();
        }
    }
}