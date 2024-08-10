package schoolproject;

public class ScholarshipHolder extends Student {

    private float scholarship;

    public void renewScholarship() {
        System.out.println("Renovando bolsa de " + getName());
    }

    @Override
    public void monthlyPaymentn() {
        System.out.println(getName() + " e bolsista! Pagamento facilitado!");
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }
}
