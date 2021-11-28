package com.resenha.projetoresenha.dominio;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Locatario {

    // Atributos da Entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    @Column(name = "sobrenome")
    private String sobrenome;

    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 6)
    @Column(name = "senha")
    private String senha;

    @Size(min = 14, max = 14)
    @Column(name = "cpf")
    private String cpf;

    @NotNull
    @Size(min = 15, max = 15)
    @Column(name = "telefone")
    private String telefone;

    @Past
    @Column(name = "data_nasc")
    private LocalDate data_nasc;

    // Getters & Setters
    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
