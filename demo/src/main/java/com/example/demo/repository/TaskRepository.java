package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;
import com.example.demo.entity.TipoTask;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    // Trova tutti i task e ordina per id in ordine decrescente
    List<Task> findAllByOrderByIdDesc();

    // Trova tutti i task associati a un utente specifico, ordinati per id desc
    List<Task> findByUtenteOrderByIdDesc(Utente utente);

    // Trova tutti i task con una specifica tipologia, ordinati per id desc
    List<Task> findByTipologiaOrderByIdDesc(Optional<TipoTask> tipologia);

    // Trova tutti i task con stato "concluso", ordinati per id desc
    List<Task> findByConclusoOrderByIdDesc(boolean concluso);

    // Trova tutti i task di un utente e tipologia specifici, ordinati per id desc
    List<Task> findByUtenteAndTipologiaOrderByIdDesc(Utente utente, Optional<TipoTask> tipologia);

    // Trova tutti i task di una tipologia specifica e con stato "concluso", ordinati per id desc
    List<Task> findByTipologiaAndConclusoOrderByIdDesc(Optional<TipoTask> tipologia, boolean concluso);

    List<Task> findByUtenteAndConclusoOrderByIdDesc(Utente utente, boolean concluso);
}

