package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import org.w3c.dom.Text;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prodotto_final")
public class Prodotto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cod_danea")
    private String codice_danea;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "sottocategoria")
    private String sottocategoria;

    @Column(name = "unita_misura")
    private String unita_misura;

    @Column(name = "iva")
    private String iva;

    @Column(name = "note")
    private String note;

    @Column(name = "cod_barre")
    private String cod_barre_danea;

    @Column(name = "produttore")
    private String produttore;

    @Column(name = "cod_fornitore")
    private String cod_fornitore;

    @Column(name = "fornitore")
    private String fornitore;

    @Column(name = "cod_prod_forn")
    private String cod_prod_forn;

    @Column(name = "prezzo_forn")
    private Double prezzo_fornitore;

    @Column(name = "note_fornitura")
    private String note_fornitura;

    @Column(name = "qta_giacenza")
    private Double qta_giacenza;

    @Column(name = "qta_impegnata")
    private Double qta_impegnata;

    @Column(name = "costo_medio_acq")
    private Double costo_medio_acquisto;

    @Column(name = "ultimo_costo_acq")
    private Double ultimo_costo_acquisto;

    @Column(name = "prezzo_medio_vend")
    private Double prezzo_medio_vendita;

    @Column(name = "stato_magazzino")
    private String stato_magazzino;

    @Column(name = "lotto_seriale")
    private String lotto_seriale;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_ddt_prodotti", joinColumns = { 
    //     @JoinColumn(name = "FK_idprodotto")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_idddt")
    // })
    // private List<Ddt> lista_ddt;


    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_prodotto_sopralluogo", joinColumns = { 
        @JoinColumn(name = "FK_idprodotto")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idsopralluogo")
    })
    private List<Sopralluogo> sopralluoghi;

    @OneToMany(mappedBy = "prodotto")
    private List<RelazioneDdtProdotto> relazioniDdt;
}
