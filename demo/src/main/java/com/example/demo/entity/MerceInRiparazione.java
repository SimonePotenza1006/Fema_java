package com.example.demo.entity;
import java.util.Date;
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
@Table(name = "merce_riparazione")
public class MerceInRiparazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "data_arrivo_merce")
    private Date data;

    @Column(name = "articolo")
    private String articolo;

    @Column(name = "accessori")
    private String accessori;

    @Column(name = "difetto_riscontrato")
    private String difetto_riscontrato;

    @Column(name = "data_presa_in_carico")
    private Date data_presa_in_carico;

    @Column(name = "password")
    private String password;

    @Column(name = "dati")
    private String dati;

    @Column(name = "preventivo")
    private Boolean preventivo;

    @Column(name = "presenza_magazzino")
    private Boolean presenza_magazzino;

    @Column(name = "importo_preventivato", nullable = true)
    private double importo_preventivato;

    @Column(name = "data_comunica_preventivo", nullable = true)
    private Date data_comunica_preventivo;

    @Column(name = "preventivo_accettato", nullable = true)
    private Boolean preventivo_accettato;

    @Column(name = "data_accettazione_preventivo", nullable = true)
    private Date data_accettazione_preventivo;

    @Column(name = "diagnosi")
    private String diagnosi;

    @Column(name = "risoluzione")
    private String risoluzione;

    @Column(name = "data_conclusione")
    private Date data_conclusione;

    @Column(name = "prodotti_installati")
    private String prodotti_installati;

    @Column(name = "data_consegna")
    private Date data_consegna;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser")
    private Utente utente;

}
