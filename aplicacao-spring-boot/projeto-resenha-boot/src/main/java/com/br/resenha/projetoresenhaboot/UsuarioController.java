package com.br.resenha.projetoresenhaboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("resenha/")
public class UsuarioController {
    List<Usuario> listaUsuarios = new ArrayList<>();

    @GetMapping("cadastrar-locatario/{login}/{email}/{senha}")
    public String cadastrarLocatario(@PathVariable String login,
                                     @PathVariable String email,
                                     @PathVariable String senha){
        listaUsuarios.add(new Usuario(login, email, senha));
        return String.format("Locatário %s cadastrado com sucesso!", login);
    }

    @GetMapping("cadastrar-jogador/{login}/{email}/{senha}")
    public String cadastrarJogador(@PathVariable String login,
                                   @PathVariable String email,
                                   @PathVariable String senha){
        listaUsuarios.add(new Usuario(login, email, senha));
        return String.format("Jogador %s cadastrado com sucesso!", login);
    }
    @GetMapping("exibir-lista")
    public List<Usuario> listar(){
        if (listaUsuarios.isEmpty()){
            return null;
        }
        else {
            return listaUsuarios.stream()
                    .collect(Collectors.toList());
        }

    }
    @GetMapping("entrar/{login}/{senha}")
    public String entrar(@PathVariable String login,
                         @PathVariable String senha){
        List<Usuario> usuariosCadastrados = listaUsuarios.stream()
                .filter((usuario) -> usuario.verificar(login, senha))
                .collect(Collectors.toList());
        if (usuariosCadastrados.isEmpty()){
         return "Usuario não cadastrado";
        }
        else {
            Usuario usuario = usuariosCadastrados.get(0);
            return String.format("Seja bem-vindo %s!", usuario.getLogin());
        }
    }
    @GetMapping("sair/{login}")
    public String sair(@PathVariable String login){
        List<Usuario> usuariosCadastrados = listaUsuarios.stream()
                .filter((usuario) -> usuario.getLogin().equals(login) && usuario.isLogado())
                .collect(Collectors.toList());

        if (usuariosCadastrados.isEmpty()) {
            return String.format("Usuario %s não está cadastrado!", login);
        } else {
            Usuario usuario = usuariosCadastrados.get(0);
            usuario.sair();
            return String.format("Até mais!, %s", usuario.getLogin());
        }
    }

}


