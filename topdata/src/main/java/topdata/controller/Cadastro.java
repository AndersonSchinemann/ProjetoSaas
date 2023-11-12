package topdata.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cadastro {
	
	@GetMapping("/cadastro")
	public String exibirFormularioCadastro() {
	   return "cadastro"; // Este é o nome do seu arquivo HTML (cadastro.html)
	}

}
