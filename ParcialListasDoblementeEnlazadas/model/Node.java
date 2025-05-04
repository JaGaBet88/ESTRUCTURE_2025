
package model;

public class Node {
    private Node prevPte;
    private int info;
    private Node nextPte;

    public Node getPrevPte() {
        return prevPte;
    }

    public void setPrevPte(Node prevPte) {
        this.prevPte = prevPte;
    }

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
