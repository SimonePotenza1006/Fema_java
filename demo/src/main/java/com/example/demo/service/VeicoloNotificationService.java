package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Veicolo;
import com.example.demo.entity.VeicoloSivis;
import com.example.demo.repository.VeicoloRepository;

@Service
public class VeicoloNotificationService {
    
    @Autowired
    private VeicoloRepository veicoloRepository; // Interfaccia per accedere ai veicoli dal DB

    @Autowired
    private EmailService emailService; // Servizio per inviare le email

    @Scheduled(cron = "0 17 13 * * ?")
    public void verificaScadenzeVeicoli() {
        List<Veicolo> veicoli = veicoloRepository.findAll();  // Recupera tutti i veicoli

        // Ottieni la data odierna
        LocalDate today = LocalDate.now();

        // Cicla su ogni veicolo per controllare le scadenze
        for (Veicolo veicolo : veicoli) {
            verificaScadenzeTemporali(veicolo, today);
            verificaScadenzeChilometri(veicolo);
        }
    }

    private void verificaScadenzeTemporali(Veicolo veicolo, LocalDate today) {
        // Controlla il bollo, polizza, revisione, ecc.
        verificaScadenza(veicolo.getData_scadenza_bollo(), "Bollo", veicolo, today);
        verificaScadenza(veicolo.getData_scadenza_polizza(), "Polizza RCA", veicolo, today);
        verificaScadenza(veicolo.getData_revisione(), "Revisione", veicolo, today);
        // Altri controlli...
    }

    private void verificaScadenzeChilometri(Veicolo veicolo) {
        // Verifica inversione gomme
        int kmInversione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_inversione();
        if (veicolo.getSoglia_inversione() - kmInversione <= 120) {
            emailService.sendEmail(veicolo, "Inversione gomme", kmInversione);
        }

        // Verifica sostituzione gomme
        int kmSostituzione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_sostituzione();
        if (veicolo.getSoglia_sostituzione() - kmSostituzione <= 120) {
            emailService.sendEmail(veicolo, "Sostituzione gomme", kmSostituzione);
        }

        // Verifica tagliando
        int kmTagliando = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultimo_tagliando();
        if (veicolo.getSoglia_tagliando() - kmTagliando <= 120) {
            emailService.sendEmail(veicolo, "Tagliando", kmTagliando);
        }
    }

    private void verificaScadenza(Date dataScadenza, String tipoScadenza, Veicolo veicolo, LocalDate today) {
        if (dataScadenza == null) return;

        LocalDate scadenza = dataScadenza.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long giorniAllaScadenza = ChronoUnit.DAYS.between(today, scadenza);

        // Controllo delle scadenze: 30 giorni, 20 giorni, 15 giorni, 7 giorni e ogni giorno
        if (giorniAllaScadenza == 30 || giorniAllaScadenza == 29 || giorniAllaScadenza == 31 || giorniAllaScadenza == 20 || giorniAllaScadenza == 15 || giorniAllaScadenza == 7 || giorniAllaScadenza <= 0) {
            
            emailService.sendEmail(veicolo, tipoScadenza, giorniAllaScadenza);
        }
    }
}
