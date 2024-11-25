package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.entity.TipoTask;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;
import com.example.demo.service.TipoTaskService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.TaskServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/task")
public class TaskController {
    
    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UtenteService utenteService;
    
    @Autowired
    private TipoTaskService tipoService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
    	Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Task>> getTaskById(int taskId){
        Optional<Task> optionalTask = taskService.getTaskById(taskId);
        return new ResponseEntity<>(optionalTask, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Task>> getAllTaskByUtenteEntity(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Task> tasks = taskService.getAllTasksByUtente(utente);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{tipologiaId}")
    public ResponseEntity<List<Task>> getAllTasksByTipologia(@PathVariable("tipologiaId") int tipologiaId){
        Optional<TipoTask> tipo = tipoService.getTipoById(tipologiaId);
        List<Task> tasks = taskService.getAllTasksByTipologia(tipo);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/concluso/{status}")
    public ResponseEntity<List<Task>> getAllTasksByConcluso(@PathVariable("status") boolean concluso){
        List<Task> tasks = taskService.getAllTasksByConcluso(concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{utenteId}/tipologia/{tipologiaId}")
    public ResponseEntity<List<Task>> getAllTasksByUtenteAndTipologia(@PathVariable("utenteId") int utenteId, @PathVariable("tipologiaId") int tipologiaId){
        Optional<TipoTask> tipo = tipoService.getTipoById(tipologiaId);
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Task> tasks = taskService.getTasksByUtenteAndTipologia(utente, tipo);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{tipologiaId}/concluso/{status}")
    public ResponseEntity<List<Task>> getAllTasksByTipologiaAndConcluso(@PathVariable("tipologiaId") int tipologiaId, @PathVariable("status") boolean concluso){
        Optional<TipoTask> tipo = tipoService.getTipoById(tipologiaId);
        List<Task> tasks = taskService.getTasksByTipologiaAndConcluso(tipo, concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{utenteId}/concluso/{status}")
    public ResponseEntity<List<Task>> getAllTasksByUtenteAndConcluso(@PathVariable("utenteId") int utenteId, @PathVariable("status") boolean concluso){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Task> tasks = taskService.getTasksByUtenteAndConcluso(utente, concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task succesfully deleted!", HttpStatus.OK);
    }
}
