package com.resenha.projetoresenha.dominio;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fk_Quadra")
    private Integer fkQuadra;

    @NotNull
    @Column(name = "fk_Jogador")
    private Integer fk_Jogador;

    @NotNull
    @Column(name = "preco")
    private Double preco;

    @Future
    @NotNull
    @Column(name = "hora_Marcada")
    private LocalDateTime hora_Marcada;

    public Agendamento(){

    }

    public Agendamento(Integer id, Integer idJogador, Integer idQuadra, Double preco, LocalDateTime horaMarcada) {
        this.id = id;
        this.fkQuadra = idQuadra;
        this.fk_Jogador = idJogador;
        this.preco = preco;
        this.hora_Marcada = horaMarcada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkQuadra() {
        return fkQuadra;
    }

    public void setFkQuadra(Integer fkQuadra) {
        this.fkQuadra = fkQuadra;
    }

    public Integer getFk_Jogador() {
        return fk_Jogador;
    }

    public void setFk_Jogador(Integer fk_Jogador) {
        this.fk_Jogador = fk_Jogador;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getHora_Marcada() {
        return hora_Marcada;
    }

    public void setHora_Marcada(LocalDateTime hora_Marcada) {
        this.hora_Marcada = hora_Marcada;
    }

    @Override
    public String toString() {
        return "\nAgendamento: " +
                " id=" + id +
                ", idQuadra=" + fkQuadra +
                ", idJogador=" + fk_Jogador +
                ", preço=" + preco +
                ", hora Marcada=" + hora_Marcada +
                '\n';
    }
}
