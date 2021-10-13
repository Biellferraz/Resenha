package ListaAgendamento;

import java.time.LocalDateTime;
import java.util.Date;

public class Agendamento {

    private Integer idJogador;
    private Integer idQuadra;
    private Double preco;
    private String horaDisponivel;

    public Agendamento(Integer idJogador, Integer idQuadra, Double preco, String horaDisponivel) {
        this.idJogador = idJogador;
        this.idQuadra = idQuadra;
        this.preco = preco;
        this.horaDisponivel = horaDisponivel;
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

    public String getHoraDisponivel() {
        return horaDisponivel;
    }

    @Override
    public String toString() {
        return "\nListaAgendamento.Agendamento: " +
                " idJogador=" + idJogador +
                ", idQuadra=" + idQuadra +
                ", preco=" + preco +
                ", horaDisponivel=" + horaDisponivel +
                '\n';
    }
}
