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

    @ManyToOne
    @JoinColumn(referencedColumnName = "idinterventi")
    private Intervento intervento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idclienti")
    private Cliente cliente;

    @Column(name = "data_creazione")
    private Date data_creazione;

    @Column(name = "data_richiesta")
    private Date data_richiesta;

    @Column(name = "data_disponibilita")
    private Date data_disponibilita;

    @Column(name = "data_ultima")
    private Date data_ultima;

    @ManyToOne 
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente_presa_visione;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente_ordine;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente_consegnato;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    @Column(name = "prodotto_non_presente")
    private String prodotto_non_presente;

    @Column(name = "note")
    private String note;

    @Column(name = "aggiornamento")
    private String aggiornamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idfornitori")
    private Fornitore fornitore;

    @Column(name = "presa_visione", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean presa_visione;

    @Column(name = "ordinato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean ordinato;

    @Column(name = "arrivato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean arrivato;

    @Column(name = "consegnato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean consegnato;
}
