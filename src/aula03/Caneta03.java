package aula03;

public class Caneta03 {

    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tampada;

    public void status() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga + "%");
        System.out.println("Está tampada? " + this.tampada);
    }

    public void escrever() {

    }

    public void rabiscar() {
        if (this.tampada == true) {
            System.out.println("Não posso rabiscar! \n");
        } else {
            System.out.println("Estou rabiscando! \n");
        }
    }

    public void pintar() {

    }
    public void tampar() {
        this.tampada = true;
    }

    public void destampar() {
        this.tampada = false;
    }
}
