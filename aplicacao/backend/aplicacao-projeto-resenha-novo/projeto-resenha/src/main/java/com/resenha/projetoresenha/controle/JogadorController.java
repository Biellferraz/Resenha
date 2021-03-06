package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Jogador;
import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.dominio.Login;
import com.resenha.projetoresenha.repositorio.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorRepository repository;

    @GetMapping
    public ResponseEntity getUsuarios() {
        List<Jogador> locatarios = repository.findAll();
        if (locatarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(locatarios);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity postCadastrar(@RequestBody @Valid Jogador novoJogador) {
        repository.save(novoJogador);
        return ResponseEntity.status(201).body(novoJogador);
    }

    @PostMapping("/login")
    public ResponseEntity postLogin(@RequestBody Jogador jogadorInserido) {
        Jogador jogadorEncontrado = repository.findByEmailAndSenha(jogadorInserido.getEmail(),
                jogadorInserido.getSenha());
        System.out.println(jogadorInserido.getEmail() + jogadorInserido.getSenha());

        if (jogadorEncontrado == null) {
            return ResponseEntity.status(403).build();
        }

//        return ResponseEntity.status(200).body(jogadorEncontrado).getHeaders().jogador;
        return ResponseEntity.status(200).header(jogadorEncontrado.getId().toString()).body(jogadorEncontrado);

    }


    @GetMapping("/buscarIdPorLogin")
    public ResponseEntity getIdUsuariosPorLogin(@PathVariable String email, String senha) {
        Jogador jogadorEncontrado = repository.findByEmailAndSenha(email, senha);
        if (jogadorEncontrado == null) {
            return ResponseEntity.status(403).build();
        }

        return ResponseEntity.status(200).body(jogadorEncontrado);

    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuarios(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));

    }

  /*  @GetMapping("/buscar")
    public ResponseEntity loginApp(@RequestBody Login login) {
        Jogador usuario = repository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(usuario);

    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuarios(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
