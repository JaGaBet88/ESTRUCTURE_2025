package controller;

import model.Node;

public class List {

    private Node firstPte;
    private Node currentPte;

    public List() {
        this.firstPte = null;
        this.currentPte = null;
    }

    private boolean empty() {
        return this.firstPte == null;
    }

    public boolean insertList(int age) throws Exception {
        boolean result = true;

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

            return result;
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
}
