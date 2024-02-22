package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="relazione_ddt_prodotti")
public class RelazioneDdtProdotto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelazione_ddt_prodotti")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idprodotti")
    private Prodotto prodotto;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idddt")
    private Ddt ddt;

    @Column(name = "quantita")
    private int quantita;

    @Column(name = "asseganto")
    private boolean assegnato;

    @Column(name = "scaricato")
    private boolean scaricato;

    @Column(name = "pendente")
    private boolean pendente;
}
