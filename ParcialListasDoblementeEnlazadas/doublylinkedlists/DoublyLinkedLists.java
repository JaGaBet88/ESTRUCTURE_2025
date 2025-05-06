package doublylinkedlists;

import java.util.Scanner;
import controller.DoubleList;
import model.Node;

public class DoublyLinkedLists {

    private static Scanner scan = new Scanner(System.in);
    private static DoubleList ordinaryHourList = new DoubleList();
    private static DoubleList extraHourTypeList = new DoubleList();

    public static void main(String[] args) {
        captureEmployeeData();
        calculateAndShowExtraHourValue();
        findAndShowLowestOrdinaryHourValue();
    }

    private static void captureEmployeeData() {
        char addMoreEmployee;
        do {
            System.out.println("\nIngrese la información del empleado:");
            System.out.print("Salario mensual: ");
            double monthlySalary = scan.nextDouble();

            // Calcular el valor de la hora ordinaria
            double ordinaryHourValue = monthlySalary / 230;
            ordinaryHourList.headInsert((int) Math.round(ordinaryHourValue)); // Almacenar el valor redondeado

            System.out.print("¿Trabajó horas extras? (S/N): ");
            char workedExtraHours = scan.next().toUpperCase().charAt(0);
            int extraHourType = 0;

            if (workedExtraHours == 'S') {
                System.out.println("Tipo de hora extra:");
                System.out.println("1. Diurna");
                System.out.println("2. Nocturna");
                System.out.println("3. Dominical y/o festiva");
                System.out.print("Seleccione el tipo (1-3): ");
                extraHourType = scan.nextInt();
            }
            extraHourTypeList.headInsert(extraHourType);

            do {
                System.out.print("¿Desea ingresar otro empleado? (S/N): ");
                addMoreEmployee = scan.next().toUpperCase().charAt(0);
            } while (addMoreEmployee != 'S' && addMoreEmployee != 'N');

        } while (addMoreEmployee == 'S');
    }

    private static void calculateAndShowExtraHourValue() {
        System.out.println("\n--- Valor de las Horas Extras por Empleado ---");
        Node ordinaryHourNode = ordinaryHourList.getFirstPte();
        Node extraHourTypeNode = extraHourTypeList.getFirstPte();
        int employeeNumber = 1;

        while (ordinaryHourNode != null && extraHourTypeNode != null) {
            int ordinaryHourValue = ordinaryHourNode.getInfo();
            int extraHourType = extraHourTypeNode.getInfo();
            double extraHourValue = 0;
            String extraHourDescription = "no suele laborar horas extras";

            switch (extraHourType) {
                case 1:
                    extraHourValue = ordinaryHourValue * 1.25;
                    extraHourDescription = "suele laborar horas extras diurnas";
                    break;
                case 2:
                    extraHourValue = ordinaryHourValue * 1.35;
                    extraHourDescription = "suele laborar horas extras nocturnas";
                    break;
                case 3:
                    extraHourValue = ordinaryHourValue * 1.90;
                    extraHourDescription = "suele laborar horas extras dominicales y/o festivas";
                    break;
                case 0:
                    extraHourValue = 0;
                    break;
            }

            System.out.println("Empleado " + employeeNumber + " usted " + extraHourDescription + ", el valor de dicha hora es de $" + String.format("%.0f", extraHourValue));

            ordinaryHourNode = ordinaryHourList.getNextNode(ordinaryHourNode);
            extraHourTypeNode = extraHourTypeList.getNextNode(extraHourTypeNode);
            employeeNumber++;
        }
    }

    private static void findAndShowLowestOrdinaryHourValue() {
        if (ordinaryHourList.getFirstPte() == null) {
            System.out.println("\nNo se ingresaron empleados.");
            return;
        }

        int lowestOrdinaryHour = Integer.MAX_VALUE;
        Node current = ordinaryHourList.getFirstPte();

        while (current != null) {
            if (current.getInfo() < lowestOrdinaryHour) {
                lowestOrdinaryHour = current.getInfo();
            }
            current = ordinaryHourList.getNextNode(current);
        }

        System.out.println("\n--- Valor de la Hora Ordinaria Más Baja ---");
        System.out.println("El valor de la hora ordinaria más baja es de: $" + lowestOrdinaryHour);
    }
}
