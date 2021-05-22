package io.github.apitodo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.apitodo.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    

}
