package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.ImmagineAzienda;

@Transactional
@Repository
public interface ImmagineAziendaRepository extends JpaRepository<ImmagineAzienda, Integer>{
    
    List<ImmagineAzienda> findByAzienda(Azienda azienda);
      
}
