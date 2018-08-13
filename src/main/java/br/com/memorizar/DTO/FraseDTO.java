package br.com.memorizar.DTO;

import br.com.memorizar.modelo.Usuario;

public class FraseDTO {
	
	private String fraseIngles;
	
	private String frasePortugues;

	private Usuario usuario;

	public String getFraseIngles() {
		return fraseIngles;
	}

	public void setFraseIngles(String fraseIngles) {
		this.fraseIngles = fraseIngles;
	}

	public String getFrasePortugues() {
		return frasePortugues;
	}

	public void setFrasePortugues(String frasePortugues) {
		this.frasePortugues = frasePortugues;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
