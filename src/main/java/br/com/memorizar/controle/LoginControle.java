package br.com.memorizar.controle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.memorizar.modelo.Usuario;
import br.com.memorizar.servico.FraseServico;
import br.com.memorizar.servico.UsuarioServico;


@Controller
public class LoginControle {

	private Gson gson = new Gson();
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@Autowired
	private FraseServico fraseServico;
	
	@RequestMapping("/")
    public String inicio(Model model) {
        model.addAttribute("name", "José");
        return "login";
    }
	
	@PostMapping("/logar")
	public @ResponseBody String login(@RequestBody String json, HttpSession session) {
		
		Usuario usuario = gson.fromJson(json, Usuario.class);
		   
 		usuario = (Usuario) usuarioServico.buscaUsuario(usuario.getLogin(), usuario.getSenha());
		
		if(usuario == null)
			return null;
		 
		setAtributosDaSessao(session, usuario);
		session.setAttribute("frases", fraseServico.buscaFrasesPorUsuario((Usuario) session.getAttribute("usuarioLogado")));
		
		return gson.toJson("frase");
	}

	private void setAtributosDaSessao(HttpSession session, Usuario usuario) {
		session.setAttribute("usuarioLogado", usuario);
	}
}
