package model;

//Clase Node
//Clase que representa un nodo de la lista
public class Node {

    //Atributos de la clase
    //Variable de tipo entero que representa la informacion del nodo
    private int info;
    //Variable de tipo Node que representa el siguiente nodo
    //Se inicializa en nulo
    private Node nextPte;

    //Constructor de la clase
    //Constructor vacio
    public int getInfo() {
        return info;
    }

    //Metodos de la clase
    //Metodo get para obtener la informacion del nodo
    public void setInfo(int info) {
        this.info = info;
    }

    //Metodo set para asignar la informacion al nodo
    public Node getNextPte() {
        return nextPte;
    }

    //Metodo get para obtener el siguiente nodo
    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }
}
