package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByFkQuadra(Integer fk_Quadra);

    @Query("select a from Agendamento a where a.fkQuadra = ?1")
    List<Agendamento> findHorarioAgendamentoByFkQuadra(Integer fk_Quadra
    );
}
