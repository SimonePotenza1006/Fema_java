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
@Table(name = "immagine")
public class Immagine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
    @JoinColumn(name = "idcartella")
    private Cartella cartella;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idMerce")
    private MerceInRiparazione merceInRiparazione;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_movimento")
    private Movimenti movimento;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_restituzione")
    private RestituzioneMerce restituzione;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idtask")
    private Task task;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "idrelazione_credenziali_clienti")
    private CredenzialiCliente credenziali;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "idticket")
    private Ticket ticket;
}
