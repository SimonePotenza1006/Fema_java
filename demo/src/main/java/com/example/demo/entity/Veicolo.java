package com.example.demo.entity;

import java.time.LocalDate;
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
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veicolo")
public class Veicolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idveicolo", nullable = false)
    private int id;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @Column(name = "targa", nullable = true)
    private String targa;

    @Column(name = "serial_number", nullable = true)
    private String seriale;

    @Column(name = "imei", nullable = true)
    private String imei;

    @Column(name = "scadenza_gps", nullable = true)
    private Date scadenza_gps;

    @Column(name = "proprietario", nullable = false)
    private String proprietario;

    @Column(name = "chilometraggio_attuale", nullable = false)
    private int chilometraggio_attuale;

    @Column(name = "data_scadenza_bollo", nullable = true)
    private Date data_scadenza_bollo;

    @Column(name = "data_scadenza_polizza", nullable = true)
    private Date data_scadenza_polizza;

    @Column(name = "data_tagliando", nullable = true)
    private Date data_tagliando;

    @Column(name = "chilometraggio_ultimo_tagliando", nullable = true)
    private int chilometraggio_ultimo_tagliando;

    @Column(name = "soglia_tagliando", nullable = true)
    private int soglia_tagliando;

    @Column(name = "data_revisione", nullable = true)
    private Date data_revisione;

    @Column(name = "data_inversione_gomme", nullable = true)
    private Date data_inversione_gomme;

    @Column(name = "chilometraggio_ultima_inversione", nullable = true)
    private int chilometraggio_ultima_inversione;

    @Column(name = "soglia_inversione", nullable = true)
    private int soglia_inversione;

    @Column(name = "data_sostituzione_gomme", nullable = true)
    private Date data_sostituzione_gomme;

    @Column(name = "chilometraggio_ultima_sostituzione", nullable = true)
    private int chilometraggio_ultima_sostituzione;

    @Column(name = "soglia_sostituzione", nullable = true)
    private int soglia_sostituzione;
}
