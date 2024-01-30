package com.example.demo.entity;
import java.util.List;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

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
import jakarta.persistence.Lob;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credenziali_cliente")
public class CredenzialiCliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrelazione_credenziali_clienti")
    private int id;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne(cascade = CascadeType.MERGE)// fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "idclienti")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)// fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utente;
}
