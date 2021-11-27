package com.resenha.projetoresenha.dominio;

import javax.persistence.*;

@Entity
public class Quadra {

    // Atributos da Entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "numero_quadra")
    private Integer numero_quadra;

    @Column(name = "disponivel")
    private Integer disponivel;

    @Column(name = "fk_centro_esportivo")
    private Integer fk_centro_esportivo;

    // Construtores
    // Sobrescrita de Construtores para evidenciar para o Spring qual o Construtor Default
    public Quadra() {
    }

    public Quadra(Integer id,
                  String modalidade,
                  Integer numero_quadra,
                  Integer disponivel,
                  Integer fk_centro_esportivo) {
        super();
        this.id = id;
        this.modalidade = modalidade;
        this.numero_quadra = numero_quadra;
        this.disponivel = disponivel;
        this.fk_centro_esportivo = fk_centro_esportivo;
    }


    // Getters & Setters
    public Integer getFk_centro_esportivo() {
        return fk_centro_esportivo;
    }

    public void setFk_centro_esportivo(Integer fk_centro_esportivo) {
        this.fk_centro_esportivo = fk_centro_esportivo;
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
