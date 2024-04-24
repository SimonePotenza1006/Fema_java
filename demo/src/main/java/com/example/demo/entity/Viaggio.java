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
@Table(name = "viaggio")
public class Viaggio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idviaggio", nullable = false)
    private int id;

    @Column(name = "destinazione")
    private String destinazione;

    @Column(name = "data_arrivo")
    private Date data_arrivo;

    @Column(name = "data_partenza" )
    private Date data_partenza;

    @ManyToOne(cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idattivita")
    private Attivita attivita;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_viaggi_carte", joinColumns = { 
    //     @JoinColumn(name = "FK_IDViaggio")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_IDCarta")
    // })
    // private List<CartaDiCredito> carte;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_viaggio_attrezzatura", joinColumns = { 
    //     @JoinColumn(name = "FK_idviaggio")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_idattrezzatura")
    // })
    // private List<Attrezzatura> attrezzature;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_viaggio_user", joinColumns = { 
    //     @JoinColumn(name = "FK_IdViaggio")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_IdUser")
    // })
    // private List<Utente> utenti;
}
