package com.example.demo.entity;

import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class NotaTecnico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private Utente utente;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "nota", nullable = false)
    private String nota;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "idinterventi")
    private Intervento intervento;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "idclienti")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "iddestinazione")
    private Destinazione destinazione;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "idsopralluogo")
    private Sopralluogo sopralluogo;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "idMerce")
    private MerceInRiparazione merce;


}
