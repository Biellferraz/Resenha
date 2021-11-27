package com.resenha.projetoresenha.controle;


import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.repositorio.CentroEsportivoRepository;
import com.resenha.projetoresenha.repositorio.ListaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locatario")
public class CentroEsportivoController {

    @Autowired
    private CentroEsportivoRepository repository;
    @GetMapping
    public ResponseEntity getCentroEsportivo() {
        ListaObj<CentroEsportivo> centroEsportivoListaObj = (ListaObj<CentroEsportivo>) repository.findAll();
        if(centroEsportivoListaObj.getTamanho() == 0){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(centroEsportivoListaObj);
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
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity putCentroEsportivo(@PathVariable Integer id,
                                      @RequestBody CentroEsportivo centroEsportivoAlterado) {
        if (repository.existsById(id)){
            centroEsportivoAlterado.setIdCentroEsportivo(id);
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
                    .body(String.format("\nRelatório do centros esportivos:\n  %s",centroEsportivo.toString()));
        }
        return ResponseEntity.status(404).build();
    }

}