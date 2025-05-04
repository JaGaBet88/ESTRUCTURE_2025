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
}