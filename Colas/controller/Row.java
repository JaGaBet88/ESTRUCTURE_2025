package controller;

import model.Node;

public class Row {

    private Node firstPte;
    private Node lastPte;

    private boolean empty() {
        return this.firstPte == null && this.lastPte == null;
    }

    public Row() {
        this.firstPte = null;
        this.lastPte = null;
    }

    public boolean insertLast(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.firstPte = this.lastPte = newNode;
            } else {
                this.lastPte.setNextPte(newNode);
                this.lastPte = this.lastPte.getNextPte();
//            this.lastPte = newNode;
            }

            return true;
        } catch (Exception e) {
            throw new Exception("Error al ingresar la edad!..");
        }
    }

    public int retireFirst() throws Exception {
        int data = 0;

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
            throw new Exception("Error al retirar la primera edad!..");
        }
    }

    public int getFirst() throws Exception  {
        try {
            if (this.empty()) {
                return 0;
            } else {
                return this.firstPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al retirar la primera edad de la cola!..");
        }
    }

    public int getLast() throws Exception  {
        try {
            if (this.empty()) {
                return 0;
            } else {
                return this.lastPte.getInfo();
            }
        } catch (Exception e) {
            throw new Exception("Error al retirar la ultima edad de la cola!..");
        }
    }

}
