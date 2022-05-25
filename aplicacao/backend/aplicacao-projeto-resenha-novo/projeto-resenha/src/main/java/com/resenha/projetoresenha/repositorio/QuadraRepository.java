package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuadraRepository extends JpaRepository<Quadra, Integer> {
    List<Quadra> findByFkCentroEsportivo(Integer fkCentroEsportivo);
    List<Quadra> findByModalidade(String modalide);
}
