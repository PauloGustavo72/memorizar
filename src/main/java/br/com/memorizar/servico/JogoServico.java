package br.com.memorizar.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import br.com.memorizar.modelo.Frase;

@Service
public class JogoServico {

	public String exibeFraseJogo(HttpSession session) {

		List<Frase> frases = (List<Frase>) session.getAttribute("frases");

		Frase frase = frases.get(new Random().nextInt(frases.size()));

		ArrayList<String> modeloFrase = adicionaFraseNoArray(frase);

		session.setAttribute("fraseJogo", modeloFrase);
		session.setAttribute("frase", frase);

		return "jogo";
	}

	private ArrayList<String> adicionaFraseNoArray(Frase frase) {
		ArrayList<String> modeloFrase = new ArrayList<>();
		modeloFrase.add(frase.getFrasePortugues());
		modeloFrase.add(frase.getFrasePortugues().concat("1"));
		modeloFrase.add(frase.getFrasePortugues().concat("2"));

		Collections.shuffle(modeloFrase);

		return modeloFrase;
	}
}
