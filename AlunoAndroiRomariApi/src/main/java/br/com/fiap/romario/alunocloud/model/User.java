package br.com.fiap.romario.alunocloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

		@Id
		private String email;
		private String senha;
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		@Override
		public boolean equals(Object obj) {
			User user = (User) obj;
			if(this.email.equals(user.getEmail()) && this.senha.equals(user.getSenha())) {
				return true;
			} else return false;
		}
		
		
		
			
}