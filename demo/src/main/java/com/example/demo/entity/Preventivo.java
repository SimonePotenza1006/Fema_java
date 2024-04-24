package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "preventivo")
public class Preventivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpreventivi", nullable = false)
    private int id;

    @Column(name = "data_creazione", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data_creazione;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Azienda azienda;

    @Column(name = "categoria_merceologica")
    private String categoria_merceologica;

    @Column(name = "listino")
    private String listino;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "importo")
    private float importo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idclienti", nullable = true)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "iddestinazione", nullable = true) 
    private Destinazione destinazione;

    @Column(name = "accettato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean accettato;

    @Column(name = "rifiutato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean rifiutato;

    @Column(name = "attesa", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean attesa;

    @Column(name = "pendente", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean pendente;

    @Column(name = "consegnato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean consegnato;

    @Column(name = "provvigioni")
    private Double provvigioni;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id")
    private Agente agente;

    @Column(name = "data_accettazione")
    private LocalDateTime data_accettazione;

    @Column(name = "data_consegna")
    private LocalDateTime data_consegna;

}
