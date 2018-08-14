package br.com.memorizar.controle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.memorizar.servico.JogoServico;

@Controller
@RequestMapping("/jogo")
public class JogoControle {

	@Autowired
	private JogoServico jogoServico;
	
	@GetMapping
	public String exibeFraseJogo(HttpSession session) {
		return jogoServico.exibeFraseJogo(session);
	}

}
