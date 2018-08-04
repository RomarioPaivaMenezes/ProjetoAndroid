package br.com.fiap.romario.alunocloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.romario.alunocloud.component.UserComponent;
import br.com.fiap.romario.alunocloud.model.Aluno;
import br.com.fiap.romario.alunocloud.model.User;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserComponent userComponent;

	@GetMapping(value = "/email/{email}/senha/{senha}")
	private User login(@PathVariable(value = "email") String email, @PathVariable(value = "senha") String senha) {
		return userComponent.login(email, senha);
	}

	@PostMapping
	private void save(@RequestBody User user) {
		userComponent.salvar(user);
	}
	
	  @GetMapping
	    private List<User> findAll() {
	        return userComponent.findAll();
	    }
}
