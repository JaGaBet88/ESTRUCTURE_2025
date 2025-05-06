package doublylinkedlists;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.DoubleList;

public class DoublyLinkedLists {

    private static Scanner scan = new Scanner(System.in);
    private static DoubleList ordinaryHourList = new DoubleList();
    private static DoubleList extraHourTypeList = new DoubleList();

    public static void main(String[] args) {
        captureEmployeeData(); //capturar datos de empleados
        calculateAndShowExtraHourValue(); //calcular y mostrar el valor de las horas extras
        findAndShowLowestOrdinaryHourValue(); //buscar y mostrar el valor de la hora ordinaria más baja
    }

    private static void captureEmployeeData() { //capturar datos de empleados
        char addMoreEmployee = 'S'; // Inicializamos en 'S'
        do {
            System.out.println("\nIngrese la información del empleado:");
            double monthlySalary = 0;
            try {
                System.out.print("Salario mensual: ");
                monthlySalary = scan.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un valor numérico para el salario.");
                scan.next();
                continue;
            }

            // Calcular el valor de la hora ordinaria
            double ordinaryHourValue = monthlySalary / 230;
            try {
                ordinaryHourList.headInsert((int) Math.round(ordinaryHourValue)); // Almacenar redondeado
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("¿Trabajó horas extras? (S/N): ");
            char workedExtraHours = scan.next().toUpperCase().charAt(0);
            int extraHourType = 0;

            if (workedExtraHours == 'S') {
                System.out.println("Tipo de hora extra:");
                System.out.println("1. Diurna");
                System.out.println("2. Nocturna");
                System.out.println("3. Dominical y/o festiva");
                try {
                    System.out.print("Seleccione el tipo (1-3): ");
                    extraHourType = scan.nextInt();
                    if (extraHourType < 0 || extraHourType > 3) {
                        System.out.println("Error: Por favor, ingrese un valor entre 0 y 3.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor, ingrese un número para el tipo de hora extra.");
                    scan.next();
                    continue;
                }
            } else if (workedExtraHours != 'N') {
                System.out.println("Error: Por favor, ingrese 'S' o 'N'.");
                continue;
            }
            try {
                extraHourTypeList.headInsert(extraHourType);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            boolean validInput = false;
            while (!validInput) {
                System.out.print("¿Desea ingresar otro empleado? (S/N): ");
                addMoreEmployee = scan.next().toUpperCase().charAt(0);
                if (addMoreEmployee == 'S' || addMoreEmployee == 'N') {
                    validInput = true;
                } else {
                    System.out.println("Error: Por favor, ingrese 'S' o 'N'.");
                }
            }

        } while (addMoreEmployee == 'S');
    }

    private static void calculateAndShowExtraHourValue() {
        System.out.println("\n--- Valor de las Horas Extras por Empleado ---");
        ordinaryHourList.resetIterator();
        extraHourTypeList.resetIterator();
        int employeeNumber = 1;
        Integer ordinaryHourValue, extraHourType;

        while ((ordinaryHourValue = ordinaryHourList.getNextValue()) != null &&
               (extraHourType = extraHourTypeList.getNextValue()) != null) {
            double extraHourValueCalculated = 0;
            String extraHourDescription = "no suele laborar horas extras";

            switch (extraHourType) {
                case 1:
                    extraHourValueCalculated = ordinaryHourValue * 1.25;
                    extraHourDescription = "suele laborar horas extras diurnas";
                    break;
                case 2:
                    extraHourValueCalculated = ordinaryHourValue * 1.35;
                    extraHourDescription = "suele laborar horas extras nocturnas";
                    break;
                case 3:
                    extraHourValueCalculated = ordinaryHourValue * 1.90;
                    extraHourDescription = "suele laborar horas extras dominicales y/o festivas";
                    break;
                case 0:
                    extraHourValueCalculated = 0;
                    break;
            }

            System.out.println("Empleado " + employeeNumber + " usted " + extraHourDescription + ", el valor de dicha hora es de $" + String.format("%.0f", extraHourValueCalculated));
            employeeNumber++;
        }
    }

    private static void findAndShowLowestOrdinaryHourValue() {
        try {
            Integer lowestOrdinaryHour = ordinaryHourList.findLowestValue();
            if (lowestOrdinaryHour != null) {
                System.out.println("\n--- Valor de la Hora Ordinaria Más Baja ---");
                System.out.println("El valor de la hora ordinaria más baja es de: $" + lowestOrdinaryHour);
            } else {
                System.out.println("\nNo se ingresaron empleados.");
            }
        } catch (Exception e) {
            System.out.println("Error al encontrar el valor más bajo: " + e.getMessage());
        }
    }
}
