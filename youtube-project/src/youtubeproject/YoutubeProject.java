package youtubeproject;

public class YoutubeProject {
    public static void main(String[] args) {

        Video v[] = new Video[3];

        v[0] = new Video("Aula 1 POO");
        v[1] = new Video("Aula 12 de PHP");
        v[2] = new Video("Aula 10 de HTML5");

        //System.out.println(v[0].toString());

        Locust l[] = new Locust[2];

        l[0] = new Locust("Jubileu", 22, "M", "juba");
        l[1] = new Locust("Maria", 19, "F", "mari");

        //System.out.println(l[0].toString());

        View vie[] = new View[2];

        vie [0] = new View(l[0], v[2]);
        vie[0].toAssess();
        System.out.println(vie[0].toString());

        vie [1] = new View(l[0], v[1]);
        vie[1].toAssess(87.0f);
        System.out.println(vie[1].toString());


    }
}