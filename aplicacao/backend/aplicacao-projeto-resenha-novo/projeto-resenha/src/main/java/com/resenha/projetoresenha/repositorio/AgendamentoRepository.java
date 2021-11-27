package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Integer> {
}
