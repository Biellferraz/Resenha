package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.repositorio.QuadraRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuadraControllerTest {

    @Autowired
    QuadraController controller;

    @MockBean
    QuadraRepository repository;

    @Test
    public void get_semQuadra_status204SemCorpo(){
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.getQuadras();

        assertEquals(204, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());

        assertFalse(resposta.hasBody());
    }

    @Test
    public void get_comQuadra_status200comCorpo(){
        List<Quadra> quadra = List.of(mock(Quadra.class), mock(Quadra.class));

        when(repository.findAll()).thenReturn(quadra);

        ResponseEntity resposta = controller.getQuadras();

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(quadra, resposta.getBody());
    }

    @Test
    public void getId_semQuadra_status404(){
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.getQuadra(id);


        assertEquals(404, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void getId_comQuadra_status200(){
        Integer id = 101;
        Quadra quadra = mock(Quadra.class);

        when(repository.findById(id)).thenReturn(Optional.of(quadra));

        ResponseEntity resposta = controller.getQuadra(id);

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(quadra, resposta.getBody());
    }

    @Test
    public void delete_erroDeletandoQuadra_status404(){
        List<Quadra> quadra = List.of(mock(Quadra.class),mock(Quadra.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.deleteQuadra(id);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void delete_deletandoQuadra_status201(){
        List<Quadra> quadra = List.of(mock(Quadra.class),mock(Quadra.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.deleteQuadra(id);

        assertEquals(200,resposta.getStatusCodeValue());
    }

    @Test
    public void put_erroAlterandoId_status404(){
        Quadra quadra = mock(Quadra.class);
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.putQuadra(id,quadra);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void put_AlterandoId_status200(){
        Quadra quadra = mock(Quadra.class);
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.putQuadra(id,quadra);

        assertEquals(200,resposta.getStatusCodeValue());
    }

}