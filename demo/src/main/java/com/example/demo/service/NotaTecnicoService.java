package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.NotaTecnico;


public interface NotaTecnicoService {
    
    NotaTecnico createNota(NotaTecnico nota);

    NotaTecnico getNotaById(int notaId);

    List<NotaTecnico> getAllNoteOrderByDesc();

    List<Optional<NotaTecnico>> getNotaByIntervento(Intervento intervento);

    List<Optional<NotaTecnico>> getNotaByCliente(Cliente cliente);

    List<Optional<NotaTecnico>> getNotaByDestinazione(Destinazione destinazione);

    List<Optional<NotaTecnico>> getNotaBySopralluogo(Sopralluogo sopralluogo);

    List<Optional<NotaTecnico>> getNotaByMerce(MerceInRiparazione merce);

    List<Optional<NotaTecnico>> getNotaByUtente(Utente utente);

    NotaTecnico updateNota(NotaTecnico nota);

    void deleteNota(int notaId);
}
