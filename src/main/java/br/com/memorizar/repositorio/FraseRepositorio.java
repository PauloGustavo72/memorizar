package br.com.memorizar.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.memorizar.modelo.Frase;

@Repository
public interface FraseRepositorio extends JpaRepository<Frase, Long> {

	
}
