package model;

public class Node {

    //Atributos de tipo nodo, son apuntadores.
    private int info; //Información del nodo (edad)
    private Node nextPte; //Apuntador al siguiente nodo

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNextPte() {
        return nextPte;
    }

    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }
}
