package br.com.memorizar.controle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.memorizar.DTO.FraseDTO;
import br.com.memorizar.modelo.Frase;
import br.com.memorizar.modelo.Usuario;
import br.com.memorizar.repositorio.FraseRepositorio;
import br.com.memorizar.servico.FraseServico;

@Controller
@RequestMapping("/frase")
public class FraseControle {

	@Autowired
	private Gson gson;

	@Autowired
	private FraseRepositorio fraseRepositorio;

	@Autowired
	private FraseServico fraseServico;

	@GetMapping()
	public String teste(Model model) {
		return "cadastroFrase";
	}

	@PostMapping()
	public @ResponseBody String salvarFrase(@RequestBody String frases, HttpSession session) {
		FraseDTO fraseDTO = gson.fromJson(frases, FraseDTO.class);

		if (fraseDTO == null)
			return null;

		Frase frase = new Frase();
		frase.setFraseIngles(fraseDTO.getFraseIngles());
		frase.setFrasePortugues(fraseDTO.getFrasePortugues());
		frase.setUsuario((Usuario) session.getAttribute("usuarioLogado"));
		fraseRepositorio.save(frase);
		
		session.setAttribute("frases", fraseServico.buscaFrasesPorUsuario((Usuario) session.getAttribute("usuarioLogado")));
		return gson.toJson("Frase cadastrada com sucesso");
	}

	@GetMapping("/listarFrase")
	public String listaFrases(HttpSession session) {
//		session.setAttribute("frases", fraseServico.buscaFrasesPorUsuario((Usuario) session.getAttribute("usuarioLogado")));
		return "listaFrase";
	}

	@PutMapping("/editarFrase")
	public @ResponseBody String editarFrase(@RequestBody String frases, HttpSession session) {
		
		Frase fraseFront = gson.fromJson(frases, Frase.class);
		
		if (fraseFront == null)
			return null;
		
		Frase frase = fraseServico.obtemFrase(fraseFront.getId());
		frase.setFraseIngles(fraseFront.getFraseIngles());
		frase.setFrasePortugues(fraseFront.getFrasePortugues());
		frase.setUsuario((Usuario) session.getAttribute("usuarioLogado"));
		
		fraseRepositorio.save(frase);
		
		session.setAttribute("frases", fraseServico.buscaFrasesPorUsuario((Usuario) session.getAttribute("usuarioLogado")));

		return gson.toJson("Frase editada com sucesso");
	}

	@DeleteMapping("/excluirFrase/{id}")
	public @ResponseBody String excluirFrase(@PathVariable long id) {
		
		fraseRepositorio.deleteById(id);
		return gson.toJson("Frase deletada com sucesso");
	}
}
