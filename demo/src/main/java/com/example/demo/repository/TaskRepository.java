package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Task;
import com.example.demo.entity.Utente;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
    List<Task> findAllByOrderByIdDesc();
    Optional<Task> findById(int id);
    List<Optional<Task>> findByUtente(Utente utente);
    List<Optional<Task>> findByCliente(Cliente cliente);
}
