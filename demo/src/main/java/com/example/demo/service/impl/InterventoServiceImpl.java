package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Priorita;
import com.example.demo.entity.RelazioneUtentiInterventi;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Veicolo;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.VeicoloRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DestinazioneRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.RelazioneUtentiInterventiRepository;
import com.example.demo.repository.TipologiaInterventoRepository;
import com.example.demo.service.InterventoService;
import com.example.demo.websocket.MyWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@Service
@AllArgsConstructor
public class InterventoServiceImpl implements InterventoService{
    
    @Autowired
    private InterventoRepository interventoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private VeicoloRepository veicoloRepository;

    @Autowired
    private TipologiaInterventoRepository tipologiaInterventoRepository;

    @Autowired 
    private ClienteRepository clienteRepository;

    @Autowired
    private DestinazioneRepository destinazioneRepository;

    @Autowired 
    private RelazioneUtentiInterventiRepository relazioneUtentiInterventiRepository;

    @Autowired
    private MyWebSocketHandler webSocketHandler;
    
    @Transactional
    @Scheduled(cron = "0 0 5 * * *") 
    public void creaInterventoCheckSivis() {
        
        if (LocalDate.now().getDayOfWeek().getValue() == 7) {
            return; 
        }
        
        Utente utenteApertura = utenteRepository.findById(18)
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID 18 non trovato"));
        Utente utente = utenteRepository.findById(5)
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID 5 non trovato"));
        Veicolo veicolo = veicoloRepository.findById(13)
                .orElseThrow(() -> new IllegalArgumentException("Veicolo con ID 13 non trovato"));
        TipologiaIntervento tipologia = tipologiaInterventoRepository.findById(1)
                .orElseThrow(() -> new IllegalArgumentException("Tipologia con ID 1 non trovata"));
        Cliente cliente = clienteRepository.findById(966)
                .orElseThrow(() -> new IllegalArgumentException("Cliente con ID 966 non trovato"));
        Destinazione destinazione = destinazioneRepository.findById(974)
                .orElseThrow(() -> new IllegalArgumentException("Destinazione con ID 974 non trovata"));

        Intervento intervento = Intervento.builder()
                .attivo(true)
                .visualizzato(false)
                .priorita(Priorita.URGENTE)
                .titolo("VERIFICHE GIORNALIERE SERVER + MAIL + BACKUP")
                .data_apertura_intervento(new java.util.Date())
                .data(new java.util.Date())
                .descrizione("VERIFICHE GIORNALIERE SERVER + MAIL + BACKUP")
                .annullato(false)
                .accettato_da_tecnico(false)
                .assegnato(true)
                .conclusione_parziale(false)
                .saldato(false)
                .utente_apertura(utenteApertura)
                .utente(utente)
                .veicolo(veicolo)
                .tipologia(tipologia)
                .cliente(cliente)
                .destinazione(destinazione)
                .build();

        Intervento nuovoIntervento = interventoRepository.save(intervento);

        Utente utenteRelazione = utenteRepository.findById(9)
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID 9 non trovato"));

        RelazioneUtentiInterventi relazione = new RelazioneUtentiInterventi();
        relazione.setIntervento(nuovoIntervento);
        relazione.setUtente(utenteRelazione);
        relazione.setVisualizzato(false);

        // Salva la relazione nel database
        relazioneUtentiInterventiRepository.save(relazione);
    }

    @Override
    public Intervento createIntervento(Intervento intervento) {
    // Salva l'intervento nel database
    Intervento nuovoIntervento = interventoRepository.save(intervento);
    // Converti l'intervento in JSON usando Jackson
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        String messaggio = objectMapper.writeValueAsString(nuovoIntervento);
        webSocketHandler.broadcast(messaggio);
    } catch (Exception e) {
        System.out.println("Errore nella serializzazione JSON: " + e.getMessage());
    }

    return nuovoIntervento;
}

    // @Override
    // public Intervento getInterventoById(int interventoId) {
    //     System.out.println("Richiesta di recuperare l'intervento con ID: " + interventoId);
    //     Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
    //     if (optionalIntervento.isPresent()) {
    //         return optionalIntervento.get();
    //     } else {
    //         throw new NoSuchElementException("Intervento non trovato con ID: " + interventoId);
    //     }
    // }

    @Override
    public List<Intervento> getAllInterventiOrderdByDesc(){
        List<Intervento> optionalInterventi = interventoRepository.findAllByAttivoTrueOrderByIdDesc();
        return optionalInterventi;
    }

    @Override 
    public List<Intervento> getInterventiOrderedByGruppo(){
        List<Intervento> optionalInterventi = interventoRepository.findAllOrderByGruppoOrderById();
        return optionalInterventi;
    }

    @Override
    public Intervento getInterventoById(int interventoId) {
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
        return optionalIntervento.get();
    }

    @Override
    public List<Intervento> getAllInterventi(){
        return interventoRepository.findAll();
    }

    @Override
    public List<Intervento> getAllInterventiWithMerceNonConclusiByUtente(Utente utente){
        return interventoRepository.findByMerceNotNullAndUtenteAndConclusoFalseAndAttivoTrue(utente);
    }

    @Override
    public List<Intervento> getAllInterventiWithMerce(){
        return interventoRepository.findDistinctByMerceIsNotNullAndAttivoTrue();
    }

    @Override
    public List<Optional<Intervento>> getInterventoByCliente(Cliente cliente){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByClienteAndAttivoTrue(cliente);
        return optionalIntervento;
    }

    @Override
    public List<Intervento> getInterventiByMerce(MerceInRiparazione merce){
        List<Intervento> optionalIntervento = interventoRepository.findByMerceAndAttivoTrue(merce);
        return optionalIntervento;
    }

    @Override 
    public List<Optional<Intervento>> getInterventoByUtente(Utente utente){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByUtenteAndAttivoTrue(utente);
        return optionalIntervento;
    }

    @Override
    public List<Optional<Intervento>> getInterventoByTipologia(TipologiaIntervento tipologiaIntervento){
        List<Optional<Intervento>> optionalIntervento = interventoRepository.findByTipologiaAndAttivoTrue(tipologiaIntervento);
        return optionalIntervento;
    }

    @Override
    public List<Optional<Intervento>> getInterventiByGruppo(GruppoInterventi gruppo){
        List<Optional<Intervento>> optionalInterventi = interventoRepository.findByGruppoAndAttivoTrue(gruppo);
        return optionalInterventi;
    }

    @Override
    public Intervento updateIntervento(Intervento intervento){
        return interventoRepository.save(intervento);
    }

    @Override 
    public void deleteIntervento(int interventoId){
        interventoRepository.deleteById(interventoId);
    }

}