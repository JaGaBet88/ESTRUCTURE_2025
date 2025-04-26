package model;

public class NodeOrdinaryHour {
    public double value;
    public NodeOrdinaryHour next;
    public NodeOrdinaryHour prev;

    public NodeOrdinaryHour(double value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
