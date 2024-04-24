package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.ImageSpesaveicolo;
import com.example.demo.entity.SpesaVeicolo;

@Transactional
@Repository
public interface ImageSpesaveicoloRepository extends JpaRepository<ImageSpesaveicolo, Integer>{
	Optional<ImageSpesaveicolo> findByName(String name);
	List<ImageSpesaveicolo> findAll();
	Optional<ImageSpesaveicolo> findBySpesaVeicolo(SpesaVeicolo spesa);
}
