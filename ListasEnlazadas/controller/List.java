package controller;

import model.Node;

public class List {

    //Atributos tipo nodo privados
    private Node firstPte; //Primer puntero
    private Node currentPte;

    //Constructor de la clase
    public List() {
        this.firstPte = null;
        this.currentPte = null;
    }

    //Metodo privado para verificar si la lista esta vacia
    private boolean empty() {
        return this.firstPte == null;
    }

    //Metodo para insertar un nodo al inicio de la lista
    //El metodo recibe un entero que representa la edad a insertar
    public boolean insertList(int age) throws Exception { 
        
        //Variable de tipo booleano para verificar si se logro insertar el nodo
        boolean result = true;

        //Bloque try-catch para manejar excepciones
        try {
            //Se crea un nuevo nodo
            Node newNode = new Node();

            //Se asigna la edad al nodo
            newNode.setInfo(age);            
            //Se asigna el siguiente nodo como nulo
            newNode.setNextPte(null);

            //Si la lista esta vacia
            //Se asigna el nuevo nodo al primer puntero de la lista
            if (this.empty()) {
                this.firstPte = newNode;
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte = newNode;
            }

            //Se asigna el nodo actual al primer nodo de la lista
            this.currentPte = this.firstPte;

            //Se retorna el valor de la variable result
            return result;

        //Se captura la excepcion y se lanza un mensaje
        //Se lanza una excepcion
        } catch (Exception e) {
            throw new Exception("No se logro ingresar nodo al inicio de la lista!...");
        }
    }

    //Metodo para recorrer la lista de forma iterativa
    //El metodo recibe un booleano que indica si es la primera vez que se recorre la lista
    public int iteratorTravel(boolean first) throws Exception {

        //Variable de tipo entero para almacenar la informacion del nodo
        int info = 0;

        //Bloque try-catch para manejar excepciones
        try {

            //Si la lista esta vacia
            //Se retorna la variable info
            if (this.empty()) {
                return info;
            } else {
                if (first) {
                    this.currentPte = this.firstPte;
                }

                if (this.currentPte != null) {
                    info = this.currentPte.getInfo();
                    this.currentPte = this.currentPte.getNextPte();
                    return info;
                } else {
                    this.currentPte = this.firstPte;
                    return info;
                }
            }
        } catch (Exception e) {
            throw new Exception("No se logro recorrer la lista!...");
        }
    }


    public boolean insertAtEnd(int value) throws Exception{

        try {

        //Crea el nuevo nodo
        Node newNode = new Node();
        newNode.setInfo(value);
        newNode.setNextPte(null);

        //Si la lista está vacia, el nuevo nodo será el primer nodo.
        if (this.empty()) {
            this.firstPte = newNode;
        }else{
            //Buscar el último nodo
            Node temp = this.firstPte;
            while (temp.getNextPte() != null) {
                temp = temp.getNextPte();
            }
            //Asignar el nuevo nodo como el siguiente del último nodo
            temp.setNextPte(newNode);
        }

        return true;

        } catch (Exception e) {
            throw new Exception("Error al ingresar el dato al final");
        }

    }
}
