package peopleproject;

public class Person {

    private String name;
    private int age;
    private String sex;

    public void haveBirthday() {
        age++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person:" +
                " name= " + name +
                ", age= " + age +
                ", sex= " + sex;
    }
}
