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

    @Column(name = "data_scadenza_bollo", nullable = false)
    private Date data_scadenza_bollo;

    @Column(name = "data_scadenza_polizza", nullable = false)
    private Date data_scadenza_polizza;

    @Column(name = "data_tagliando", nullable = false)
    private Date data_tagliando;

    @Column(name = "data_revisione", nullable = false)
    private Date data_revisione;

    @Column(name = "data_inversione_gomme")
    private Date data_inversione_gomme;

    @Column(name = "data_sostituzione_gomme")
    private Date data_sostituzione_gomme;

}
