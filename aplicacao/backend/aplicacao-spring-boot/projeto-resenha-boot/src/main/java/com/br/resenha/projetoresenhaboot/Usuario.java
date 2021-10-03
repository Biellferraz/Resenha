package com.br.resenha.projetoresenhaboot;

public class Usuario {
    private String login;
    private String email;
    private String senha;
    private boolean logado;

    public Usuario(String login, String email, String senha) {
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    protected String getSenha() {
        return senha;
    }

    public boolean isLogado(){
        return logado;
    }
    public Boolean verificar(String login, String senha){
        if(this.login.equals(login) && this.senha.equals(senha)) {
            this.logado = true;
            return true;
        } else{
            return false;
        }
    }
    public void sair(){
        this.logado = false;
    }

}
