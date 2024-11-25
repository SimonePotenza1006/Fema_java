package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Task;
import com.example.demo.entity.TipoTask;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;

public interface TaskService {
    
	Task createTask(Task task);

    Optional<Task> getTaskById(int taskId);

    List<Task> getAllTasks();

    List<Task> getAllTasksByUtente(Utente utente);

    List<Task> getAllTasksByConcluso(boolean concluso);

    List<Task> getAllTasksByTipologia(Optional<TipoTask> tipologia);

    List<Task> getTasksByUtenteAndTipologia(Utente utente, Optional<TipoTask> tipologia);

    List<Task> getTasksByTipologiaAndConcluso(Optional<TipoTask> tipologia, boolean concluso);

    List<Task> getTasksByUtenteAndConcluso(Utente utente, boolean concluso);

    void deleteTask(int taskId);
}
