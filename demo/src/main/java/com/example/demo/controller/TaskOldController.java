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

import com.example.demo.entity.TaskOld;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;
import com.example.demo.service.UtenteService;
import com.example.demo.service.impl.TaskOldServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/taskold")
public class TaskOldController {
    
    @Autowired
    private TaskOldServiceImpl taskService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<TaskOld> createTask(@RequestBody TaskOld task){
        TaskOld savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<TaskOld>> getTaskById(int taskId){
        Optional<TaskOld> optionalTask = taskService.getTaskById(taskId);
        return new ResponseEntity<>(optionalTask, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskOld>> getAllTasks(){
        List<TaskOld> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<TaskOld>> getAllTaskByUtenteEntity(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<TaskOld> tasks = taskService.getAllTasksByUtente(utente);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{tipologia}")
    public ResponseEntity<List<TaskOld>> getAllTasksByTipologia(@PathVariable("tipologia") TipologiaTask tipologia){
        List<TaskOld> tasks = taskService.getAllTasksByTipologia(tipologia);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/concluso/{status}")
    public ResponseEntity<List<TaskOld>> getAllTasksByConcluso(@PathVariable("status") boolean concluso){
        List<TaskOld> tasks = taskService.getAllTasksByConcluso(concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{utenteId}/tipologia/{tipologia}")
    public ResponseEntity<List<TaskOld>> getAllTasksByUtenteAndTipologia(@PathVariable("utenteId") int utenteId, @PathVariable("tipologia") TipologiaTask tipologia){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<TaskOld> tasks = taskService.getTasksByUtenteAndTipologia(utente, tipologia);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tipologia/{tipologia}/concluso/{status}")
    public ResponseEntity<List<TaskOld>> getAllTasksByTipologiaAndConcluso(@PathVariable("tipologia") TipologiaTask tipologia, @PathVariable("status") boolean concluso){
        List<TaskOld> tasks = taskService.getTasksByTipologiaAndConcluso(tipologia, concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/utente/{utenteId}/concluso/{status}")
    public ResponseEntity<List<TaskOld>> getAllTasksByUtenteAndConcluso(@PathVariable("utenteId") int utenteId, @PathVariable("status") boolean concluso){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<TaskOld> tasks = taskService.getTasksByUtenteAndConcluso(utente, concluso);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task succesfully deleted!", HttpStatus.OK);
    }
}
