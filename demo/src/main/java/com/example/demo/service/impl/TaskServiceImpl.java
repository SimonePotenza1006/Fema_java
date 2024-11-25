package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.entity.TipoTask;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(int taskId){
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Task> getAllTasksByUtente(Utente utente){
        return taskRepository.findByUtenteOrderByIdDesc(utente);
    }

    @Override
    public List<Task> getAllTasksByConcluso(boolean concluso){
        return taskRepository.findByConclusoOrderByIdDesc(concluso);
    }

    @Override
    public List<Task> getAllTasksByTipologia(Optional<TipoTask> tipologia){
        return taskRepository.findByTipologiaOrderByIdDesc(tipologia);
    }

    @Override
    public List<Task> getTasksByUtenteAndTipologia(Utente utente, Optional<TipoTask> tipologia){
        return taskRepository.findByUtenteAndTipologiaOrderByIdDesc(utente, tipologia);
    }

    @Override
    public List<Task> getTasksByTipologiaAndConcluso(Optional<TipoTask> tipologia, boolean concluso){
        return taskRepository.findByTipologiaAndConclusoOrderByIdDesc(tipologia, concluso);
    }

    @Override
    public List<Task> getTasksByUtenteAndConcluso(Utente utente, boolean concluso){
        return taskRepository.findByUtenteAndConclusoOrderByIdDesc(utente, concluso);
    }

    @Override
    public void deleteTask(int taskId){
        taskRepository.deleteById(taskId);
    }
}
