package com.example.sample_demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunnner implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("コマンドラインランナー実行開始");
        
        List<Todo> todos = readTodoFromCSV("historical_figures.csv");
        todoRepository.saveAll(todos);
        
        System.out.println("コマンドラインランナー実行終了");
    }
    
    private List<Todo> readTodoFromCSV(String fileName) {
        List<Todo> todos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // ヘッダーをスキップ
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String taskName = fields[0];
                String taskDescription = fields[1];
                String assignPersonName = fields[2];
                todos.add(new Todo(taskName, taskDescription, assignPersonName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todos;
    }
}

