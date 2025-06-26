package com.crud.crud.repository;

import org.springframework.data.repository.CrudRepository;
import com.crud.crud.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
