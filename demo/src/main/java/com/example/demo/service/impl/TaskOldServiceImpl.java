package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskOld;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;
import com.example.demo.repository.TaskOldRepository;
import com.example.demo.service.TaskOldService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskOldServiceImpl implements TaskOldService{
    
    @Autowired
    private TaskOldRepository taskRepository;

    @Override
    public TaskOld createTask(TaskOld task){
        return taskRepository.save(task);
    }

    @Override
    public Optional<TaskOld> getTaskById(int taskId){
        return taskRepository.findById(taskId);
    }

    @Override
    public List<TaskOld> getAllTasks(){
        return taskRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<TaskOld> getAllTasksByUtente(Utente utente){
        return taskRepository.findByUtenteOrderByIdDesc(utente);
    }

    @Override
    public List<TaskOld> getAllTasksByConcluso(boolean concluso){
        return taskRepository.findByConclusoOrderByIdDesc(concluso);
    }

    @Override
    public List<TaskOld> getAllTasksByTipologia(TipologiaTask tipologia){
        return taskRepository.findByTipologiaOrderByIdDesc(tipologia);
    }

    @Override
    public List<TaskOld> getTasksByUtenteAndTipologia(Utente utente, TipologiaTask tipologia){
        return taskRepository.findByUtenteAndTipologiaOrderByIdDesc(utente, tipologia);
    }

    @Override
    public List<TaskOld> getTasksByTipologiaAndConcluso(TipologiaTask tipologia, boolean concluso){
        return taskRepository.findByTipologiaAndConclusoOrderByIdDesc(tipologia, concluso);
    }

    @Override
    public List<TaskOld> getTasksByUtenteAndConcluso(Utente utente, boolean concluso){
        return taskRepository.findByUtenteAndConclusoOrderByIdDesc(utente, concluso);
    }

    @Override
    public void deleteTask(int taskId){
        taskRepository.deleteById(taskId);
    }
}
