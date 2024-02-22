package com.example.demo.service;

import com.example.demo.util.ImageUtil;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.repository.ImmagineRepository;
import com.example.demo.repository.InterventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImmagineService {

    @Autowired
    private ImmagineRepository immagineRepository;

    @Autowired
    private InterventoRepository interventoRepository;

    private final RestTemplate restTemplate;

    public ImmagineService() {
        this.restTemplate = new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        int timeout = 10000; // Timeout in milliseconds (5 seconds)
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        return factory;
    }

    public String uploadImage(MultipartFile file, int interventoId) throws IOException {
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .intervento(optionalIntervento.get())
                .build());
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    @Transactional
    public Immagine getInfoByImageByName(String name) {
        Optional<Immagine> dbImage = immagineRepository.findByName(name);
        return Immagine.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();
    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Immagine> dbImage = immagineRepository.findByName(name);
        return ImageUtil.decompressImage(dbImage.get().getImageData());
    }

    @Transactional
    public byte[] getImageByIntervento(int interventoId) {
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
        Optional<Immagine> dbImage = immagineRepository.findByIntervento(optionalIntervento.get());
        return ImageUtil.decompressImage(dbImage.get().getImageData());
    }

    @Transactional
    public List<Immagine> getAllImmagini() {
        List<Immagine> dbImages = immagineRepository.findAll();
        return dbImages;
    }

    // Metodo per eseguire la richiesta HTTP con timeout
    public void saveImageIntervento(File imageFile, String interventoId) {
        String url = "http://192.168.1.52:8080/api/immagine";

        try {
            restTemplate.postForObject(url, imageFile, String.class);
            System.out.println("Immagine salvata con successo");
            // Aggiorna lo stato dell'applicazione o esegui altre azioni necessarie
        } catch (Exception e) {
            // Gestione degli errori durante la chiamata HTTP
            System.out.println("Errore durante la chiamata HTTP: " + e.getMessage());
            // Gestisci l'errore in base alle tue esigenze
        }
    }
}
