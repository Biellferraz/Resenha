package com.resenha.projetoresenha.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjogador", nullable = false)
    private Integer id;

    @Size(min = 14, max = 14)
    @Column(name = "cpf")
    private String cpf;

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

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "datanasc")
    private LocalDate data_nasc;


    @Size(min = 8, max = 9)
    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Size(min = 15, max = 15)
    @Column(name = "telefone")
    private String telefone;

    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 6)
    @Column(name = "senha")
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
}
