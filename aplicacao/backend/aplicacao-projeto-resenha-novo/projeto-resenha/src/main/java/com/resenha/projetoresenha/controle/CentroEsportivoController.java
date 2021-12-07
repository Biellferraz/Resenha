package com.resenha.projetoresenha.controle;


import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.repositorio.CentroEsportivoRepository;
import com.resenha.projetoresenha.teste.main.Teste;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/importacao")
    public ResponseEntity importarRegistro(
            @RequestParam MultipartFile arquivo) throws IOException {
        String conteudo = new String(arquivo.getBytes());
        List<CentroEsportivo> centroEsportivos = null;
        centroEsportivos = Teste.leArquivoTxtCentroEsportivo(conteudo);

        if (centroEsportivos == null) {
            return ResponseEntity.status(204).build();
        }
        for (CentroEsportivo centroEsportivo : centroEsportivos) {
            repository.save(centroEsportivo);
        }
        return ResponseEntity.status(201).body(centroEsportivos);
    }

}