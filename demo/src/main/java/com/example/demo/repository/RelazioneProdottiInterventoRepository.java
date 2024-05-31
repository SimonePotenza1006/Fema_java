package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Ddt;
import com.example.demo.entity.Prodotto;
import com.example.demo.entity.RelazioneProdottiIntervento;
import com.example.demo.entity.Intervento;


@Repository
public interface RelazioneProdottiInterventoRepository extends JpaRepository<RelazioneProdottiIntervento, Integer>{
    Optional<RelazioneProdottiIntervento> findById(int id);
    List<Optional<RelazioneProdottiIntervento>> findByDdt (Ddt ddt);
    List<Optional<RelazioneProdottiIntervento>> findByProdotto(Prodotto prodotto);
    List<Optional<RelazioneProdottiIntervento>> findByIntervento(Intervento intervento);
}
