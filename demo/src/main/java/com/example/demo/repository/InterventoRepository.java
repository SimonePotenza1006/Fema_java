package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;

@Repository
public interface InterventoRepository extends JpaRepository<Intervento, Integer>, JpaSpecificationExecutor<Intervento>{
    
    // Find all ordered by id in descending order where attivo = true
    List<Intervento> findAllByAttivoTrueOrderByIdDesc();
    
    // Custom query to find all ordered by gruppo and then by id where attivo = true
    @Query("SELECT i FROM Intervento i WHERE i.attivo = true ORDER BY i.gruppo DESC, i.id DESC")
    List<Intervento> findAllOrderByGruppoOrderById();

    // Find all by utente where attivo = true
    List<Optional<Intervento>> findByUtenteAndAttivoTrue(Utente utente);

    // Find all by cliente where attivo = true
    List<Optional<Intervento>> findByClienteAndAttivoTrue(Cliente cliente);

    // Find all by tipologia where attivo = true
    List<Optional<Intervento>> findByTipologiaAndAttivoTrue(TipologiaIntervento tipologiaIntervento);

    // Find all by gruppo where attivo = true
    List<Optional<Intervento>> findByGruppoAndAttivoTrue(GruppoInterventi gruppoInterventi);

    // Find all by merce where attivo = true
    List<Intervento> findByMerceAndAttivoTrue(MerceInRiparazione merce);

    // Find distinct records where merce is not null and attivo = true
    List<Intervento> findDistinctByMerceIsNotNullAndAttivoTrueOrderByIdDesc();

    // Find records where merce is not null, utente matches, concluso is false, and attivo = true
    List<Intervento> findByMerceNotNullAndUtenteAndConclusoFalseAndAttivoTrue(Utente utente);

    // Custom query to find records where merce is not null, data_consegna is null, utente matches, and attivo = true
    @Query("SELECT i FROM Intervento i WHERE i.merce IS NOT NULL AND i.merce.data_consegna IS NULL AND i.utente = :utente AND i.attivo = true")
    List<Intervento> findByMerceNotNullAndDataConsegnaIsNullAndUtenteAndAttivoTrue(@Param("utente") Utente utente);
}
