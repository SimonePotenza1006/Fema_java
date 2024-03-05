package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Task;
import com.example.demo.service.ClienteService;
import com.example.demo.service.TaskService;
import com.example.demo.service.UtenteService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/task")
public class TaskController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int taskId) {
        int idvariable = taskId;
        Task task = taskService.getTaskById(idvariable);
        if (task == null) {
            System.out.println("Task non trovato con ID: " + taskId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<Task>> getAllTasksOrderByDesc(){
        List<Task> tasks = taskService.getAllTasksOrderByDesc();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Task>>> getTaskByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Task>> tasks = taskService.getTaskByCliente(cliente);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Task>>> getTaskByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Task>> tasks = taskService.getTaskByUtente(utente);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) throws IOException{
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task successfully deleted!", HttpStatus.OK);
    }
}
