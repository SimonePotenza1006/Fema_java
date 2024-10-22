package com.example.demo.entity;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.eclipse.angus.mail.util.DefaultProvider;
import org.hibernate.annotations.OnDelete;
import org.w3c.dom.Text;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "fasi_riparazione")
public class FasiRiparazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fase", nullable = false)
    private int id;

    @Column(name = "data", nullable = true)
    private Date data;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_idUser") 
    private Utente utente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_id_merceRiparazione", nullable = true)
    private MerceInRiparazione merce;

}