package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Destinazione;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.NotaTecnico;

@Repository
public interface NotaTecnicoRepository extends JpaRepository<NotaTecnico, Integer>{
    List<NotaTecnico> findAllByOrderByIdDesc();
    List<Optional<NotaTecnico>> findByIntervento(Intervento intervento);
    List<Optional<NotaTecnico>> findByCliente(Cliente cliente);
    List<Optional<NotaTecnico>> findByDestinazione(Destinazione destinazione);
    List<Optional<NotaTecnico>> findBySopralluogo(Sopralluogo sopralluogo);
    List<Optional<NotaTecnico>> findByMerce(MerceInRiparazione merce);
    List<Optional<NotaTecnico>> findByUtente(Utente utente);
}
