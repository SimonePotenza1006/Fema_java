package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//import com.fema.cantieri.entity.Veicolo;
import com.example.demo.entity.Veicolo;
//import com.fema.cantieri.repository.VeicoloRepository;
import com.example.demo.repository.VeicoloRepository;

@Service
public class VeicoloNotificationService {

    @Autowired
    private VeicoloRepository veicoloRepository; // Interfaccia per accedere ai veicoli dal DB


    @Autowired
    private EmailService emailService; // Servizio per inviare le email

    @Scheduled(cron = "0 30 8 * * ?")
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
        System.out.println("Verifica inversione gomme:");
        System.out.println("Soglia inversione: " + veicolo.getSoglia_inversione());
        System.out.println("Chilometraggio ultima inversione: " + veicolo.getChilometraggio_ultima_inversione());

        if (veicolo.getSoglia_inversione() > 0 && veicolo.getChilometraggio_ultima_inversione() > 0) {
            int kmInversione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_inversione();
            System.out.println("Chilometraggio attuale: " + veicolo.getChilometraggio_attuale());
            System.out.println("Km inversione: " + kmInversione);

            if (kmInversione >= veicolo.getSoglia_inversione() - 120) {
                System.out.println("Invio email per inversione gomme.");
                emailService.sendEmail(veicolo, "Inversione gomme", kmInversione);
            } else {
                System.out.println("Email non inviata per inversione gomme: condizione non soddisfatta.");
            }
        } else {
            System.out.println("Email non inviata per inversione gomme: soglia o chilometraggio pari a 0.");
        }

        // Verifica sostituzione gomme
        System.out.println("Verifica sostituzione gomme:");
        System.out.println("Soglia sostituzione: " + veicolo.getSoglia_sostituzione());
        System.out.println("Chilometraggio ultima sostituzione: " + veicolo.getChilometraggio_ultima_sostituzione());

        if (veicolo.getSoglia_sostituzione() > 0 && veicolo.getChilometraggio_ultima_sostituzione() > 0) {
            int kmSostituzione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_sostituzione();
            System.out.println("Km sostituzione: " + kmSostituzione);

            if (kmSostituzione >= veicolo.getSoglia_sostituzione() - 120) {
                System.out.println("Invio email per sostituzione gomme.");
                emailService.sendEmail(veicolo, "Sostituzione gomme", kmSostituzione);
            } else {
                System.out.println("Email non inviata per sostituzione gomme: condizione non soddisfatta.");
            }
        } else {
            System.out.println("Email non inviata per sostituzione gomme: soglia o chilometraggio pari a 0.");
        }

        // Verifica tagliando
        System.out.println("Verifica tagliando:");
        System.out.println("Soglia tagliando: " + veicolo.getSoglia_tagliando());
        System.out.println("Chilometraggio ultimo tagliando: " + veicolo.getChilometraggio_ultimo_tagliando());

        if (veicolo.getSoglia_tagliando() > 0 && veicolo.getChilometraggio_ultimo_tagliando() > 0) {
            int kmTagliando = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultimo_tagliando();
            System.out.println("Km tagliando: " + kmTagliando);

            if (kmTagliando >= veicolo.getSoglia_tagliando() - 120) {
                System.out.println("Invio email per tagliando.");
                emailService.sendEmail(veicolo, "Tagliando", kmTagliando);
            } else {
                System.out.println("Email non inviata per tagliando: condizione non soddisfatta.");
            }
        } else {
            System.out.println("Email non inviata per tagliando: soglia o chilometraggio pari a 0.");
        }
    }




    private void verificaScadenza(Date dataScadenza, String tipoScadenza, Veicolo veicolo, LocalDate today) {
        if (dataScadenza == null) return;

        LocalDate scadenza = dataScadenza.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long giorniAllaScadenza = ChronoUnit.DAYS.between(today, scadenza);

        // Controllo delle scadenze: 30 giorni, 20 giorni, 15 giorni, 7 giorni e ogni giorno
        if (giorniAllaScadenza == 30 || giorniAllaScadenza == 21 || giorniAllaScadenza == 14 || giorniAllaScadenza == 7 || giorniAllaScadenza == 5 || giorniAllaScadenza == 3 || giorniAllaScadenza == 2 || giorniAllaScadenza == 1) {
            System.out.println("gg: -"+giorniAllaScadenza);
            emailService.sendEmail(veicolo, tipoScadenza, giorniAllaScadenza);
        }
    }
}