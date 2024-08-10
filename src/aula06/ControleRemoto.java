package aula06;

public class ControleRemoto implements Controlador{

    private Integer volume;
    private boolean ligado;
    private boolean tocando;

    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    @Override
    public void ligar() {
        setLigado(true);
    }

    @Override
    public void desligar() {
        setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("----- MENU -----");
        System.out.println("Esta ligado? " + isLigado());
        System.out.println("Esta tocando? " + isTocando());
        System.out.print("Volume: " + getVolume());
        for (int i=0; i<=getVolume(); i+=10) {
            System.out.print("|");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (isLigado()) {
            setVolume(getVolume()+5);
        } else {
            System.out.println("Impossível aumentar volume!");
        }
    }

    @Override
    public void menosVolume() {
        if (isLigado()) {
            setVolume(getVolume()-5);
        } else {
            System.out.println("Impossível diminuir volume!");
        }
    }

    @Override
    public void ligarMudo() {
        if (isLigado() && getVolume() > 0) {
            setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (isLigado() && getVolume() == 0) {
            setVolume(50);
        }
    }

    @Override
    public void play() {
        if (isLigado() && !isTocando()) {
            setTocando(true);
        } else {
            System.out.println("Não consegui reproduzir!");
        }
    }

    @Override
    public void pause() {
        if (isLigado() && isTocando()) {
            setTocando(false);
        } else {
            System.out.println("Não consegui pausar!");
        }
    }
}
