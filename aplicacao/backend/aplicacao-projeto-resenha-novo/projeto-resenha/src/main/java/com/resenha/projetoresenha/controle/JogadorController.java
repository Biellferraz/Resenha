package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Jogador;
import com.resenha.projetoresenha.repositorio.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@CrossOrigin
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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Jogador jogadorInserido) {
        Jogador jogadorEncontrado = repository.findByEmailAndSenha(jogadorInserido.getEmail(),
                jogadorInserido.getSenha());
        System.out.println(jogadorInserido.getEmail() + jogadorInserido.getSenha());

        if (jogadorEncontrado == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(jogadorEncontrado);

    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuarios(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuarios(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
