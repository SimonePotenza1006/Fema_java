package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RelazioneViaggioUtente;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;
import java.util.List;
import java.util.Optional;

@Repository
public interface RelazioneViaggioUtenteRepository extends JpaRepository<RelazioneViaggioUtente, Integer>{
    Optional<RelazioneViaggioUtente> findById(int id);
    List<Optional<RelazioneViaggioUtente>> findByUtente(Utente utente);
    List<Optional<RelazioneViaggioUtente>> findByViaggio(Viaggio viaggio);
}
