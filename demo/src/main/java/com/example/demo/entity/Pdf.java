package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "pdf")
public class Pdf {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pdf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "imagedata")
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser", nullable = true)
    private Utente utente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = true)
    private Azienda azienda;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idclienti", nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idinterventi", nullable = true)
    private Intervento intervento;
}
