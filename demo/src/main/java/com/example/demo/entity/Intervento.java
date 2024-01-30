package com.example.demo.entity;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.OnDelete;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "intervento")
public class Intervento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinterventi", nullable = false)
    private int id;

    @Column(name = "data_intervento")
    private Date data;

    @Column(name = "orario_inizio")
    private LocalDateTime orario_inizio;

    @Column(name = "orario_fine")
    private LocalDateTime orario_fine;

    @Column(name = "descrizione")
    private String descrizione;

    @Lob
    @Column(name = "foto", length = 16777213)
    private byte[] foto;

    @Column(name = "importo_intervento")
    private float importo_intervento;

    @Lob
    @Column(name = "firma_cliente", length = 16777213)
    private byte[] firma_cliente;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idUser", nullable = false)
    private Utente utente;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idVeicolo", nullable = false)
    private Veicolo veicolo;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idFK_idTipologia_intervento", nullable = false)
    private TipologiaIntervento tipologia_intervento;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idCategoria_specifica", nullable = false)
    private CategoriaInterventoSpecifico categoria_InterventoSpecifico;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_idtipologia_pagamento", nullable = false)
    private TipologiaPagamento tipologia_pagamento;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_iddestinazione", nullable = false)
    private Destinazione destinazione;

}
