package com.example.demo.entity;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "ordini_per_intervento")
public class OrdinePerIntervento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idordini", nullable = false)
    private int id;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne (cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idinterventi")
    private Intervento intervento;

    @Column(name = "data_creazione")
    private Date data_creazione;

    @Column(name = "data_presa_visione")
    private Date data_presa_visione;

    @ManyToOne (cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idfornitori")
    private Fornitore fornitore;
}
