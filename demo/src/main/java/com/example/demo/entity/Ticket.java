package com.example.demo.entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket", nullable = false)
    private int id;

    @Column(name = "data_apertura_ticket", nullable = true)
    private Date data_apertura_intervento;

    @Column(name = "data", nullable = true)
    private Date data;

    @Column(name = "orario_appuntamento", nullable = true)
    private LocalDateTime orario_appuntamento;

    @Column(name = "orario_inizio", nullable = true)
    private LocalDateTime orario_inizio;

    @Column(name = "orario_fine", nullable = true)
    private LocalDateTime orario_fine;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;

    @Column(name = "assegnato", nullable = true)
    private boolean assegnato;

    @Column(name = "concluso", nullable = true)
    private boolean concluso;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "relazione_tecnico", nullable = true)
    private String relazione_tecnico;

    @ManyToOne
    @JoinColumn(name = "FK_idCliente", nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_idVeicolo", nullable = true)
    private Veicolo veicolo;

    @ManyToOne
    @JoinColumn(name = "FK_id_merceRiparazione", nullable = true)
    private MerceInRiparazione merce;

    @ManyToOne 
    @JoinColumn(name = "FK_idTipologia_intervento", nullable = true)
    private TipologiaIntervento tipologia;

    @ManyToOne
    @JoinColumn(name = "FK_idCategoria_specifica", nullable = true)
    private CategoriaInterventoSpecifico categoria_intervento_specifico;

    @ManyToOne 
    @JoinColumn(name = "FK_idtipologia_pagamento", nullable = true)
    private TipologiaPagamento tipologia_pagamento;

    @ManyToOne
    @JoinColumn(name = "FK_iddestinazione", nullable = true)
    private Destinazione destinazione;

}
