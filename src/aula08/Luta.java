package aula08;

import java.util.Objects;
import java.util.Random;

public class Luta {

    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(Lutador l1, Lutador l2) {
        if (Objects.equals(l1.getCategoria(), l2.getCategoria()) && l1 != l2) {
            aprovada = true;
            desafiado = l1;
            desafiante = l2;
        } else {
            System.out.println("A luta nao pode acontecer!");
        }
    }

    public void lutar() {
        if (aprovada) {
            System.out.println("### DESAFIADO ###");
            desafiado.apresentar();
            System.out.println("\n### DESAFIANTE ###");
            desafiante.apresentar();
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);
            System.out.println("\n=== RESULTADO DA LUTA ===");
            switch (vencedor) {
                case 0: {
                    System.out.println("Empatou!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                }
                case 1: {
                    System.out.println("Vitoria do " + desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;
                }
                case 3: {
                    System.out.println("Vitoria do " + desafiante.getNome());
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
                }
            }
            System.out.println("=========================");
        } else {

        }
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}
