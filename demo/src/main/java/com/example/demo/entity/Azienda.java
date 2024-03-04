package com.example.demo.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "azienda")
public class Azienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "luogo_di_lavoro", nullable = false)
    private String luogo_di_lavoro;

    @Column(name = "partita_iva")
    private String partita_iva;

    @Column(name = "pec")
    private String pec;

    @Column(name = "recapito_fatturazione_elettronica")
    private String recapito_fatturazione_elettronica;

    @Column(name = "email")
    private String email;

    @Column(name = "sito")
    private String sito;
}
