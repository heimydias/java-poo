package peopleproject;

public class Teacher extends Person {

    private String specialty;
    private float salary;

    public void receiveRaise(float raise) {
        salary+=raise;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
