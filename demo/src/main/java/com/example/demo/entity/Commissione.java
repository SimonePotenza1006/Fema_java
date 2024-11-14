package com.example.demo.entity;
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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;



@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commissione")
public class Commissione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "data_creazione", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data_creazione;

    @Column(name = "data", nullable = true)
    private LocalDateTime data;

    @Column(name = "descrizione")
    private String descrizione;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "priorita", nullable = true)
    private Priorita priorita = Priorita.NULLA;

    @Column(name = "concluso")
    private boolean concluso;

    @Column(name = "attivo")
    private boolean attivo;

    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser")
    private Utente utente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idinterventi", nullable = true)
    private Intervento intervento;
}
