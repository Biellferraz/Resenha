package com.resenha.projetoresenha.controle;


import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.repositorio.CentroEsportivoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/centros")
@CrossOrigin
public class CentroEsportivoController {

    @Autowired
    private CentroEsportivoRepository repository;

//    @GetMapping(value = "/exportar-txt", produces = "plain/text")
//    @ApiOperation(value = "Realiza a exportação de um arquivo com todos os centros esportivos")
//    public ResponseEntity<?> export() {
//
//        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
//        var filename = String.format("CentroE.txt");
//
//        try {
//            var file = new File(filename);
//            var path = Paths.get(file.getAbsolutePath());
//            var resource = new ByteArrayResource(Files.readAllBytes(path));
//            return ResponseEntity
//                    .ok()
//                    .contentType(MediaType.parseMediaType("plain/text"))
//                    .contentLength(file.length())
//                    .body(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/recuperar-centros/{fk_locatario}")
    public ResponseEntity getCentrosEsportivosDoLocatario(@PathVariable Integer fk_locatario) {
        List<CentroEsportivo> centrosEncontrados = repository.findByFkLocatario(fk_locatario);

        if (centrosEncontrados == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(centrosEncontrados);
    }

    @GetMapping
    public ResponseEntity getCentroEsportivo() {
        List<CentroEsportivo> centroEsportivoLista = (List<CentroEsportivo>) repository.findAll();
        if (centroEsportivoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(centroEsportivoLista);
    }

    @PostMapping
    public ResponseEntity postCentroEsportivo(@RequestBody CentroEsportivo novoCentroEsportivo) {
        repository.save(novoCentroEsportivo);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCentroEsportivo(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCentroEsportivo(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putCentroEsportivo(@PathVariable Integer id,
                                             @RequestBody CentroEsportivo centroEsportivoAlterado) {
        if (repository.existsById(id)) {
            centroEsportivoAlterado.setId(id);
            repository.save(centroEsportivoAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/relatorio/{id}")
    public ResponseEntity getRelatorioCentroEsportivo(@PathVariable int id) {
        if (repository.existsById(id)) {
            CentroEsportivo centroEsportivo = repository.findById(id).get();
            return ResponseEntity
                    .status(200)
                    .header("content-type", "plain/text")
                    .body(String.format("\nRelatório do centros esportivos:\n  %s", centroEsportivo.toString()));
        }
        return ResponseEntity.status(404).build();
    }

}