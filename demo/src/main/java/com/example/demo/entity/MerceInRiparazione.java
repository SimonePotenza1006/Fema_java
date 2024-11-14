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

    @Column(name = "data_arrivo_merce", nullable = true)
    private Date data;

    @Column(name = "articolo", nullable = true)
    private String articolo;

    @Column(name = "accessori", nullable = true)
    private String accessori;

    @Column(name = "difetto_riscontrato", nullable = true)
    private String difetto_riscontrato;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "dati", nullable = true)
    private String dati;

    @Column(name = "preventivo", nullable = true)
    private Boolean preventivo;

    @Column(name = "presenza_magazzino", nullable = true)
    private Boolean presenza_magazzino;

    @Column(name = "importo_preventivato", nullable = true)
    private double importo_preventivato;

    @Column(name = "preventivo_accettato", nullable = true)
    private Boolean preventivo_accettato;

    @Column(name = "diagnosi", nullable = true)
    private String diagnosi;

    @Column(name = "risoluzione", nullable = true)
    private String risoluzione;

    @Column(name = "data_conclusione", nullable = true)
    private Date data_conclusione;

    @Column(name = "data_consegna", nullable = true)
    private Date data_consegna;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser")
    private Utente utente;
}
