package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Device;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{
	Optional<Device> findById(Long id);
}
