package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.listas.PilhaObj;
import com.resenha.projetoresenha.repositorio.AgendamentoRepository;
import com.resenha.projetoresenha.listas.FilaObj;
import com.resenha.projetoresenha.repositorio.CentroEsportivoRepository;
import com.resenha.projetoresenha.repositorio.LocatarioRepository;
import com.resenha.projetoresenha.repositorio.QuadraRepository;
import com.resenha.projetoresenha.requisicao.AgendamentoRequisicao;
import com.resenha.projetoresenha.resposta.AgendamentoResponse;
import com.resenha.projetoresenha.teste.main.Teste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private CentroEsportivoRepository repositoryCentro;

    @Autowired
    private QuadraRepository repositoryQuadra;

    @Autowired
    private LocatarioRepository locatarioRepository;

    @GetMapping("/teste")
    public ResponseEntity getTesteAgendamento() {
        List<Agendamento> agendamentos = repository.findAll();
        List<AgendamentoResponse> agendamentosResponse = new ArrayList<>();
        agendamentos.stream().forEach(agendamento -> agendamentosResponse.add(new AgendamentoResponse(agendamento)));
        return ResponseEntity.status(200).body(agendamentosResponse);
    }

    @GetMapping("/marcados/{id}")
    public ResponseEntity getAgendamentosMarcados(@PathVariable Integer id) {
        List<Agendamento> agendamentoLista = exportar(id);
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

    @GetMapping("/ocorridos/{id}")
    public ResponseEntity getAgendamentoOcorrido(@PathVariable Integer id) {
        List<Agendamento> agendamentoLista = exportar(id);
        if (agendamentoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        PilhaObj<AgendamentoResponse> agendamentoFilaObj = new PilhaObj<>(agendamentoLista.size());
        LocalDateTime dataAtual = LocalDateTime.now();
        agendamentoLista.stream()
                .filter((agendamento) -> agendamento.getHora_Marcada().isBefore(dataAtual) ||
                        agendamento.getHora_Marcada().equals(dataAtual))
                .sorted(Comparator.comparing(Agendamento::getHora_Marcada, Comparator.naturalOrder()))
                .forEach(agendamento -> agendamentoFilaObj.push(new AgendamentoResponse(agendamento)));
        return ResponseEntity.status(200).body(agendamentoFilaObj.toList());
    }

    @PostMapping("/agendar")
    public ResponseEntity postAgendamento(@RequestBody @Valid AgendamentoRequisicao novoAgendamento) {


        LocalDateTime data = LocalDateTime.parse(novoAgendamento.getData());
        LocalDateTime dtHrAtendimento = LocalDateTime.of(data.getYear(), data.getMonth().getValue(), data.getDayOfMonth(), data.getHour(), 0);



        Agendamento agendamento = new Agendamento(
                novoAgendamento.getIdQuadra(),
                novoAgendamento.getIdJogador(),
                novoAgendamento.getPreco(),
                dtHrAtendimento

        );

        System.out.println(novoAgendamento);

        repository.save(agendamento);
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

    public List<Agendamento> exportar(Integer id) {
        CentroEsportivo centro = repositoryCentro.findById(id).get();
        List<Quadra> quadras = repositoryQuadra.findByFkCentroEsportivo(centro.getId());
        List<Agendamento> agendamentos = new ArrayList<>();
        for (Quadra quadra : quadras) {
            List<Agendamento> auxiliar = repository.findByFkQuadra(quadra.getId());
            for (Agendamento agend : auxiliar) {
                agendamentos.add(agend);
            }
        }
        return agendamentos;
    }

    public String nomeCentroEsportivo(Integer id) {
        CentroEsportivo centroEsportivo = repositoryCentro.findById(id).get();
        return centroEsportivo.getNome();
    }

    @GetMapping(value = "/exportar/{id}", produces = "text/plain")
    public ResponseEntity exportarRegistro(@PathVariable Integer id, CentroEsportivo centroEsportivo) {
        if (!(exportar(id) == null)) {
            String exportar = Teste.gravaArquivoTxtAgendamento(exportar(id), "agendamento.txt");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment; filename = %s-agendamentos.txt", nomeCentroEsportivo(id)));
            return new ResponseEntity<>(exportar, headers, HttpStatus.OK);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/horarios/{idQuadra}/{dia}")
    public ResponseEntity<List<LocalTime>> getHorarios(@PathVariable Integer idQuadra,
                                                       @PathVariable String dia) {
        List<Agendamento> horariosOcupados = repository.findHorarioAgendamentoByFkQuadra(idQuadra);
        List<LocalTime> horariosTrabalho = addHours();
        List<LocalTime> horariosLivres = new ArrayList<>();

        horariosTrabalho.forEach(hrTrabalho -> {
            horariosLivres.add(hrTrabalho);

            horariosOcupados.forEach(hrOcuped -> {
                        LocalTime horaOcupadaDaVez = LocalTime.of(hrOcuped.getHora_Marcada().getHour(), 0);
                        LocalDate diaOcupadoDaVez = LocalDate.of(hrOcuped.getHora_Marcada().getYear(), hrOcuped.getHora_Marcada().getMonth().getValue(), hrOcuped.getHora_Marcada().getDayOfMonth());
                        if (horaOcupadaDaVez.equals(hrTrabalho) && diaOcupadoDaVez.equals(LocalDate.parse(dia))) {
                            horariosLivres.remove(hrTrabalho);
                        }
                    }
            );
        });

        if (horariosLivres.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(horariosLivres);
    }


    private List<LocalTime> addHours() {
        LocalTime horas;
        List<LocalTime> allHours = new ArrayList<>();
        int result = 0;

        try {
            for (int i = 8; i < 18; i++) {
                horas = LocalTime.of(i, 0);

                allHours.add(horas);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return allHours;
    }
}
