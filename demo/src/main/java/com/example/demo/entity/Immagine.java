package com.example.demo.entity;

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
@Table(name = "immagine")
public class Immagine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "imagedata", length = 16777213)
    private byte[] imageData;

    @Column(name = "name", nullable = false)
    private String name;
	
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne(optional = true)
    @JoinColumn(referencedColumnName = "id_spesa_veicolo")
    private SpesaVeicolo spesaVeicolo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idinterventi")
    private Intervento intervento;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idsopralluogo")
    private Sopralluogo sopralluogo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idveicolo")
    private Veicolo veicolo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idMerce")
    private MerceInRiparazione merceInRiparazione;
}
