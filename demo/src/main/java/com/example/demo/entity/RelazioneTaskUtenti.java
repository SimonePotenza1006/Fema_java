package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="relazione_task_utenti")
public class RelazioneTaskUtenti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelazione")
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idtask")
    private Task task;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @Column(name = "accettato", nullable = false, columnDefinition = "boolean default false")
    private boolean accettato;

    @Column(name = "data_invio", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data_invio;
    
}
