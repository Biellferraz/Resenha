package com.resenha.projetoresenha.dominio;

public class QuadraCentroEsportivoResponse {

    public Integer getId() {
        return id;
    }

    public String getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public CentroEsportivo getCentroEsportivo() {
        return centroEsportivo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setCentroEsportivo(CentroEsportivo centroEsportivo) {
        this.centroEsportivo = centroEsportivo;
    }

    private Integer id = 0;
    private String imagem = "";
    private String nome = "";
    private Double preco = 0.0;
    private CentroEsportivo centroEsportivo = null;

}
