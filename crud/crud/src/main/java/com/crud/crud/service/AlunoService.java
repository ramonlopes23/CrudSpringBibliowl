package com.crud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.model.Aluno;
import com.crud.crud.model.Livro;
import com.crud.crud.repository.AlunoRepository;

@Service
public class AlunoService {
 
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno){
        if (aluno.getLivros() != null) {
        for (Livro livro : aluno.getLivros()) {
            livro.setAluno(aluno);
        }
    }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos(){
        return (List<Aluno>) alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        alunoRepository.deleteById(id);
    }

}