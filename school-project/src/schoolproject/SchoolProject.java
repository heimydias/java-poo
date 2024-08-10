package schoolproject;

public class SchoolProject {
    public static void main(String[] args) {

        Visitor v1 = new Visitor();
        v1.setName("Juvenal");
        v1.setAge(22);
        v1.setSex("M");

        Student s1 = new Student();
        s1.setName("Claudio");
        s1.setRegistration(111);
        s1.setCourse("Informatica");
        s1.setAge(16);
        s1.setSex("M");
        s1.monthlyPaymentn();

        ScholarshipHolder h1 = new ScholarshipHolder();
        h1.setRegistration(112);
        h1.setName("Jubileu");
        h1.setScholarship(12.5f);
        h1.setSex("M");
        h1.monthlyPaymentn();
    }
}
