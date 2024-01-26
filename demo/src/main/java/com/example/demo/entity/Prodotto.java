package com.example.demo.entity;

import java.util.Date;
import java.util.List;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "prodotto")
public class Prodotto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodotti", nullable = false)
    private int id;

    @Column(name = "codice_barre")
    private String codice_barre;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "giacenza")
    private String giacenza;

    @Column(name = "unita_misura", nullable = false)
    private String unita_misura;

    @Column(name = "prezzo_fornitore")
    private float prezzo_fornitore;

    @Column(name = "codice_per_fornitore")
    private String codice_per_fornitore;

    @Column(name = "costo_medio")
    private float costo_medio;

    @Column(name = "ultimo_costo")
    private float ultimo_costo;

    @ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idcategoria_prodotto")
    private CategoriaProdotto categoriaProdotto;

    @ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idfornitori")
    private Fornitore fornitore;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_ddt_prodotti", joinColumns = { 
        @JoinColumn(name = "FK_idprodotto")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idddt")
    })
    private List<Utente> utenti;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_preventivo_prodotti", joinColumns = { 
        @JoinColumn(name = "FK_idprodotto")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idpreventivo")
    })
    private List<Preventivo> preventivi;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_prodotto_sopralluogo", joinColumns = { 
        @JoinColumn(name = "FK_idprodotto")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idsopralluogo")
    })
    private List<Sopralluogo> sopralluoghi;
}
