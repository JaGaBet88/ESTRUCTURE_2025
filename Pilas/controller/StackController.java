package controller;


import model.Node;

public class StackController {

    private Node topPte;

    public StackController() {
        topPte = null;
    }

    private boolean empty() {
        return topPte == null;
    }

    public boolean insertTop(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setNextPte(this.topPte);

            this.topPte = newNode;

            return true;
        } catch (Exception e) {
            throw new Exception("Error al ingresar la edad!..");
        }
    }

    public int removeTop() throws Exception {
        int value = 0;
        try {
            if (this.empty()) {
                return value;
            } else {
                Node tmpPte = this.topPte;
                value = this.topPte.getInfo();
                this.topPte = this.topPte.getNextPte();
                tmpPte.setNextPte(null);
                tmpPte = null;

                return value;
            }
        } catch (Exception e) {
            throw new Exception("Error al ingresar la edad!..");
        }
    }

    public int takeFirstTopData() throws Exception {
        try {
            if ( this.empty() ) {
                return 0;
            } else {
                return this.topPte.getInfo();
            }

        } catch (Exception e) {
            throw new Exception("Error al intentar mostrar la edad la cima de la pila!..");
        }
    }

}