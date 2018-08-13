package br.com.memorizar.controle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import br.com.memorizar.DTO.FraseDTO;
import br.com.memorizar.modelo.Frase;
import br.com.memorizar.modelo.Usuario;
import br.com.memorizar.repositorio.FraseRepositorio;

@Controller
@RequestMapping("/frase")
public class FraseControle {
	
	@Autowired
	private Gson gson;
	
	@Autowired 
	FraseRepositorio fraseRepositorio;
	
	@GetMapping()
    public String teste(Model model) {
        return "cadastroFrase";
    }
	
	@PostMapping()
	public @ResponseBody String salvarFrase(@RequestBody String frases, HttpSession session  ) {
		FraseDTO fraseDTO = gson.fromJson(frases, FraseDTO.class);
		
		if(fraseDTO == null)
			return null;
		
		Frase frase = new Frase();
		frase.setFraseIngles(fraseDTO.getFraseIngles());
		frase.setFrasePortugues(fraseDTO.getFrasePortugues());
		frase.setUsuario( (Usuario) session.getAttribute("usuarioLogado") );
		fraseRepositorio.save(frase);
					
				
		return gson.toJson("Frase cadastrada com sucesso");
	}
	
	@GetMapping("/listarFrase")
	public ModelAndView listaFrases() {
		ModelAndView mv = new ModelAndView("listaFrase");
		mv.addObject("frases", fraseRepositorio.findAll());
		return mv;
	}
	
	
}
