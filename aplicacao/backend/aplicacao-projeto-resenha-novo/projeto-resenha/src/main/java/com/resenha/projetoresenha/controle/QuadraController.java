package com.resenha.projetoresenha.controle;


import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quadras")
@CrossOrigin
public class QuadraController {

    @Autowired
    private QuadraRepository repository;

    @GetMapping("/recuperar-quadras/{fkCentroEsportivo}")
    public ResponseEntity getQuadrasDoCentroEsportivo(@PathVariable Integer fkCentroEsportivo) {
        List<Quadra> quadrasEncontradas = repository.findByFkCentroEsportivo(fkCentroEsportivo);

        if (quadrasEncontradas == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(quadrasEncontradas);
    }

    @GetMapping
    public ResponseEntity getQuadras() {
        List<Quadra> quadraLista = repository.findAll();
        if (quadraLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(quadraLista);
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
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putQuadra(@PathVariable Integer id,
                                    @RequestBody Quadra quadraAlterado) {
        if (repository.existsById(id)) {
            quadraAlterado.setId(id);
            repository.save(quadraAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}