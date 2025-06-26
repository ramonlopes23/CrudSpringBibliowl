package com.crud.crud.repository;
import org.springframework.data.repository.CrudRepository;
import com.crud.crud.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    
} 
