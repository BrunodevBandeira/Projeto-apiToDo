package io.github.apitodo.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.apitodo.todo.model.Todo;
import io.github.apitodo.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoApplication {

@Autowired
private TodoRepository todoRepository;

@Bean
public CommandLineRunner init(){
	return new CommandLineRunner(){
		//Inicia o código quando a aplicação é iniciado
		//O CommandLineRunner requer a implementação de um método (run) que recebe por parâmetro uma matriz de String.
		@Override
		public void run(String...args) throws Exception {
			Todo todo = new Todo();
			todo.setDescription("Estudar Spring");
			todo.setCreatedDate(LocalDateTime.now());
			todoRepository.save(todo);
		}
	};
}

//Voltar para a aula 7 e rever a aula

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
