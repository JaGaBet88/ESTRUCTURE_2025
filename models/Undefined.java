package models;

// Clase Undefined (Contrato indefinido)
public class Undefined extends Contract {
    private Job job; // Composición
    
    public Undefined(String nroContract, String date, String jobName, String jobDescription) {
        super(nroContract, date);
        this.job = new Job(jobName, jobDescription);
    }
    
    @Override
    public boolean register() {
        return true;
    }
    
    @Override
    public String search() {
        return "Contrato indefinido: " + numContract + " - " + job.getJobInfo() + " con fecha: " + date;
    }
}