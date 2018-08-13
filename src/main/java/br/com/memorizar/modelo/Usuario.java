package br.com.memorizar.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;


//	@OneToOne(fetch = FetchType.LAZY,
//            mappedBy = "usuario")
//    private Frase frase;
	
	
//	public Frase getFrase() {
//		return frase;
//	}
//
//	public void setFrase(Frase frase) {
//		this.frase = frase;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
