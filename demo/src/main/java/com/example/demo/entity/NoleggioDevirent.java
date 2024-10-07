package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veicolo")
public class NoleggioDevirent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnoleggio", nullable = false)
    private int id;

    @Column(name = "data", nullable = true)
    private String data;

    @Column(name = "numero_contratto", nullable = true)
    private String numero_contratto;

    @Column(name = "nome_azienda", nullable = true)
    private String nome_azienda;

    @Column(name = "modello_veicolo", nullable = true)
    private String modello_veicolo;

    @Column(name = "targa_veicolo", nullable = true)
    private String targa_veicolo;

    @Column(name = "cauzione", nullable = true)
    private String cauzione;

    @Column(name = "data2", nullable = true)
    private String data2;

    @Column(name = "data_riconsegna", nullable = true)
    private String data_riconsegna;

    @Column(name = "km_rientro", nullable = true)
    private String km_rientro;

    @Column(name = "data_rientro", nullable = true)
    private String data_rientro;

    @Column(name = "ora_rientro", nullable = true)
    private String ora_rientro;

    @Column(name = "km_uscita", nullable = true)
    private String km_uscita;

    @Column(name = "data_uscita", nullable = true)
    private String data_uscita;

    @Column(name = "ora_uscita", nullable = true)
    private String ora_uscita;

    @Column(name = "km_percorsi", nullable = true)
    private String km_percorsi;

    @Column(name = "giorni", nullable = true)
    private String giorni;

    @Column(name = "carburante", nullable = true)
    private String carburante;

    @Column(name = "accessori", nullable = true)
    private String accessori;

    @Column(name = "nome_conducente", nullable = true)
    private String nome_conducente;

    @Column(name = "luogo_nascita_conducente", nullable = true)
    private String luogo_nascita_conducente;

    @Column(name = "data_nascita_conducente", nullable = true)
    private String data_nascita_conducente;

    @Column(name = "residenza_conducente", nullable = true)
    private String residenza_conducente;

    @Column(name = "via_conducente", nullable = true)
    private String via_conducente;

    @Column(name = "cell_conducente", nullable = true)
    private String cell_conducente;

    @Column(name = "patente_conducente", nullable = true)
    private String patente_conducente;

    @Column(name = "data_patente_conducente", nullable = true)
    private String data_patente_conducente;

    @Column(name = "rilascio_patente_conducente", nullable = true)
    private String rilascio_patente_conducente;

    @Column(name = "scadenza_patente_conducente", nullable = true)
    private String scadenza_patente_conducente;

    @Column(name = "nome_sec_conducente", nullable = true)
    private String nome_sec_conducente;

    @Column(name = "luogo_nascita_sec_conducente", nullable = true)
    private String luogo_nascita_sec_conducente;

    @Column(name = "data_nascita_sec_conducente", nullable = true)
    private String data_nascita_sec_conducente;

    @Column(name = "residenza_sec_conducente", nullable = true)
    private String residenza_sec_conducente;

    @Column(name = "via_sec_conducente", nullable = true)
    private String via_sec_conducente;

    @Column(name = "cell_sec_conducente", nullable = true)
    private String cell_sec_conducente;

    @Column(name = "patente_sec_conducente", nullable = true)
    private String patente_sec_conducente;

    @Column(name = "data_patente_sec_conducente", nullable = true)
    private String data_patente_sec_conducente;

    @Column(name = "rilascio_patente_sec_conducente", nullable = true)
    private String rilascio_patente_sec_conducente;

    @Column(name = "scadenza_patente_sec_conducente", nullable = true)
    private String scadenza_patente_sec_conducente;

    @Column(name = "accendisigari", nullable = true)
    private boolean accendisigari;    

    @Column(name = "autoradio", nullable = true)
    private boolean autoriadio;
    
    @Column(name = "antenna", nullable = true)
    private boolean antenna;
    
    @Column(name = "assicurazione", nullable = true)
    private boolean assicurazione; 

    @Column(name = "cartaverde", nullable = true)
    private boolean cartaverde;

    @Column(name = "ruotascorta", nullable = true)
    private boolean ruotascorta;
    
    @Column(name = "vetri", nullable = true)
    private boolean vetri;
    
    @Column(name = "copriruota", nullable = true)
    private boolean copriruota;
    
    @Column(name = "fanaleria", nullable = true)
    private boolean fanaleria;
    
    @Column(name = "garanzia", nullable = true)
    private boolean garanzia;
    
    @Column(name = "tappezzeria", nullable = true)
    private boolean tappezzeria;
    
    @Column(name = "pneumatici", nullable = true)
    private boolean pneumatici;
    
    @Column(name = "crick", nullable = true)
    private boolean crick;
    
    @Column(name = "triangolo", nullable = true)
    private boolean triangolo; 

    @Column(name = "giubbetto", nullable = true)
    private boolean giubbetto;
    
    @Column(name = "tariffa", nullable = true)
    private String tariffa;

    @Column(name = "franchigia", nullable = true)
    private String franchigia;

    @Column(name = "deposito_cauzionale", nullable = true)
    private String deposito_cauzionale;

    @Column(name = "corrispettivo_non_detraibile", nullable = true)
    private String corrispettivo_non_detraibile;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "file_name", nullable = true)
    private String filename;

    @Lob
    @Column(name = "immagine_sinistri", nullable = true, length = 16777213)
    private byte[] immagine_sinistri;

}
