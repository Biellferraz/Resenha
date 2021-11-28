package com.resenha.projetoresenha.dominio;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class CentroEsportivo {

    // Atributos da Entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Pattern(regexp = "\\d{2}(.\\d{3})(.\\d{3})(/\\d{4})(-\\d{2})?",
            message = "Digite um CNPJ válido")
    @Column(name = "cnpj")
    private String cnpj;

    @Size(min = 8, max = 8)
    @Column(name = "cep")
    private String cep;

    @Min(1)
    @Column(name = "numero")
    private Integer numero;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "nome")
    private String nome;

    @Column(name = "horaAbre")
    private String horaAbre;

    @Column(name = "horaFecha")
    private String horaFecha;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "fk_locatario")
    private Integer fk_locatario;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 40)
    @Column(name = "cidade")
    private String cidade;

    // Construtor
    // Sobrescrita de Construtores para evidenciar para o Spring qual o Construtor Default
    public CentroEsportivo() {
    }

    public CentroEsportivo(Integer id, String cnpj, String cep, Integer numero, String cidade, String nome,
                           String horaAbre, String horaFecha, String telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.nome = nome;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
        this.telefone = telefone;
    }

    // Getters & Setters
    public Integer getFk_locatario() {
        return fk_locatario;
    }

    public void setFk_locatario(Integer fk_locatario) {
        this.fk_locatario = fk_locatario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoraAbre() {
        return horaAbre;
    }

    public void setHoraAbre(String horaAbre) {
        this.horaAbre = horaAbre;
    }

    public String getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(String horaFecha) {
        this.horaFecha = horaFecha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\nCentroEsportivo: " +
                " id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", horaAbre='" + horaAbre + '\'' +
                ", horaFecha='" + horaFecha + '\'' +
                ", telefone='" + telefone + '\'' +
                '\n';
    }
}
