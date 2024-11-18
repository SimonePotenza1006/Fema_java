package com.example.demo.entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taskold")
public class TaskOld {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtask", nullable = false)
    private int id;

    @Column(name = "data_creazione", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data_creazione;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser", nullable = true)
    private Utente utente;

    @Column(name = "titolo", nullable = true)
    private String titolo;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;

    @Column(name = "concluso", nullable = true, columnDefinition = "boolean default false")
    private boolean concluso;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipologia", nullable = true)
    private TipologiaTask tipologia;

    @Column(name = "condiviso", nullable = true, columnDefinition = "boolean default false")
    private boolean condiviso;

    @ManyToOne
    @JoinColumn(name = "FK_iduser")
    private Utente utente_conclusione;

    @Column(name = "data_conclusione", nullable = true)
    private LocalDateTime data_conclusione;



}
