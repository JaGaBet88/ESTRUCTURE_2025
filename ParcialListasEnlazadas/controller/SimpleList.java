package controller;

import model.Node;

public class SimpleList {

    private Node firstPte;
    private Node currentPte;

    public SimpleList() {
        this.firstPte = null;
        this.currentPte = null;
    }

    private boolean empty() {
        return this.firstPte == null;
    }

    // Insertar nota al inicio de la lista
    public boolean insertList(double nota) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(nota); // Almacena la nota en el nodo
            newNode.setNextPte(null); // El siguiente nodo es nulo

            if (this.empty()) {
                this.firstPte = newNode; // El primer nodo es el nuevo nodo
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte = newNode;
            }

            this.currentPte = this.firstPte;
            return true;
        } catch (Exception e) {
            throw new Exception("No se logró ingresar la nota a la lista.");
        }
    }

    // Mostrar el promedio de las notas
    public double showAverage() {
        double sum = 0;
        int count = 0;
        this.currentPte = this.firstPte;
        while (this.currentPte != null) {
            sum += this.currentPte.getInfo();
            count++;
            this.currentPte = this.currentPte.getNextPte();
        }
        return (count > 0) ? sum / count : 0; // Retorna el promedio de las notas
    }

    // Mostrar todas las notas de la lista
    public void showList() {
        this.currentPte = this.firstPte;
        System.out.println("\nNotas almacenadas en la lista:");
        while (this.currentPte != null) {
            System.out.println(this.currentPte.getInfo());
            this.currentPte = this.currentPte.getNextPte();
        }
    }
}
