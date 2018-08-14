package br.com.memorizar.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.memorizar.modelo.Frase;

@Repository
public interface FraseRepositorio extends JpaRepository<Frase, Long> {

	List<Frase> findByUsuarioId(@Param("usuarioId") Long usuarioId);
	

}
