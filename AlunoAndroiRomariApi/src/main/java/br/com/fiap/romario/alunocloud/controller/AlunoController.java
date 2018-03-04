package br.com.fiap.romario.alunocloud.controller;

import br.com.fiap.romario.alunocloud.component.AlunoComponent;
import br.com.fiap.romario.alunocloud.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoComponent alunoComponent;

    @GetMapping
    private List<Aluno> findAll() {
        return alunoComponent.findAll();
    }

    @GetMapping(value = "/rg/{rg}")
    private Aluno findAll(@PathVariable(value = "rg") String rg) {
        return alunoComponent.buscarAluno(rg);
    }

    @PostMapping
    private void save(@RequestBody Aluno aluno) {
        alunoComponent.salvar(aluno);
    }

    @DeleteMapping
    private void deleteAll() {
        alunoComponent.deleteAll();
    }
    
    @DeleteMapping(value = "/rg/{rg}")
    private void delete(@PathVariable(value = "rg") String rg) {
        alunoComponent.delete(rg);
    }
    
    @PutMapping
    private void alterar(@RequestBody Aluno aluno) {
    	 alunoComponent.alterar(aluno);
    }
}