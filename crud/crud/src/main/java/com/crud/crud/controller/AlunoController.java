package com.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.model.Aluno;
import com.crud.crud.service.AlunoService;


@RestController
public class AlunoController {
    
   
    private final AlunoService alunoService;
    
    public AlunoController(AlunoService service){
        this.alunoService = service;
    }


    @PostMapping("/alunos")
    public Aluno save(@RequestBody Aluno a){
        Aluno novoAluno = alunoService.salvar(a);
        return novoAluno;
    }

    @GetMapping("/alunos")
    public List<Aluno> findAll(){
        return (List<Aluno>) alunoService.listarTodos();
    }

    @GetMapping("/teste")
    public String teste() {
        return "Servidor Funcionando |";
    }
    
    @GetMapping("/alunos/{id}")
    public ResponseEntity<Aluno> buscaPorID(@PathVariable Long id){
        return alunoService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno) {
    return alunoService.buscarPorId(id)
        .map(aluno -> {
            aluno.setNome(novoAluno.getNome());
            aluno.setCurso(novoAluno.getCurso());
            aluno.setSexo(novoAluno.getSexo());
            alunoService.salvar(aluno);
            return ResponseEntity.ok(aluno);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
    if (alunoService.buscarPorId(id).isPresent()) {
        alunoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
    }



}
