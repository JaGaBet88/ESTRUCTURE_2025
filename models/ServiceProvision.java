package models;

public class ServiceProvision extends Contract {
    private String finishDate;
    private String ocupation;

    public ServiceProvision(String numContract, String date, String finishDate, String ocupation) {
        super(numContract, date);
        this.finishDate = finishDate;
        this.ocupation = ocupation;
    }

    public double monthSalary(double hourValue, int hours) {
        double salary = hourValue * hours;
        return salary * 0.75; // Descuento del 25%
    }

    @Override
    public boolean register() {
        return true; // Simulación de registro
    }
    
    @Override
    public boolean search() {
        return true; // Simulación de búsqueda
    }
    
}
