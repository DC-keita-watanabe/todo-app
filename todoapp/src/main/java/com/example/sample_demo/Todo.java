package com.example.sample_demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todos")
public class Todo {

	@Id
	@GeneratedValue
	private int id;

    private String taskName;
    private String taskDescription;
    private String assignPersonName;
    
    public Todo(String taskName, String taskDescription, String assignPersonName) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.assignPersonName = assignPersonName;
    }
}
