package com.example.demo.entity;

import java.util.List;
import java.util.Set;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "ddt")
public class Ddt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idddt", nullable = false)
    private int id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "orario", nullable = false )
    private LocalDateTime orario;

    @Lob
    @Column(name = "firma_user", length = 16777213)//columnDefinition = "MEDIUMBLOB")
    private byte[] firma_user;

    @Lob
    @Column(name = "firma_cliente", length = 16777213)//columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idcliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iddestinazione")
    private Destinazione destinazione;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idcategorie_ddt")
    private CategoriaDDT categoriaDdt;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "relazione_ddt_prodotti", joinColumns = { 
        @JoinColumn(name = "FK_idddt")
    }, 
    inverseJoinColumns = {
        @JoinColumn(name = "FK_idprodotto")
    })
    private List<Prodotto> prodotti;
} 
