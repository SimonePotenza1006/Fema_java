package com.example.demo.entity;

import java.util.Date;
import java.util.List;

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
@Table(name = "sopralluogo")
public class Sopralluogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsopralluogo", nullable = false)
    private int id;

    @Column(name = "data")
    private Date data;

    @Column(name = "posizione")
    private String posizione;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @ManyToOne(cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idclienti", nullable = false)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idtipologia_intervento", nullable = false)
    private TipologiaIntervento tipologia;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idUser")
    private Utente utente;

}
