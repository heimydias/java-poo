package aula12.animais;

import aula12.Mamifero;

public class Canguru extends Mamifero {

    @Override
    public void locomover() {
        System.out.println("Saltandp");
    }

    public void usarBolsa() {
        System.out.println("Usando Bolsa");
    }
}
