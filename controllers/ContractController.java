package controllers;

import models.Contract;

// Controlador para manejar los contratos
public class ContractController {
    private Contract[] contracts;
    private int count;
    
    public ContractController(int size) {
        contracts = new Contract[size];
        count = 0;
    }
    
    public void addContract(Contract contract) {
        if (count < contracts.length) {
            contracts[count++] = contract;
        } else {
            System.out.println("No hay espacio para más contratos.");
        }
    }
    
    public void listContracts() {
        for (int i = 0; i < count; i++) {
            System.out.println(contracts[i].search());
        }
    }
}