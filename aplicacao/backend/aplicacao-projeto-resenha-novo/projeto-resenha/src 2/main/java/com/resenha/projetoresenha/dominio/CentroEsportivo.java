package com.resenha.projetoresenha.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CentroEsportivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCentroEsportivo;

    private String cnpj;
    private String cep;
    private String cidade;
    private Integer numero;
    private String nome;
    private String horaAbre;
    private String horaFecha;
    private String telefone;

    public CentroEsportivo(Integer idCentroEsportivo, String cnpj, String cep, Integer numero, String cidade, String nome,
                           String horaAbre, String horaFecha, String telefone) {
        this.idCentroEsportivo = idCentroEsportivo;
        this.cnpj = cnpj;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.nome = nome;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
        this.telefone = telefone;
    }

    public Integer getIdCentroEsportivo() {
        return idCentroEsportivo;
    }

    public void setIdCentroEsportivo(Integer idCentroEsportivo) {
        this.idCentroEsportivo = idCentroEsportivo;
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
                " idCentroEsportivo=" + idCentroEsportivo +
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
