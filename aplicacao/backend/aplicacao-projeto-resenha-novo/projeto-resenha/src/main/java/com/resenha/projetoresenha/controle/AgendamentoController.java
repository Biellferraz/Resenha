package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.listas.PilhaObj;
import com.resenha.projetoresenha.repositorio.AgendamentoRepository;
import com.resenha.projetoresenha.listas.FilaObj;
import com.resenha.projetoresenha.repositorio.LocatarioRepository;
import com.resenha.projetoresenha.resposta.AgendamentoResponse;
import com.resenha.projetoresenha.teste.main.Teste;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;
    private LocatarioRepository locatarioRepository;

    @GetMapping("/teste")
    public ResponseEntity getTesteAgendamento() {
        List<Agendamento> agendamentos = repository.findAll();
        List<AgendamentoResponse> agendamentosResponse = new ArrayList<>();
        agendamentos.stream().forEach(agendamento -> agendamentosResponse.add(new AgendamentoResponse(agendamento)));
        return ResponseEntity.status(200).body(agendamentosResponse);
    }

    @GetMapping
    public ResponseEntity getAgendamento() {
        List<Agendamento> agendamentoLista = repository.findAll();
        if (agendamentoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        FilaObj<AgendamentoResponse> agendamentoFilaObj = new FilaObj<>(agendamentoLista.size());
        List<AgendamentoResponse> agendamentosResponse = new ArrayList<>();
        LocalDateTime dataAtual = LocalDateTime.now();
        agendamentoLista.stream()
                .filter((agendamento) -> agendamento.getHora_Marcada().isAfter(dataAtual) ||
                        agendamento.getHora_Marcada().equals(dataAtual))
                .sorted(Comparator.comparing(Agendamento::getHora_Marcada, Comparator.naturalOrder()))
                .forEach(agendamento -> agendamentoFilaObj.insert(new AgendamentoResponse(agendamento)));
        return ResponseEntity.status(200).body(agendamentoFilaObj.toList());
    }

    @GetMapping("/ocorridos")
    public ResponseEntity getAgendamentoOcorrido() {
        List<Agendamento> agendamentoLista = repository.findAll();
        if (agendamentoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        PilhaObj<Agendamento> agendamentoFilaObj = new PilhaObj<>(agendamentoLista.size());
        LocalDateTime dataAtual = LocalDateTime.now();
        agendamentoLista.stream()
                .filter((agendamento) -> agendamento.getHora_Marcada().isBefore(dataAtual) ||
                        agendamento.getHora_Marcada().equals(dataAtual))
                .sorted(Comparator.comparing(Agendamento::getHora_Marcada, Comparator.naturalOrder()))
                .forEach(agendamentoFilaObj::push);
        return ResponseEntity.status(200).body(agendamentoFilaObj.toList());
    }

    @PostMapping
    public ResponseEntity postAgendamento(@RequestBody Agendamento novoAgendamento) {
        repository.save(novoAgendamento);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAgendamento(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAgendamento(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putAgendamento(@PathVariable Integer id,
                                         @RequestBody Agendamento agendamentoAlterado) {
        if (repository.existsById(id)) {
            agendamentoAlterado.setFkQuadra(id);

            repository.save(agendamentoAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/recuperar-agendamentos/{fk_Quadra}")
    public ResponseEntity getAgendamentosQuadra(@PathVariable Integer fk_Quadra) {
        List<Agendamento> agendamentos = repository.findByFkQuadra(fk_Quadra);

        if (agendamentos == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(agendamentos);
    }

    @GetMapping("/relatorio/{id}")
    public ResponseEntity getAgendamentoRelatorio(@PathVariable int id) {
        if (repository.existsById(id)) {
            List<Agendamento> agendamentoLista = repository.findAll();
            Agendamento agendamento = repository.findById(id).get();
            return ResponseEntity
                    .status(200)
                    .header("content-type", "plain/text")
                    .body(String.format("\nRelatório do centros esportivos:\n  %s", agendamento.toString()));
        }
        return ResponseEntity.status(404).build();
    }

//    @GetMapping(value = "/exportar-txt", produces = "text/plain")
//    @ApiOperation(value = "Realiza a exportação de um arquivo com todos os centros esportivos")
//    public ResponseEntity<String> export() {
//
//        List
//
//        Agendamento agendamento = repository.findBy
//
//        List<Agendamento> lista = null;
//
//        String relatorio = Teste.gravaArquivoTxtAgendamento(lista);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", String.format("attachment; filename = resenha.txt"));
//        return new ResponseEntity<>(relatorio, headers, HttpStatus.OK);
//
////
//    }

    @GetMapping("/relatorios")
    public ResponseEntity getAgendamentoRelatorio() {
        if (!repository.equals(0)) {
            List<Agendamento> agendamento = repository.findAll();
            Teste.gravaArquivoTxtAgendamento(agendamento, "agendamento");
            return ResponseEntity
                    .status(200)
                    .header("content-type", "plain/text")
                    .body(String.format("\nRelatório do agendamentos:\n  %s", agendamento.toString()));
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/exportar-registro")
    public ResponseEntity exportarRegistro() {
        List<Agendamento> exportacao = repository.findAll();
        Teste.gravaArquivoTxtAgendamento(exportacao, "agendamento.txt");
        return ResponseEntity.status(200).build();
    }
}
