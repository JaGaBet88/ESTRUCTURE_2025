package doublylinkedlists;

import java.util.Scanner;
import controller.DoubleList;

public class DoublyLinkedLists {

    private static Scanner scan = new Scanner(System.in);

    private static DoubleList objDoubleList = new DoubleList();

    public static void main(String[] args) {

        headInsert();

    }

    private static void headInsert() {
        char sw;
        int age;
        System.out.println("\n");

        do {
            System.out.println("Ingrese una edad: ");
            age = scan.nextInt();

            try {
                if (objDoubleList.headInsert(age)) {
                    System.out.println("Edad ingresada correctamente! ...");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.println("Desea ingresar otra edad S para Si o N para No :");
                sw = scan.next().toUpperCase().charAt(0);
            } while (sw != 'S' && sw != 'N');

        } while (sw == 'S');
    }
}
