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
public class Clienti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclienti", nullable = false)
    private int id;

    @Column(name = "codice_fiscale")
    private String codice_fiscale;

    @Column(name = "partita_iva")
    private String partita_iva;

    @Column(name = "denominazione", nullable = false)
    private String denominazione;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "cap")
    private String cap;

    @Column(name = "citta")
    private String citta;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "nazione")
    private String nazione;

    @Column(name = "recapito_fatturazione_elettronica")
    private String recapito_fatturazione_elettronica;

    @Column(name = "riferimento_amministrativo")
    private String riferimento_amministrativo;

    @Column(name = "referente")
    private String referente;

    @Column(name = "fax")
    private String fax;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "cellulare")
    private String cellulare;

    @Column(name = "email")
    private String email;

    @Column(name = "pec")
    private String pec;

    @Column(name = "note")
    private String nome;

}
