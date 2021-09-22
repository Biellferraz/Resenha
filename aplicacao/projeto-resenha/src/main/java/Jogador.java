public class Jogador extends Usuario{
    private Integer qtdHora;
    private Double valorHora;

    public Jogador(String nome, String login, String senha, Integer qtdHora, Double valorHora) {
        super(nome, login, senha);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    public Double totalPagamento(){
        return qtdHora * valorHora;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "qtdHora=" + qtdHora +
                ", valorHora=" + valorHora +
                "} " + super.toString();
    }
}
