// package model; // Se mantiene el paquete

package model;

public class Node {

    private String info; // Cambiado de int a String
    private Node nextPte;

    public String getInfo() { // Cambiado el tipo de retorno
        return info;
    }

    public void setInfo(String info) { // Cambiado el tipo de parámetro
        this.info = info;
    }

    public Node getNextPte() {
        return nextPte;
    }

    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }
}