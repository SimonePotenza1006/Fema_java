package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface InterventoRepository extends JpaRepository<Intervento, Integer>{
    List<Intervento> findAllByOrderByIdDesc();
    
    @Query("SELECT i FROM Intervento i ORDER BY i.gruppo DESC, i.id DESC")
    List<Intervento> findAllOrderByGruppoOrderById();
    
    List<Optional<Intervento>> findByUtente(Utente utente);
    List<Optional<Intervento>> findByCliente(Cliente cliente);
    List<Optional<Intervento>> findByTipologia(TipologiaIntervento tipologiaIntervento);
    List<Optional<Intervento>> findByGruppo(GruppoInterventi gruppoInterventi);
    List<Intervento> findByMerce(MerceInRiparazione merce);
    List<Intervento> findDistinctByMerceIsNotNull();
    List<Intervento> findByMerceNotNullAndUtenteAndConclusoFalse(Utente utente);

    @Query("SELECT i FROM Intervento i WHERE i.merce IS NOT NULL AND i.merce.data_consegna IS NULL AND i.utente = :utente")
    List<Intervento> findByMerceNotNullAndDataConsegnaIsNullAndUtente(@Param("utente") Utente utente);


}