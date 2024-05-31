package com.example.demo.entity;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.OnDelete;
import org.w3c.dom.Text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Column(name = "data_apertura_intervento")
    private Date data_apertura_intervento;

    @Column(name = "data_intervento")
    private Date data;

    @Column(name = "orario_appuntamento", nullable = true)
    private LocalDateTime orario_appuntamento;

    @Column(name = "orario_inizio")
    private LocalDateTime orario_inizio;

    @Column(name = "orario_fine")
    private LocalDateTime orario_fine;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "importo_intervento", nullable = true)
    private Double importo_intervento;

    @Column(name = "acconto", nullable = true)
    private Double acconto;

    @Column(name = "assegnato")
    private boolean assegnato;

    @Column(name = "conclusione_parziale", nullable = true)
    private boolean conclusione_parziale;

    @Column(name = "concluso")
    private boolean concluso;

    @Column(name = "saldato")
    private boolean saldato;

    @Column(name = "note")
    private String note;

    @Column(name = "relazione_tecnico")
    private String relazione_tecnico;

    @Lob
    @Column(name = "firma_cliente", length = 16777213)
    private byte[] firma_cliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser") 
    private Utente utente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idVeicolo")
    private Veicolo veicolo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_merceRiparazione")
    private MerceInRiparazione merce;

    @ManyToOne 
    @JoinColumn(name = "FK_idTipologia_intervento", nullable = false)
    private TipologiaIntervento tipologia;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idCategoria_specifica", nullable = true)
    private CategoriaInterventoSpecifico categoria_intervento_specifico;

    @ManyToOne 
    @JoinColumn(name = "FK_idtipologia_pagamento", nullable = true)
    private TipologiaPagamento tipologia_pagamento;

    @ManyToOne(cascade = CascadeType.MERGE)// fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_iddestinazione", nullable = false)
    private Destinazione destinazione;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idgruppo", nullable = true)
    private GruppoInterventi gruppo;
}