package models;

public class Job {
    private String name;
    private String description;
    
    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getJobInfo() {
        return name + ": " + description;
    }
}
