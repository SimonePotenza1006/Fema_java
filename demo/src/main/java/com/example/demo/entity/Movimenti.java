package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimenti")
public class Movimenti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimento", nullable = false)
    private int id;

    @Column(name = "data_movimentazione", nullable = false)
    private Date data;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentazione", nullable = false)
    private TipoMovimentazione tipo_movimentazione;

    @Column(name = "importo", nullable = false)
    private Double importo;

    @ManyToOne
    @JoinColumn(name = "id_tipologia_movimento")
    private TipologiaMovimento tipologia;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser")
    private Utente utente;

    @Column(name = "data_creazione", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCreazione;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idinterventi", nullable = true)
    private Intervento intervento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idclienti", nullable = true)
    private Cliente cliente;
}


