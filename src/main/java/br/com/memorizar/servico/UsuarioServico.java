package br.com.memorizar.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memorizar.modelo.Usuario;
import br.com.memorizar.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario buscaUsuario(String login, String senha){
		Usuario usuario = usuarioRepositorio.findByLogin(login);
		
		if(usuario == null)
			return null;
		
		return usuario;
	}

}
