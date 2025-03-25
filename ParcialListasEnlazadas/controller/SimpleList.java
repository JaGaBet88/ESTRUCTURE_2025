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

    public boolean insertList(double age) throws Exception {
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

    //Mostrar el promedio de las notas que se encuentran sobre la lista
    public double showAverage() {
        double sum = 0;
        int count = 0;
        this.currentPte = this.firstPte;
        while (this.currentPte != null) {
            sum += this.currentPte.getInfo();
            count++;
            this.currentPte = this.currentPte.getNextPte();
        }
        return sum / count;
    }
}