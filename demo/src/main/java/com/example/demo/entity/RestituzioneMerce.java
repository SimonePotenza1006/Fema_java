package com.example.demo.entity;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.OnDelete;
import org.w3c.dom.Text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restituzione_merce")
public class RestituzioneMerce {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restituzione", nullable = false)
    private int id;

    @Column(name = "prodotto", nullable = true)
    private String prodotto;

    @Column(name = "data_acquisto", nullable = true)
    private Date data_acquisto;

    @Column(name = "difetto_riscontrato", nullable = true)
    private String difetto_riscontrato;

    @ManyToOne
    @JoinColumn(name = "idfornitori", nullable = true)
    private Fornitore fornitore;

    @Column(name = "data_riconsegna", nullable = true)
    private Date data_riconsegna;

    @ManyToOne
    @JoinColumn(referencedColumnName =  "iduser")
    private Utente utenteRiconsegna;

    @Column(name = "rimborso", nullable = true)
    private Boolean rimborso;

    @Column(name = "cambio", nullable = true)
    private Boolean cambio;

    @Column(name = "data_rientro_ufficio", nullable = true)
    private Date data_rientro_ufficio;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser")
    private Utente utenteRitiro;

    @Column(name = "concluso")
    private Boolean concluso;
}
