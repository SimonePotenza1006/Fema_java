package com.example.demo.service.impl;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.TaskService;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Task;
import com.example.demo.entity.Utente;
import com.example.demo.repository.TaskRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(int taskId){
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllTasksOrderByDesc() {
        List<Task> optionalTasks = taskRepository.findAllByOrderByIdDesc();
        return optionalTasks;
    }

    @Override
    public List<Optional<Task>> getTaskByUtente(Utente utente){
        List<Optional<Task>> optionalTasks = taskRepository.findByUtente(utente);
        return optionalTasks;
    }

    @Override
    public List<Optional<Task>> getTaskByCliente(Cliente cliente){
        List<Optional<Task>> optionalTasks = taskRepository.findByCliente(cliente);
        return optionalTasks;
    }

    @Override
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int taskId){
        taskRepository.deleteById(taskId);
    }

}
