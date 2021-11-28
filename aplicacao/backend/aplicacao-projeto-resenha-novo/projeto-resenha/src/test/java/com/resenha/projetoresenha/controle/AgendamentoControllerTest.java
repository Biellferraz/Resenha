package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.listas.FilaObj;
import com.resenha.projetoresenha.repositorio.AgendamentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class AgendamentoControllerTest {
    @Autowired
    AgendamentoController controller;

    @MockBean
    AgendamentoRepository repository;

    @Test
    public void get_semAgendamento_status204SemCorpo(){
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.getAgendamento();

        assertEquals(204, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());

        assertFalse(resposta.hasBody());
    }

    @Test
    public void getId_semAgendamento_status404(){
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.getAgendamento(id);


        assertEquals(404, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void getId_comAgendamento_status200(){
        Integer id = 101;
        Agendamento agendamento = mock(Agendamento.class);

        when(repository.findById(id)).thenReturn(Optional.of(agendamento));

        ResponseEntity resposta = controller.getAgendamento(id);

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(agendamento, resposta.getBody());
    }

    @Test
    public void delete_erroDeletandoAgendamento_status404(){
        List<Agendamento> agendamento = List.of(mock(Agendamento.class),mock(Agendamento.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.deleteAgendamento(id);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void delete_deletandoAgendamento_status201(){
        List<Agendamento> agendamento = List.of(mock(Agendamento.class),mock(Agendamento.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.deleteAgendamento(id);

        assertEquals(200,resposta.getStatusCodeValue());
    }

    @Test
    public void put_erroAlterandoId_status404(){
        Agendamento agendamento = mock(Agendamento.class);
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.putAgendamento(id,agendamento);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void put_AlterandoId_status200(){
        Agendamento agendamento = mock(Agendamento.class);
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.putAgendamento(id,agendamento);

        assertEquals(200,resposta.getStatusCodeValue());
    }
}