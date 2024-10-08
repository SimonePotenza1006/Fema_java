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
import jakarta.persistence.ManyToOne;
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
@Table(name = "categoria_prezzo_listino")
public class CategoriaPrezzoListino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlistino", nullable = false)
    private int id;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @Column(name = "prezzo", nullable = false)
    private float prezzo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idcategorie_intervento_specifiche", nullable = false)
    private CategoriaInterventoSpecifico categoriaInterventoSpecifico;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_preventivi_listini", joinColumns = { 
    //     @JoinColumn(name = "FK_idlistino")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_idpreventivo")
    // })
    // private List<Preventivo> preventivi;
}
