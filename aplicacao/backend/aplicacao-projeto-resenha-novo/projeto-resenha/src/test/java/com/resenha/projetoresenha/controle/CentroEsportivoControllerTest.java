package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.repositorio.CentroEsportivoRepository;
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
class CentroEsportivoControllerTest {

    @Autowired
    CentroEsportivoController controller;

    @MockBean
    CentroEsportivoRepository repository;

    @Test
    public void get_semCentroEsportivo_status204SemCorpo(){
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.getCentroEsportivo();

        assertEquals(204, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());

        assertFalse(resposta.hasBody());
    }

    @Test
    public void get_comCentroEsportivo_status200comCorpo(){
        List<CentroEsportivo> centroEsportivo = List.of(mock(CentroEsportivo.class), mock(CentroEsportivo.class));

        when(repository.findAll()).thenReturn(centroEsportivo);

        ResponseEntity resposta = controller.getCentroEsportivo();

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(centroEsportivo, resposta.getBody());
    }

    @Test
    public void getId_semCentroEsportivo_status404(){
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.getCentroEsportivo(id);


        assertEquals(404, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void getId_comCentroEsportivo_status200(){
        Integer id = 101;
        CentroEsportivo centroEsportivo = mock(CentroEsportivo.class);

        when(repository.findById(id)).thenReturn(Optional.of(centroEsportivo));

        ResponseEntity resposta = controller.getCentroEsportivo(id);

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(centroEsportivo, resposta.getBody());
    }

    @Test
    public void delete_erroDeletandoCentroEsportivo_status404(){
        List<CentroEsportivo> centroEsportivo = List.of(mock(CentroEsportivo.class),mock(CentroEsportivo.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.deleteCentroEsportivo(id);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void delete_deletandoCentroEsportivo_status201(){
        List<CentroEsportivo> centroEsportivo = List.of(mock(CentroEsportivo.class),mock(CentroEsportivo.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.deleteCentroEsportivo(id);

        assertEquals(200,resposta.getStatusCodeValue());
    }

    @Test
    public void put_erroAlterandoId_status404(){
        CentroEsportivo centroEsportivo = mock(CentroEsportivo.class);
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.putCentroEsportivo(id,centroEsportivo);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void put_AlterandoId_status200(){
        CentroEsportivo centroEsportivo = mock(CentroEsportivo.class);
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.putCentroEsportivo(id,centroEsportivo);

        assertEquals(200,resposta.getStatusCodeValue());
    }

}