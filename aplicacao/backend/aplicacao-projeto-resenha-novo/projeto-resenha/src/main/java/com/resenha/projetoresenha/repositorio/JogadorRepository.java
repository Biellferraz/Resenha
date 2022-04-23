package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador,Integer> {
    Jogador findByEmailAndSenha(String email, String senha);

}
