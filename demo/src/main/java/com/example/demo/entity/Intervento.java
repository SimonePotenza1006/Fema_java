package com.example.demo.entity;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.eclipse.angus.mail.util.DefaultProvider;
import org.hibernate.annotations.OnDelete;
import org.w3c.dom.Text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name = "numerazione_danea", nullable = true)
    private String numerazione_danea;

    @Enumerated(EnumType.STRING)
    @Column(name = "priorita", nullable = true)
    private Priorita priorita = Priorita.NULLA;


    @Column(name = "data_apertura_intervento", nullable = true)
    private Date data_apertura_intervento;

    @Column(name = "data_intervento", nullable = true)
    private Date data;

    @Column(name = "orario_appuntamento", nullable = true)
    private LocalDateTime orario_appuntamento;

    @Column(name = "posizione_gps", nullable = true)
    private String posizione_gps;

    @Column(name = "orario_inizio", nullable = true)
    private LocalDateTime orario_inizio;

    @Column(name = "orario_fine", nullable = true)
    private LocalDateTime orario_fine;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;

    @Column(name = "importo_intervento", nullable = true)
    private Double importo_intervento;

    @Column(name = "prezzo_ivato", nullable = true)
    private boolean prezzo_ivato;

    @Column(name = "iva", nullable = true, columnDefinition = "int default 0")
    private int iva;

    @Column(name = "accettato_da_tecnico", nullable = true, columnDefinition = "boolean default false")
    private boolean accettato_da_tecnico;

    @Column(name = "acconto", nullable = true)
    private Double acconto;

    @Column(name = "assegnato", nullable = true)
    private boolean assegnato;

    @Column(name = "conclusione_parziale", nullable = true)
    private boolean conclusione_parziale;

    @Column(name = "concluso", nullable = true)
    private boolean concluso;

    @Column(name = "saldato", nullable = true)
    private boolean saldato;

    @Column(name = "saldato_da_tecnico", nullable = true)
    private Boolean saldato_da_tecnico;

    @Column(name = "note", nullable = true)
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
    @JoinColumn(name = "FK_idVeicolo", nullable = true)
    private Veicolo veicolo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_merceRiparazione", nullable = true)
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
    @JoinColumn(name = "FK_iddestinazione", nullable = true)
    private Destinazione destinazione;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idgruppo", nullable = true)
    private GruppoInterventi gruppo;
}