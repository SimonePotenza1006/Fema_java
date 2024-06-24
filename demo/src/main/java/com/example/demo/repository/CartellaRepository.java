package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Cartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartellaRepository extends JpaRepository<Cartella, Integer>{
    List<Cartella> findByParentFolder(Cartella parentFolder);
}
