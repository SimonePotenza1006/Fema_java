package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
@Table(name = "preventivo")
public class Preventivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpreventivi", nullable = false)
    private int id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "importo")
    private float importo;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idclienti", nullable = false) //ruolo_id è il nome della colonna fk, non ruolo. referencedColumnName invece si riferisce all'id della tabella ruolo
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iduser", nullable = false) //ruolo_id è il nome della colonna fk, non ruolo. referencedColumnName invece si riferisce all'id della tabella ruolo
    private Utente utente;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_preventivi_listini", joinColumns = { 
        @JoinColumn(name = "FK_idpreventivo")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idlistino")
    })
    private List<CategoriaPrezzoListino> listini;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_preventivo_prodotti", joinColumns = { 
        @JoinColumn(name = "FK_idpreventivo")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idprodotto")
    })
    private List<Prodotto> prodotti;
}