package com.example.demo.entity;

import java.util.List;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "tipologia_intervento")
public class TipologiaIntervento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipologia_intervento", nullable = false)
    private int id;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_clienti_tipologia_intervento", joinColumns = { 
    //     @JoinColumn(name = "FK_IDTipologia_intervento")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_IDCliente")
    // })
    // private List<Cliente> clienti;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "relazione_user_tipologia_intervento", joinColumns = {
        @JoinColumn(name = "FK_idTipologia")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idutente")
    })
    private List<Utente> tecnici;

    
}
