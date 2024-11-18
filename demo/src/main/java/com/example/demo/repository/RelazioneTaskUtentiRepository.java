package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RelazioneTaskUtenti;
import com.example.demo.entity.TaskOld;
import com.example.demo.entity.Utente;

@Repository
public interface RelazioneTaskUtentiRepository extends JpaRepository<RelazioneTaskUtenti, Integer>{
    List<RelazioneTaskUtenti> findByTask(TaskOld task);
    List<RelazioneTaskUtenti> findByUtente(Utente utente);
}
