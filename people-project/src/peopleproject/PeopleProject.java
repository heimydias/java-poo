package peopleproject;

public class PeopleProject {
    public static void main(String[] args) {

        Person p1 = new Person();
        Student p2 = new Student();
        Teacher p3 = new Teacher();
        Employee p4 = new Employee();

        p1.setName("Pedro");
        p2.setName("Maria");
        p3.setName("Claudio");
        p4.setName("Fabiana");

        p2.setAge(18);

        p1.setSex("M");
        p4.setSex("F");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());

        p2.setCourse("Informatica");
        p3.setSalary(2500.75f);
        p4.setSector("Estoque");

    }
}
