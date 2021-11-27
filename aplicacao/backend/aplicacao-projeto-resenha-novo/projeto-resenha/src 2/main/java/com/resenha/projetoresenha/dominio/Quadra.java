package com.resenha.projetoresenha.dominio;

public class Quadra {

    private Integer idQuadra;
    private String modalidade;
    private Integer numeroQuadra;
    private Boolean disponivel;

    public Quadra(Integer idQuadra, String modalidade, Integer numeroQuadra, Boolean disponivel) {
        this.idQuadra = idQuadra;
        this.modalidade = modalidade;
        this.numeroQuadra = numeroQuadra;
        this.disponivel = disponivel;
    }

    public Integer getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(Integer idQuadra) {
        this.idQuadra = idQuadra;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Integer getNumeroQuadra() {
        return numeroQuadra;
    }

    public void setNumeroQuadra(Integer numeroQuadra) {
        this.numeroQuadra = numeroQuadra;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "idQuadra=" + idQuadra +
                ", modalidade='" + modalidade + '\'' +
                ", numeroQuadra=" + numeroQuadra +
                ", disponivel=" + disponivel +
                '}';
    }
}
