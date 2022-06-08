package com.resenha.projetoresenha.requisicao;

import java.time.LocalDateTime;

public class AgendamentoRequisicao {
    Integer idQuadra;
    Integer idJogador;
    Double preco;
    LocalDateTime data;

    public Integer getIdQuadra() {
        return idQuadra;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public Double getPreco() {
        return preco;
    }

    public LocalDateTime getData() {
        return data;
    }
}
