package com.resenha.projetoresenha.repositorio;

import com.resenha.projetoresenha.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
