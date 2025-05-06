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

    public void headInsert(int value) {
        Node newNode = new Node();
        newNode.setInfo(value);
        newNode.setPrevPte(null);
        newNode.setNextPte(this.firstPte);

        if (this.empty()) {
            this.lastPte = newNode;
        } else {
            this.firstPte.setPrevPte(newNode);
        }
        this.firstPte = newNode;
        this.currentPte = newNode; // Mantener currentPte actualizado al insertar en la cabeza
    }

    public Node getFirstPte() {
        return firstPte;
    }

    // Método para obtener el siguiente nodo
    public Node getNextNode(Node currentNode) {
        if (currentNode != null) {
            return currentNode.getNextPte();
        }
        return null;
    }
}