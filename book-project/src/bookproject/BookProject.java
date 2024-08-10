package bookproject;

public class BookProject {
    public static void main(String[] args) {

        Person[] p = new Person[2];
        Book[] b = new Book[3];

        p[0] = new Person("Duda", 5, "F");
        p[1] = new Person("Joca", 4, "M");

        b[0] = new Book("Os 3 Porquinhos", "Joseph Jacobs", 24, p[1]);
        b[1] = new Book("Chapeuzinho Vermelho", "Charles Perrault", 30, p[0]);
        b[2] = new Book("O Patinho Feio", "Hans Christian Andersen", 35, p[1]);

        b[0].open();
        b[0].leafThrough(2);
        System.out.println(b[0].details());

    }
}
