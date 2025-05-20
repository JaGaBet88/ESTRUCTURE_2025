package model;

public class Node {

    private String info; 
    private Node nextPte;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node getNextPte() {
        return nextPte;
    }

    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }
}