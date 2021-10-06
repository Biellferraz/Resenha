package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Usuario;
import com.resenha.projetoresenha.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenha")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

//    @GetMapping
//    public List<Usuario> getUsuario() {
//        return repository.findAll();
//    }
//
//    @PostMapping
//    public String postUsuario(@RequestBody Usuario novoUsuario) {
//        repository.save(novoUsuario);
//        return "Usuario cadastrado com sucesso";
//    }
//
//    @GetMapping("/{id}")
//    public Usuario getUsuario(@PathVariable int id) {
//        return repository.findById(id).get();
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUsuario(@PathVariable int id) {
//        repository.deleteById(id);
//        return "Usuario excluído com sucesso";
//    }
//
//    @PutMapping("/{id}")
//    public String putUsuario(@PathVariable int id,
//                             @RequestBody Usuario usuarioAlterado) {
//        usuarioAlterado.setId(id);
//        repository.save(usuarioAlterado);
//        return "Usuario atualizado com sucesso";
//    }

    @GetMapping
    public ResponseEntity getUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }
    @PostMapping
    public ResponseEntity postUsuarios(@RequestBody Usuario novoUsuario) {
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity getUsuarios(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuarios(@PathVariable int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity putUsuarios(@PathVariable int id,
                                    @RequestBody Usuario usuarioAlterado) {
        if (repository.existsById(id)){
            usuarioAlterado.setId(id);
            repository.save(usuarioAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @GetMapping("/letra/{id}")
//    public ResponseEntity getLetra(@PathVariable int id){
//        if (repository.existsById(id)){
//            Musica musica = repository.findById(id).get();
//            return ResponseEntity.status(200)
//                    .header("content-type", "plain/text")
//                    .body(musica.getLetra());
//        }
//        return ResponseEntity.status(404).build();
//    }


}