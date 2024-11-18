package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.TaskOld;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;

public interface TaskOldService {
    
    TaskOld createTask(TaskOld task);

    Optional<TaskOld> getTaskById(int taskId);

    List<TaskOld> getAllTasks();

    List<TaskOld> getAllTasksByUtente(Utente utente);

    List<TaskOld> getAllTasksByConcluso(boolean concluso);

    List<TaskOld> getAllTasksByTipologia(TipologiaTask tipologia);

    List<TaskOld> getTasksByUtenteAndTipologia(Utente utente, TipologiaTask tipologia);

    List<TaskOld> getTasksByTipologiaAndConcluso(TipologiaTask tipologia, boolean concluso);

    List<TaskOld> getTasksByUtenteAndConcluso(Utente utente, boolean concluso);

    void deleteTask(int taskId);
}
