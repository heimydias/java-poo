package peopleproject;

public class Employee extends Person {

    private String sector;
    private Boolean working;

    public void changeWork() {
        working = !working;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Boolean getWorking() {
        return working;
    }

    public void setWorking(Boolean working) {
        this.working = working;
    }
}
