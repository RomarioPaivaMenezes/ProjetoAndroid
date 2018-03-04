package br.com.fiap.romario.alunocloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.romario.alunocloud.model.Aluno;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String>{

    Aluno findByRg(String rg);

}
