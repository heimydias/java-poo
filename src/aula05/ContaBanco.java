package aula05;

import java.util.Objects;

public class ContaBanco {

    public Integer numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String t) {
        setTipo(t);
        setStatus(true);
        if (Objects.equals(getTipo(), "CC")) {
            setSaldo(50);
        } else if (Objects.equals(getTipo(), "CP")) {
            setSaldo(150);
        }
    }

    public void fecharConta() {
        if (getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada pois ainda há saldo.");
        } else if (getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois ainda há débitos.");
        } else {
            setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float v) {
        if (isStatus()) {
            setSaldo(getSaldo() + v);
            System.out.println("Déposito realizado na conta de " + getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada!");
        }
    }

    public void sacar(float v) {
        if (isStatus()) {
            if (getSaldo() >= v) {
                setSaldo(getSaldo() - v);
                System.out.println("Saque realizado na conta de " + getDono());
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada!");
        }
    }

    public void pagarMensal() {
        int v = 0;
        if (Objects.equals(getTipo(), "CC")) {
            v = 12;
        } else if (Objects.equals(getTipo(), "CP")){
            v = 20;
        }
        if (isStatus()) {
            setSaldo(getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada!");
        }
    }

    public void atualStatus() {
        System.out.println("____________________________");
        System.out.println("Conta: " + getNumConta());
        System.out.println("Dono: " + getDono());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Status: " + isStatus());
    }
}
