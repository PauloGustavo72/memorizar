package br.com.memorizar.repositorio;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.memorizar.modelo.Usuario;

public interface UsuarioRepositorio extends Repository<Usuario, Long> {

	Usuario findByLogin(@Param("login") String login);

}
