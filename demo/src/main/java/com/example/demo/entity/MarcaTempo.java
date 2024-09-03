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
@Table(name = "marcatempo")
public class MarcaTempo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarcatempo", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
	
    @Column(name = "gps")
    private String gps;
    
    @Column(name = "gpsu")
    private String gpsu;
    
    @Column(name = "data")
    private Date data;
    
    @Column(name = "datau")
    private Date datau;
    
    @Column(name = "ingresso")
    private Boolean ingresso;   
    
    @Column(name = "edit", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean edit;

    @Column(name = "editu", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean editu;
    
    @Lob
    @Column(name = "imagedata", length = 16777213)//columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;
    
    @ManyToOne(cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)//, optional = true)
    @JoinColumn(name = "idviaggio", nullable = false)
    private Viaggio viaggio;
    
    @ManyToOne(cascade = CascadeType.MERGE)//, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "iduser", nullable = false) //ruolo_id è il nome della colonna fk, non ruolo. referencedColumnName invece si riferisce all'id della tabella ruolo
    private Utente utente;

    @ManyToOne //(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "iduser", nullable = true)
    private Utente utenteEdit;
}
