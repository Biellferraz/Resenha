package com.resenha.projetoresenha.dominio;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Quadra {

    // Atributos da Entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "modalidade")
    private String modalidade;

    @Min(1)
    @Column(name = "numero_quadra")
    private Integer numero_quadra;

    @Column(name = "disponivel")
    private Integer disponivel;

    @Column(name = "fk_centro_esportivo")
    private Integer fkCentroEsportivo;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "imagem")
    private String imagem;

    // Construtores
    // Sobrescrita de Construtores para evidenciar para o Spring qual o Construtor Default
    public Quadra() {
    }

    public Quadra(Integer id,
                  String modalidade,
                  Integer numero_quadra,
                  Integer disponivel,
                  Integer fkCentroEsportivo) {
        this.id = id;
        this.modalidade = modalidade;
        this.numero_quadra = numero_quadra;
        this.disponivel = disponivel;
        this.fkCentroEsportivo = fkCentroEsportivo;
    }


    // Getters & Setters
    public Integer getFkCentroEsportivo() {
        return fkCentroEsportivo;
    }

    public void setFkCentroEsportivo(Integer fkCentroEsportivo) {
        this.fkCentroEsportivo = fkCentroEsportivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Integer getNumero_quadra() {
        return numero_quadra;
    }

    public void setNumero_quadra(Integer numero_quadra) {
        this.numero_quadra = numero_quadra;
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "id=" + id +
                ", modalidade='" + modalidade + '\'' +
                ", numeroQuadra=" + numero_quadra +
                ", disponivel=" + disponivel +
                '}';
    }
}
