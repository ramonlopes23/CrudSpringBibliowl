package com.crud.crud.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.crud.crud.model.Livro;
import com.crud.crud.repository.LivroRepository;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    
    public List<Livro> listarTodos(){
        return (List<Livro>) livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public void deletarPorId(Long id){
        livroRepository.deleteById(id);
    }
}
