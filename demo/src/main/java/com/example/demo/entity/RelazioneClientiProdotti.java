package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relazione_clienti_prodotti")
public class RelazioneClientiProdotti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione_clienti_prodotti", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Prodotto prodotto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idclienti", nullable = false)
    private Cliente cliente;

    @Column(name = "prezzo")
    private Double prezzo;

    @Column(name = "data")
    private LocalDateTime data;
}
