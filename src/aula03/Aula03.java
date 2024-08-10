package aula03;

public class Aula03 {

    public static void main(String[] args) {

        Caneta03 c1 = new Caneta03();
        c1.modelo = "Bic cristal";
        c1.cor = "Azul";
        c1.carga = 80;
        //c1.tampada = false;
        c1.tampar();
        c1.status();
        c1.rabiscar();


    }

}
