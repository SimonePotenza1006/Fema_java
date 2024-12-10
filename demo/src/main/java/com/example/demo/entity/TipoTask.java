package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;


@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_task")
public class TipoTask {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipologia", nullable = false)
    private int id;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "iduser", nullable = true)
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name = "FK_idUser") 
    private Utente utentecreate;
}
