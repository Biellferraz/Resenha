package com.resenha.projetoresenha.resposta;

import com.resenha.projetoresenha.dominio.Agendamento;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoResponse {

    // Atributos & variáveis do DTO
    private Integer id;

    @NotNull
    private Integer fkQuadra;

    @NotNull
    private Integer fk_Jogador;

    @NotNull
    private Double preco;

    @NotNull
    private String hora_Marcada;

    // Construtor
    public AgendamentoResponse(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.fkQuadra = agendamento.getFkQuadra();
        this.fk_Jogador = agendamento.getFk_Jogador();
        this.preco = agendamento.getPreco();
        this.hora_Marcada = agendamento.getHora_Marcada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public Integer getFkQuadra() {
        return fkQuadra;
    }

    public Integer getFk_Jogador() {
        return fk_Jogador;
    }

    public Double getPreco() {
        return preco;
    }

    public String getHora_Marcada() {
        return hora_Marcada;
    }
}
