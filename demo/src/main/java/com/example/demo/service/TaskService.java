package com.example.demo.service;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    
    Task createTask(Task task);

    Task getTaskById(int taskId);

    List<Task> getAllTasks();

    List<Optional<Task>> getTaskByUtente(Utente utente);

    List<Optional<Task>> getTaskByCliente(Cliente cliente);

    List<Task> getAllTasksOrderByDesc();

    Task updateTask(Task task);

    void deleteTask(int taskId);
}
