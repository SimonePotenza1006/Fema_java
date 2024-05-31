package com.example.demo.service.impl;
import com.example.demo.service.VeicoloSivisService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.demo.entity.Veicolo;
import com.example.demo.entity.VeicoloSivis;
import com.example.demo.repository.VeicoloRepository;
import com.example.demo.repository.VeicoloSivisRepository;


@Service
@AllArgsConstructor
public class VeicoloSivisServiceImpl implements VeicoloSivisService{
    
    private VeicoloSivisRepository veicoloRepository;

    @Override
    public VeicoloSivis createVeicolo(VeicoloSivis veicolo) {
        return veicoloRepository.save(veicolo);
    }

    @Override
    public VeicoloSivis getVeicoloById(int veicoloId) {
        Optional<VeicoloSivis> optionalVeicolo = veicoloRepository.findById(veicoloId);
        return optionalVeicolo.get();
    }

    @Override
    public List<VeicoloSivis> getAllVeicoli() {
        return veicoloRepository.findAll();
    }

    //senza id?
    @Override
    public VeicoloSivis updateVeicolo(VeicoloSivis veicolo) {
        return veicoloRepository.save(veicolo);
    }

    @Override
    public void deleteVeicolo(int veicoloId) {
    	veicoloRepository.deleteById(veicoloId);
    }
}
