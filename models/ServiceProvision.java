package models;

public class ServiceProvision extends Contract {
    private String finishDate;
    private String occupation;

    public ServiceProvision(String numContract, String date, String finishDate, String occupation) {
        super(numContract, date);
        this.finishDate = finishDate;
        this.occupation = occupation;
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
    public String search() {
        return "Contrato de prestación de servicios: " + numContract; // Simulación de búsqueda
    }
    
}
