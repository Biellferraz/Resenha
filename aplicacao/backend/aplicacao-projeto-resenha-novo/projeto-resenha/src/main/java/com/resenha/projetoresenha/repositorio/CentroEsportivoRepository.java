package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentroEsportivoRepository extends JpaRepository<CentroEsportivo, Integer> {
    List<CentroEsportivo> findByFkLocatario(Integer fk_locatario);
}
