package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class WebSocketService {

    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    // Aggiungi una sessione
    public void addSession(WebSocketSession session) {
        sessions.add(session);
    }

    // Rimuovi una sessione
    public void removeSession(WebSocketSession session) {
        sessions.remove(session);
    }

    // Invia un messaggio a tutte le sessioni
    public void sendMessageToAll(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                System.out.println("Errore durante l'invio del messaggio WebSocket: " + e.getMessage());
            }
        }
    }

    // Invia una notifica per un nuovo intervento
    public void sendNewInterventoNotification(Object intervento) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(intervento);
            sendMessageToAll(jsonMessage);
        } catch (Exception e) {
            System.out.println("Errore durante la serializzazione dell'intervento: " + e.getMessage());
        }
    }
}
