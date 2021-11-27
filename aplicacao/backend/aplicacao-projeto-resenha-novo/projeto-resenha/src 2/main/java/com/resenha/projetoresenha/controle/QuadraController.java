package com.resenha.projetoresenha.controle;


import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.repositorio.ListaObj;
import com.resenha.projetoresenha.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locatario")
public class QuadraController {

    @Autowired
    private QuadraRepository repository;
    @GetMapping
    public ResponseEntity getCentroEsportivo() {
        ListaObj<Quadra> quadraListaObj = (ListaObj<Quadra>) repository.findAll();
        if(quadraListaObj.getTamanho() == 0){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(quadraListaObj);
    }
    @PostMapping
    public ResponseEntity postQuadra(@RequestBody Quadra novaQuadra) {
        repository.save(novaQuadra);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity getQuadra(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuadra(@PathVariable Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity putQuadra(@PathVariable Integer id,
                                    @RequestBody Quadra quadraAlterado) {
        if (repository.existsById(id)){
            quadraAlterado.setIdQuadra(id);
            repository.save(quadraAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
    @GetMapping("/relatorio/{id}")
    public ResponseEntity getQuadra(@PathVariable int id) {
        if (repository.existsById(id)) {
            Quadra quadra = repository.findById(id).get();
            return ResponseEntity
                    .status(200)
                    .header("content-type", "plain/text")
                    .body(String.format("\nRelatório do centros esportivos:\n  %s",quadra.toString()));
        }
        return ResponseEntity.status(404).build();
    }

}