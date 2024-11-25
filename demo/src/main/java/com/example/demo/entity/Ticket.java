package com.example.demo.entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket", nullable = false)
    private int id;

    @Column(name = "data_creazione", nullable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime data_creazione;

    // @Column(name = "data_intervento", nullable = true)
    // private Date data;

    // @Column(name = "orario_appuntamento", nullable = true)
    // private LocalDateTime orario_appuntamento;

    // @Column(name = "titolo", nullable = true)
    // private String titolo;

    // @Enumerated(EnumType.STRING)
    // @Column(name = "priorita", nullable = true)
    // private Priorita priorita = Priorita.NULLA;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "convertito", nullable = false, columnDefinition = "boolean default false")
    private boolean convertito;

    // @ManyToOne
    // @JoinColumn(name = "FK_idCliente", nullable = true)
    // private Cliente cliente;

    @ManyToOne 
    @JoinColumn(name = "FK_idTipologia_intervento", nullable = true)
    private TipologiaIntervento tipologia;

    // @ManyToOne
    // @JoinColumn(name = "FK_iddestinazione", nullable = true)
    // private Destinazione destinazione;

    @ManyToOne
    @JoinColumn(name = "FK_idUser") 
    private Utente utente;
}
