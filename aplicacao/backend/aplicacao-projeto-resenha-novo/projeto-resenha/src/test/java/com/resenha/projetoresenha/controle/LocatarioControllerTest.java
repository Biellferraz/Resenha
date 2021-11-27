package com.resenha.projetoresenha.controle;

import com.resenha.projetoresenha.dominio.Locatario;
import com.resenha.projetoresenha.repositorio.LocatarioRepository;
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
class LocatarioControllerTest {

    @Autowired
    LocatarioController controller;

    @MockBean
    LocatarioRepository repository;

    @Test
    public void get_semLocatario_status204SemCorpo(){
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.getUsuarios();

        assertEquals(204, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());

        assertFalse(resposta.hasBody());
    }

    @Test
    public void get_comLocatario_status200comCorpo(){
        List<Locatario> locatario = List.of(mock(Locatario.class), mock(Locatario.class));

        when(repository.findAll()).thenReturn(locatario);

        ResponseEntity resposta = controller.getUsuarios();

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(locatario, resposta.getBody());
    }

//    @Test
//    public void post_erroLocatario_status404(){
//        Locatario locatario = mock(Locatario.class);
//
//        when(repository.save(locatario));
//
//        ResponseEntity resposta = controller.postUsuarios(locatario);
//
//        assertEquals(201,resposta.getStatusCodeValue());
//
//        assertEquals(locatario,resposta.getBody());
//
//    }

    @Test
    public void post_Locatario_status201(){
        Locatario locatario = mock(Locatario.class);

        when(repository.save(locatario));

        ResponseEntity resposta = controller.postUsuarios(locatario);

        assertEquals(201,resposta.getStatusCodeValue());

        assertEquals(locatario,resposta.getBody());

    }

//    @Test
//    public void post_erroLoginLocatario_status404(){
//        Locatario locatario = mock(Locatario.class);
//
//        String email = "email";
//
//        String senha = "Senha123";
//
//        when(repository.findByEmailAndSenha(email,senha));
//
//        ResponseEntity resposta = controller.login(locatario);
//
//        assertEquals(201,resposta.getStatusCodeValue());
//
//        assertEquals(locatario,resposta.getBody());
//    }

    @Test
    public void post_loginLocatario_status201(){
        Locatario locatario = mock(Locatario.class);

        String email = "email";

        String senha = "Senha123";

        when(repository.findByEmailAndSenha(email,senha));

        ResponseEntity resposta = controller.login(locatario);

        assertEquals(201,resposta.getStatusCodeValue());

        assertEquals(locatario,resposta.getBody());
    }

    @Test
    public void getId_semLocatario_status404(){
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.getUsuarios(id);


        assertEquals(404, resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void getId_comLocatario_status200(){
        Integer id = 101;
        Locatario locatario = mock(Locatario.class);

        when(repository.findById(id)).thenReturn(Optional.of(locatario));

        ResponseEntity resposta = controller.getUsuarios(id);

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(locatario, resposta.getBody());
    }

    @Test
    public void delete_erroDeletandoLocatario_status404(){
        List<Locatario> locatario = List.of(mock(Locatario.class),mock(Locatario.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.deleteUsuarios(id);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void delete_deletandoLocatario_status201(){
        List<Locatario> locatario = List.of(mock(Locatario.class),mock(Locatario.class));
        Integer id = 101;

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.deleteUsuarios(id);

        assertEquals(200,resposta.getStatusCodeValue());

        assertEquals(locatario,resposta.getBody());

    }

    @Test
    public void put_erroAlterandoId_status404(){
        Locatario locatario = mock(Locatario.class);
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity resposta = controller.putUsuarios(id,locatario);

        assertEquals(404,resposta.getStatusCodeValue());

        assertNull(resposta.getBody());
    }

    @Test
    public void put_AlterandoId_status201(){
        Locatario locatario = mock(Locatario.class);
        Integer id = 101;

        when(repository.findById(id)).thenReturn(Optional.of(locatario));

        ResponseEntity resposta = controller.putUsuarios(id,locatario);

        assertEquals(201,resposta.getStatusCodeValue());

        assertEquals(locatario,resposta.getBody());
    }

}