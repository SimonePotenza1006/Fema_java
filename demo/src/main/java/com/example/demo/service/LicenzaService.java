package com.example.demo.service;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;

import java.util.List;
import java.util.Set;

public interface LicenzaService {
	
	Licenza createRuolo(Licenza ruolo);

	Licenza getRuoloById(Long ruoloId);
	
	Licenza getRuoloByDescrizione(String ruoloId);

    List<Licenza> getAllRuoli();

    List<Licenza> getRuoli();

    Licenza updateRuolo(Licenza ruolo);

    void deleteRuolo(Long ruoloId);
}
