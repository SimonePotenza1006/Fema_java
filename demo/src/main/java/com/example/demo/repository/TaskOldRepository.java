package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.TaskOld;
import com.example.demo.entity.TipologiaTask;
import com.example.demo.entity.Utente;

@Repository
public interface TaskOldRepository extends JpaRepository<TaskOld, Integer> {

    // Trova tutti i task e ordina per id in ordine decrescente
    List<TaskOld> findAllByOrderByIdDesc();

    // Trova tutti i task associati a un utente specifico, ordinati per id desc
    List<TaskOld> findByUtenteOrderByIdDesc(Utente utente);

    // Trova tutti i task con una specifica tipologia, ordinati per id desc
    List<TaskOld> findByTipologiaOrderByIdDesc(TipologiaTask tipologia);

    // Trova tutti i task con stato "concluso", ordinati per id desc
    List<TaskOld> findByConclusoOrderByIdDesc(boolean concluso);

    // Trova tutti i task di un utente e tipologia specifici, ordinati per id desc
    List<TaskOld> findByUtenteAndTipologiaOrderByIdDesc(Utente utente, TipologiaTask tipologia);

    // Trova tutti i task di una tipologia specifica e con stato "concluso", ordinati per id desc
    List<TaskOld> findByTipologiaAndConclusoOrderByIdDesc(TipologiaTask tipologia, boolean concluso);

    List<TaskOld> findByUtenteAndConclusoOrderByIdDesc(Utente utente, boolean concluso);
}

