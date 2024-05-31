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
@Table(name = "spesaVeicoloSivis")
public class SpesaVeicoloSivis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data", nullable = false)
    private Date data;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id")
    private TipologiaSpesaVeicolo tipologia_spesa;

    @Column(name = "km", nullable = false)
    private String km;

    @Column(name = "importo", nullable = false)
    private String importo;

    @Column(name = "fornitoreCarburante")
    private String fornitore_carburante;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idveicolo")
    private VeicoloSivis veicolo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private UtenteSivis utente;

}
