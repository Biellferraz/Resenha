package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.repositorio.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatarios")
public class LocatarioController {

    @Autowired
    private LocatarioRepository repository;

    @GetMapping
    public ResponseEntity getUsuarios() {
        List<Locatario> locatarios = repository.findAll();
        if (locatarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(locatarios);
    }

    @PostMapping
    public ResponseEntity postUsuarios(@RequestBody Locatario novoLocatario) {
        repository.save(novoLocatario);
        return ResponseEntity.status(201).build();
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

    @PutMapping("/{id}")
    public ResponseEntity putUsuarios(@PathVariable int id,
                                      @RequestBody Locatario locatarioAlterado) {
        if (repository.existsById(id)) {
            locatarioAlterado.setId(id);
            repository.save(locatarioAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/relatorio/{id}")
    public ResponseEntity getRelatorio(@PathVariable int id) {
        if (repository.existsById(id)) {
            Locatario locatario = repository.findById(id).get();
            return ResponseEntity
                    .status(200)
                    .header("content-type", "plain/text")
                    .body(String.format("Relatorio do usuario: %d\n" +
                                    "Nome: %s\n" +
                                    "Sobrenome: %s\n" +
                                    "Email: %s\n" +
                                    "Senha: %s\n" +
                                    "Cpf: %s\n" +
                                    "Telefone: %s\n", id, locatario.getNome(), locatario.getSobrenome(), locatario.getEmail(),
                            locatario.getSenha(), locatario.getCpf(), locatario.getTelefone()));
        }
        return ResponseEntity.status(404).build();
    }

}