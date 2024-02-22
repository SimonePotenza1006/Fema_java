package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    private int id;

    @Column(name = "attivo", nullable = false)
    private Boolean attivo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cellulare", nullable = false)
    private String cellulare;

    @Column(name = "codice_fiscale", nullable = false)
    private String codice_fiscale;

    @Column(name = "iban", nullable = false)
    private String iban;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "iduser_role")
    private Ruolo ruolo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "idtipologia_intervento")
    private TipologiaIntervento tipologia_intervento;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_cantiere_utente", joinColumns = { 
    //     @JoinColumn(name = "FK_idutente")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_idcantiere")
    // })
    // private List<Cantiere> cantieri;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    // @JoinTable(name = "relazione_viaggio_user", joinColumns = { 
    //     @JoinColumn(name = "FK_IdUser")
    // }, 
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_IdViaggio")
    // })
    // private List<Viaggio> viaggi;

    // @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    // @JoinTable(name = "relazione_intervento_utenti", joinColumns = {
    //     @JoinColumn(name = "FK_idutente")
    // },
    // inverseJoinColumns = {
    //     @JoinColumn(name = "FK_idintervento")
    // })
    // private List<Intervento> interventi;

    // Costruttore con parametro int per l'ID dell'utente
//     @JsonCreator
//     public Utente(
//         @JsonProperty("id") String id,
//         @JsonProperty("attivo") Boolean attivo,
//         @JsonProperty("nome") String nome,
//         @JsonProperty("cognome") String cognome,
//         @JsonProperty("email") String email,
//         @JsonProperty("password") String password,
//         @JsonProperty("cellulare") String cellulare,
//         @JsonProperty("codice_fiscale") String codice_fiscale,
//         @JsonProperty("iban") String iban,
//         @JsonProperty("ruolo") int idRuolo, // Accetta solo l'ID del ruolo
//         @JsonProperty("tipologiaIntervento") int idTipologiaIntervento, // Accetta solo l'ID della tipologia di intervento
//         @JsonProperty("cantieri") List<Cantiere> cantieri,
//         @JsonProperty("viaggi") List<Viaggio> viaggi
//         //@JsonProperty("interventi") List<Intervento> interventi
//     ) {
//     this.id = Integer.parseInt(id);
//     this.attivo = attivo;
//     this.nome = nome;
//     this.cognome = cognome;
//     this.email = email;
//     this.password = password;
//     this.cellulare = cellulare;
//     this.codice_fiscale = codice_fiscale;
//     this.iban = iban;
//     this.ruolo = new Ruolo(idRuolo); // Carica il ruolo dal database utilizzando l'ID
//     this.tipologiaIntervento = new TipologiaIntervento(idTipologiaIntervento); // Carica la tipologia di intervento dal database utilizzando l'ID
//     this.cantieri = cantieri;
//     this.viaggi = viaggi;
//     //this.interventi = interventi;
// }

    

}
