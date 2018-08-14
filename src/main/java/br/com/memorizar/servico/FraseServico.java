package br.com.memorizar.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memorizar.modelo.Frase;
import br.com.memorizar.modelo.Usuario;
import br.com.memorizar.repositorio.FraseRepositorio;

@Service
public class FraseServico {

	@Autowired
	FraseRepositorio fraseRepositorio;

	public List<Frase> buscaFrasesPorUsuario(Usuario usuario) {

		List<Frase> frases = fraseRepositorio.findByUsuarioId(usuario.getId());

		if (frases == null)
			return null;

		return frases;
	}

	public Frase obtemFrase(Long id) {
		Optional<Frase> findById = fraseRepositorio.findById(id);

		if (findById.isPresent()) {
			Frase frase = findById.get();
			return frase;
		}
		return null;
	}
}
