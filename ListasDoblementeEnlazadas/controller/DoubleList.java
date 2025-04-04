package controller;

import model.Node;

public class DoubleList {

    private Node firstPte;
    private Node currentPte;
    private Node lastPte;

    public DoubleList() {
        this.firstPte = null;
        this.currentPte = null;
        this.lastPte = null;
    }

    private boolean empty() {
        return this.firstPte == null && this.currentPte == null && this.lastPte == null;
    }

    public boolean headInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);
            newNode.setPrevPte(null);
            newNode.setNextPte(null);

            if (this.empty()) {
                this.lastPte = this.currentPte = this.firstPte = newNode;
            } else {
                newNode.setNextPte(this.firstPte);
                this.firstPte.setPrevPte(newNode);
                this.firstPte = newNode;
            }

            return true;
        } catch (Exception e) {
            throw new Exception("Error al ingresar el dato a la cabeza! ...");
        }
    }

    public int iteratorTravel(boolean first) throws Exception {
        int info = 0;
        try {
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

    public boolean destroy() throws Exception {
        try {
            if (!this.empty()) {
                this.currentPte = this.firstPte;

                while (this.currentPte != null) {
                    if (this.firstPte == this.lastPte) {
                        this.firstPte = this.currentPte = this.lastPte = null;
                    } else {
                        this.currentPte = this.currentPte.getNextPte();
                        this.currentPte.setPrevPte(null);
                        this.firstPte.setNextPte(null);
                        this.firstPte = this.currentPte;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro destruir la lista doblemene ligada! ...");
        }
    }

    public boolean deleteFirst() throws Exception {
        try {
            this.currentPte = this.firstPte;

            if (!this.empty()) {
                if (this.firstPte == this.lastPte) {
                    this.lastPte = this.currentPte = this.firstPte = null;
                } else {
                    this.firstPte = this.firstPte.getNextPte();
                    this.firstPte.setPrevPte(null);
                    this.currentPte.setNextPte(null);
                    this.currentPte = this.firstPte;
                }

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro destruir la lista doblemene ligada! ...");
        }
    }

    public boolean deleteLast() throws Exception {
        try {
            this.currentPte = this.firstPte;

            if (!this.empty()) {
                if (this.firstPte == this.lastPte) {
                    this.lastPte = this.currentPte = this.firstPte = null;
                } else {
                    while (this.currentPte.getNextPte() != null) {
                        this.currentPte = this.currentPte.getNextPte();
                    }

                    this.lastPte = this.lastPte.getPrevPte();
                    this.currentPte.setPrevPte(null);
                    this.lastPte.setNextPte(null);
                    this.currentPte = this.lastPte;
                }

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro eliminar el ulitmo nodo de la lista doblemene ligada! ...");
        }
    }

    public int deleteSpecifictNode(int value) throws Exception {
        int counTimes = 0, result = 0;

        try {
            if (this.empty()) {
                return result;
            } else {
                result = 200;
//                this.currentPte = this.firstPte;
//                Node previewPte = this.currentPte;
                Node previewPte = this.currentPte = this.firstPte;                
                Node temPte = null;

                while (this.currentPte != null) {
                    if (this.firstPte.getInfo() == value) {
                        this.firstPte = this.firstPte.getNextPte();
                        if( this.lastPte.getPrevPte() == null && this.lastPte.getNextPte() == null ){
                            this.lastPte = null;
                        }
                        result = value;
                    } else if (this.currentPte.getInfo() == value) {
                        previewPte.setNextPte(this.currentPte.getNextPte());
                        temPte = this.currentPte;
                        if (this.currentPte == this.lastPte) {
                            this.lastPte.setPrevPte(null);
                            this.lastPte = this.currentPte = previewPte;
                        } else {
                            (this.currentPte.getNextPte()).setPrevPte(this.currentPte.getPrevPte());
                            this.currentPte = previewPte;
                            temPte.setPrevPte(null);
                            temPte.setNextPte(null);
//                        temPte = null;
                        }
                        result = value;
                    }

                    if (this.currentPte != null) {
                        this.currentPte = this.currentPte.getNextPte();
                        counTimes++;
                    }

                    if (counTimes > 1 && temPte == null) {
                        previewPte = previewPte.getNextPte();
                    }

                    if (temPte != null) {
                        temPte.setPrevPte(null);
                        temPte.setNextPte(null);
                    }
                }
                previewPte = null;
                temPte = null;
                return result;
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar un nodo especifico de la lista!...");
        }
    }

    
}
