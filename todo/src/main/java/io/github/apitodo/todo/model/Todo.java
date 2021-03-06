package io.github.apitodo.todo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter //O lombok em tempo de compilação, vai gerar os gets e os sets.
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//O identiti cria o id apropriado para cada banco de dados
    private long id;

    @Column
    private String description;

    @Column
    private Boolean done;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")//Formada as datas com o padrão que passamos
    private LocalDateTime createdDate;//Data de criação;

    @Column
    private LocalDateTime doneDate; //Grava a hora e a data de quando foi feita, data de conclusão

    @PrePersist
    public void beforeSave(){
        setCreatedDate(LocalDateTime.now());//Seta a data e o horatio atual no momento que utilizamos o post no postman
    }
}
