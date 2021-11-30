package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.dominio.CentroEsportivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Integer> {
    List<Agendamento> findByFkQuadra(Integer fk_Quadra);
}
