package com.example.demo.entity;
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
@Table(name="relazione_prodotti_intervento")
public class RelazioneProdottiIntervento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelazione_prodotti_intervento")
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idddt")
    private Ddt ddt;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idinterventi")
    private Intervento intervento;

    @Column(name = "quantita")
    private Double quantita;

    @Column(name = "presenza_storico_utente")
    private boolean presenza_storico_utente;
}
