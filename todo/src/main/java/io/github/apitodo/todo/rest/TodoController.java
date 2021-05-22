package io.github.apitodo.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.apitodo.todo.model.Todo;
import io.github.apitodo.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    @Autowired
    private TodoRepository repository;
    
    @PostMapping
    public Todo save(@RequestBody Todo todo){ //"@RequestBody" Para Recepcionar os valores/objetos que são passadas via body para nossa aplicação
        return repository.save(todo);
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id){//@PathVariable: Ela é usada para mostrar para o enderenço URI(id), que o valor passado na url, sera recebido pelo parametro id 
        return repository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}


//OBS: No postman, Coloque no POST, depois vá em Body, escolha o raw e selecione o JSON,
//escolha um atributo da classe controladora, e no postman, passe algum valo para ele
//em JavaScript,
//EXEMPLO
//{ "description" : "Aprendendo JAVA"}
//Essa string sera mandado para o java via post, e pegamos essa mesma informação via