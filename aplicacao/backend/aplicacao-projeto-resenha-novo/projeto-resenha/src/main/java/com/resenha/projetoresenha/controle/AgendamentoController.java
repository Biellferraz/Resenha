package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.listas.PilhaObj;
import com.resenha.projetoresenha.repositorio.AgendamentoRepository;
import com.resenha.projetoresenha.listas.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {


        @Autowired
        private AgendamentoRepository repository;

        @CrossOrigin
        @GetMapping
        public ResponseEntity getAgendamento() {
            List<Agendamento> agendamentoLista = repository.findAll();
            if (agendamentoLista.isEmpty()) {
                return ResponseEntity.status(204).build();
            }
            FilaObj<Agendamento> agendamentoFilaObj  = new FilaObj<>(agendamentoLista.size());
            LocalDateTime dataAtual = LocalDateTime.now();
            agendamentoLista.stream()
                    .filter((agendamento) -> agendamento.getHora_Marcada().isAfter(dataAtual) ||
                            agendamento.getHora_Marcada().equals(dataAtual))
                    .sorted(Comparator.comparing(Agendamento::getHora_Marcada, Comparator.naturalOrder()))
                    .forEach(agendamentoFilaObj::insert);
            return ResponseEntity.status(200).body(agendamentoFilaObj.toList());
        }

    @GetMapping("/ocorridos")
    public ResponseEntity getAgendamentoOcorrido() {
        List<Agendamento> agendamentoLista = repository.findAll();
        if (agendamentoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        PilhaObj<Agendamento> agendamentoFilaObj  = new PilhaObj<>(agendamentoLista.size());
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

//    @GetMapping("/relatorio/{id}")
//    public ResponseEntity getAgendamentoRelatorio(@PathVariable int id) {
//        if (repository.existsById(id)) {
//            Agendamento agendamento = repository.findById(id).get();
//            return ResponseEntity
//                    .status(200)
//                    .header("content-type", "plain/text")
//                    .body(String.format("\nRelatório do centros esportivos:\n  %s",
//                            Teste.gravaArquivoTxtAgendamento(agendamento, "agend")));
//
//
//        }
//        return ResponseEntity.status(404).build();
//    }


}
