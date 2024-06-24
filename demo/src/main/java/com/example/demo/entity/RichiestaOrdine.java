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
@Table(name = "richiesta_ordine")
public class RichiestaOrdine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idordini", nullable = false)
    private int id;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idclienti")
    private Cliente cliente;

    @Column(name = "data_creazione")
    private Date data_creazione;

    @ManyToOne 
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @Column(name = "presa_visione", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean presa_visione;

    @Column(name = "ordinato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean ordinato;

    @Column(name = "arrivato", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean arrivato;

}
