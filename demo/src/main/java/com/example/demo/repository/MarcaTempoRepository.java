package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.MarcaTempo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;

@Transactional
@Repository
public interface MarcaTempoRepository extends JpaRepository<MarcaTempo, Integer>{

    Optional<MarcaTempo> findByName(String name);

    List<MarcaTempo> findAll();

    Optional<MarcaTempo> findByDataAndUtente(Date data, Utente utente);

    List<MarcaTempo> findByViaggioOrderByData(Viaggio viaggio);

    List<MarcaTempo> findByViaggioOrderByUtenteAsc(Viaggio viaggio);

    List<Optional<MarcaTempo>> findByViaggioAndDataBetweenOrderByUtenteAscDataAsc(Viaggio viaggio, Date datetoday, Date datetomorrow);

    List<Optional<MarcaTempo>> findByViaggioAndUtenteAndDataBetween(Viaggio viaggio, Utente utente, Date datetoday, Date datetomorrow);

    List<MarcaTempo> findAllByOrderByUtenteAscDataAsc();

}