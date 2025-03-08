package views;

import models.ServiceProvision;
import models.Undefined;
import controllers.ContractController;
import java.util.Scanner;

// Vista - Interacción con el usuario
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContractController controller = new ContractController(10);
        
        System.out.println("Ingrese tipo de contrato (1 - Prestación de servicios, 2 - Indefinido): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Número de contrato: ");
        String nro = scanner.nextLine();
        System.out.println("Fecha: ");
        String date = scanner.nextLine();
        
        if (type == 1) {
            System.out.println("Fecha de finalización: ");
            String finishDate = scanner.nextLine();
            System.out.println("Ocupación: ");
            String occupation = scanner.nextLine();
            System.out.println("Valor por hora: ");
            double hourValue = scanner.nextDouble();
            System.out.println("Número de horas al mes: ");
            int hourNumber = scanner.nextInt();
            
            ServiceProvision sp = new ServiceProvision(nro, date, finishDate, occupation);
            System.out.println("Salario mensual: " + sp.monthSalary(hourValue, hourNumber));
            controller.addContract(sp);
        } else {
            System.out.println("Nombre del trabajo: ");
            String jobName = scanner.nextLine();
            System.out.println("Descripción del trabajo: ");
            String jobDescription = scanner.nextLine();
            
            Undefined undef = new Undefined(nro, date, jobName, jobDescription);
            controller.addContract(undef);
        }
        
        System.out.println("\nLista de contratos registrados:");
        controller.listContracts();
    }
}