package com.example.demo.entity;
import java.util.List;

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
@Table(name = "destinazione")
public class Destinazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddestinazione")
    private int id;

    @Column(name = "denominazione", nullable = false)
    private String denominazione;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "cap", nullable = false)
    private String cap;

    @Column(name = "citta", nullable = false)
    private String citta;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "codice_fiscale")
    private String codice_fiscale;

    @Column(name = "partita_iva")
    private String partita_iva;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "cellulare")
    private String cellulare;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idclienti")
    private Cliente cliente;
}
