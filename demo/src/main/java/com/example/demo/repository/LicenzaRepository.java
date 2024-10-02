package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.ImageData;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;

@Repository
public interface LicenzaRepository extends JpaRepository<Licenza, Long>{
	Optional<Licenza> findById(Long id);
	Optional<Licenza> findByDescrizione(String iiid);
	List<Licenza> findByUtilizzato(Boolean utilizzato);
	
}
