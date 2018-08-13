package br.com.memorizar.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "frase")
@Entity
public class Frase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "fraseIngles")
	private String fraseIngles;
	
	@Column(name = "frasePortugues")
	private String frasePortugues;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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
	
	
	
}
