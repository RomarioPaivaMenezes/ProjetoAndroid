package br.com.fiap.romario.alunocloud.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.romario.alunocloud.model.User;
import br.com.fiap.romario.alunocloud.repository.UserRepository;

@Component
public class UserComponent{
	
	
   @Autowired
   UserRepository userRepository;
    
   public User salvar(User user) {
       return userRepository.save(user);
   }


	public void alterar(User user) {
		  User userBd = userRepository.findByEmail(user.getEmail());
        if(userBd!=null){
        	userBd.setEmail(user.getEmail());
            userBd.setSenha(user.getSenha());
 
        }
        userRepository.save(userBd);
	}
	
	public User login(String email, String senha) {
		
		User userEmail = userRepository.findByEmail(email);
		User userSenha = userRepository.findBySenha(senha);
		
		if(userEmail.equals(userSenha)) {
			return userEmail;
		}else return null;
		
	}
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}