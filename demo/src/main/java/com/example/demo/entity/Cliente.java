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
@Table(name = "clienti")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclienti", nullable = false)
    private int id;

    @Column(name = "cod_danea", nullable = true)
    private String cod_danea;

    @Column(name = "codice_fiscale", nullable = true)
    private String codice_fiscale;

    @Column(name = "partita_iva", nullable = true)
    private String partita_iva;

    @Column(name = "denominazione", nullable = false)
    private String denominazione;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "cap", nullable = true)
    private String cap;

    @Column(name = "citta", nullable = true)
    private String citta;

    @Column(name = "provincia", nullable = true)
    private String provincia;

    @Column(name = "nazione", nullable = true)
    private String nazione;

    @Column(name = "recapito_fatturazione_elettronica", nullable = true)
    private String recapito_fatturazione_elettronica;

    @Column(name = "riferimento_amministrativo", nullable = true)
    private String riferimento_amministrativo;

    @Column(name = "referente", nullable = true)
    private String referente;

    @Column(name = "fax", nullable = true)
    private String fax;

    @Column(name = "telefono", nullable = true)
    private String telefono;

    @Column(name = "cellulare", nullable = true)
    private String cellulare;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "pec", nullable = true)
    private String pec;

    @Column(name = "note", nullable = true)
    private String note;

}
