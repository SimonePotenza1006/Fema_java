package com.example.demo.service;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Device;
import com.example.demo.entity.Licenza;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;

import java.util.List;
import java.util.Set;

public interface DeviceService {
	
	Device createRuolo(Device ruolo);

	Device getRuoloById(Long ruoloId);

    List<Device> getAllRuoli();

    Device updateRuolo(Device ruolo);

    void deleteRuolo(Long ruoloId);
}
