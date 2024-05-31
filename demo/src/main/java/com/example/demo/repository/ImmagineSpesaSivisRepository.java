package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.ImmagineSpesaSivis;
import com.example.demo.entity.SpesaVeicoloSivis;
import java.util.List;
import java.util.Optional;


@Transactional
@Repository
public interface ImmagineSpesaSivisRepository extends JpaRepository<ImmagineSpesaSivis, Integer>{
    Optional<ImmagineSpesaSivis> findBySpesa(SpesaVeicoloSivis spesa);
}
