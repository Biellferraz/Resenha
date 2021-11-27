package com.resenha.projetoresenha.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fk_Quadra")
    private Integer fk_Quadra;

    @Column(name = "fk_Jogador")
    private Integer fk_Jogador;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "hora_Marcada")
    private LocalDateTime hora_Marcada;

    public Agendamento(){

    }

    public Agendamento(Integer id, Integer idJogador, Integer idQuadra, Double preco, LocalDateTime horaMarcada) {
        this.id = id;
        this.fk_Quadra = idQuadra;
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

    public Integer getFk_Quadra() {
        return fk_Quadra;
    }

    public void setFk_Quadra(Integer fk_Quadra) {
        this.fk_Quadra = fk_Quadra;
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
                ", idQuadra=" + fk_Quadra +
                ", idJogador=" + fk_Jogador +
                ", preço=" + preco +
                ", hora Marcada=" + hora_Marcada +
                '\n';
    }
}
