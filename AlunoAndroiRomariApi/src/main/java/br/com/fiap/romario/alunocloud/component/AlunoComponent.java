package br.com.fiap.romario.alunocloud.component;

import br.com.fiap.romario.alunocloud.model.Aluno;
import br.com.fiap.romario.alunocloud.repository.AlunoRepository;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoComponent {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public void deleteAll() {
        alunoRepository.deleteAll();
    }

    public Aluno buscarAluno(String rg) {
        Aluno aluno = alunoRepository.findByRg(rg);
        if (aluno == null) {
            return new Aluno();
        } else {
            return aluno;
        }
    }

	public void alterar(Aluno aluno) {
		  Aluno alunos = alunoRepository.findByRg(aluno.getRg());

          if(alunos!=null){
              alunos.setRg(aluno.getRg());
              alunos.setDataNascimento(aluno.getDataNascimento());
              alunos.setNome(aluno.getNome());
          }
          
          alunoRepository.save(alunos);
	}

	public void delete(String rg) {
		 Aluno alunos = alunoRepository.findByRg(rg);
		 alunoRepository.delete(alunos);
	}
}