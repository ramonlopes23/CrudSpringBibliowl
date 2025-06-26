package com.crud.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.crud.model.Livro;
import com.crud.crud.service.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
    
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> listaTodos(){
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        Optional<Livro> livro = livroService.buscarPorId(id);
        return livro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado){
        return livroService.buscarPorId(id).map(livro->{
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEmprestado(livroAtualizado.isEmprestado());
            livro.setAluno(livroAtualizado.getAluno());
            livroService.salvar(livro);
            return ResponseEntity.ok(livro);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(livroService.buscarPorId(id).isPresent()){
            livroService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}