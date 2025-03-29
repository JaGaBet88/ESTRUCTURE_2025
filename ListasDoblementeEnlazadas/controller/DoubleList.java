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

}