package aula02;

public class Aula02 {

    public static void main(String[] args) {

        Caneta02 c1 = new Caneta02();

        c1.modelo = "Cis";
        c1.cor = "Azul";
        c1.ponta = 0.5f;
        c1.carga = 90;
        c1.tampar();

        c1.status();
        c1.rabiscar();

        Caneta02 c2 = new Caneta02();

        c2.modelo = "Bic";
        c2.cor = "Preta";
        c2.ponta = 0.8f;
        c2.carga = 50;
        c2.destampar();

        c2.status();
        c2.rabiscar();


    }

}
