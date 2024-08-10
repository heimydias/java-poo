package aula07;

public class Lutador {

    private String nome;
    private  String nacionalidade;
    private Integer idade;
    private Float altura;
    private Float peso;
    private String categoria;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;

    public Lutador(String nome, String nacionalidade, Integer idade, Float altura, Float peso, Integer vitorias, Integer derrotas, Integer empates) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.setPeso(peso);
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (peso < 52.2) {
            categoria = "Inválido";
        } else if (peso <= 70.3) {
            categoria = "Leve";
        } else if (peso <= 83.9) {
            categoria = "Médio";
        } else if (peso <= 120.2) {
            categoria = "pesado";
        } else {
            categoria = "Inválido";
        }
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public void apresentar() {
        System.out.println("--------------------------------------------------");
        System.out.println("Chegou a hora! Apresentamos o lutador " + getNome());
        System.out.println("Diretamente de " + getNacionalidade());
        System.out.println("com " + this.getIdade() + " anos e " + getAltura() + " metros.");
        System.out.println("pesando " + getPeso() + "Kg");
        System.out.println(getVitorias() + " Vitórias");
        System.out.println(getDerrotas() + " Derrotas e ");
        System.out.println(getEmpates() + " Empates");
    }

    public void status() {
        System.out.println(getNome() + " é um peso " + getCategoria());
        System.out.println("Ganhou " + getVitorias() + " vezes");
        System.out.println("Perdeu " + getDerrotas() + " vezes");
        System.out.println("Empatou" + getEmpates() + " vezes");
    }

    public void ganharLuta() {
        this.setVitorias(this.getVitorias()+1);
    }

    public void perderLuta() {
        this.setDerrotas(this.getDerrotas()+1);
    }

    public void empatarLuta() {
        this.setEmpates(this.getEmpates()+1);
    }

}
