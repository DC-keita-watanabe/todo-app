package com.example.sample_demo;

import java.util.List;

public class TodoResponse {
	private List<Todo> tasks;

    public TodoResponse(List<Todo> tasks) {
        this.tasks = tasks;
    }

    public List<Todo> getTasks() {
        return tasks;
    }

    public void setTasks(List<Todo> tasks) {
        this.tasks = tasks;
    }
}
