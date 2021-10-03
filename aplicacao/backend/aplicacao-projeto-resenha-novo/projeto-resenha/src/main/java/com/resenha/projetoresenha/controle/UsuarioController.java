package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Usuario;
import com.resenha.projetoresenha.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenha")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsuario() {
        return repository.findAll();
    }

    @PostMapping
    public String postUsuario(@RequestBody Usuario novoUsuario) {
        repository.save(novoUsuario);
        return "Usuario cadastrado com sucesso";
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable int id) {
        repository.deleteById(id);
        return "Usuario excluído com sucesso";
    }

    @PutMapping("/{id}")
    public String putUsuario(@PathVariable int id,
                             @RequestBody Usuario usuarioAlterado) {
        usuarioAlterado.setId(id);
        repository.save(usuarioAlterado);
        return "Usuario atualizado com sucesso";
    }
}