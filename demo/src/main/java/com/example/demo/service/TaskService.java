package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Task;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;

public interface TaskService {
    
    Task createTask(Task task);

    Optional<Task> getTaskById(int taskId);

    List<Task> getAllTasks();

    List<Task> getAllTasksByUtente(Utente utente);

    List<Task> getAllTasksByConcluso(boolean concluso);

    List<Task> getAllTasksByTipologia(TipologiaTask tipologia);

    List<Task> getTasksByUtenteAndTipologia(Utente utente, TipologiaTask tipologia);

    List<Task> getTasksByTipologiaAndConcluso(TipologiaTask tipologia, boolean concluso);

    List<Task> getTasksByUtenteAndConcluso(Utente utente, boolean concluso);

    void deleteTask(int taskId);
}
