package ListaAgendamento;

public class Agendamento {

    private Integer idJogador;
    private Integer idQuadra;
    private Double preco;
    private String horaMarcada;

    public Agendamento(Integer idJogador, Integer idQuadra, Double preco, String horaMarcada) {
        this.idJogador = idJogador;
        this.idQuadra = idQuadra;
        this.preco = preco;
        this.horaMarcada = horaMarcada;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public Integer getIdQuadra() {
        return idQuadra;
    }

    public Double getPreco() {
        return preco;
    }

    public String getHoraMarcada() {
        return horaMarcada;
    }

    @Override
    public String toString() {
        return "\nAgendamento: " +
                " idJogador=" + idJogador +
                ", idQuadra=" + idQuadra +
                ", preco=" + preco +
                ", horaDisponivel=" + horaMarcada +
                '\n';
    }
}
