package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.ImmagineAzienda;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.repository.ImmagineAziendaRepository;
import com.example.demo.util.ImageUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImmagineAziendaService {
    
    @Autowired 
    private ImmagineAziendaRepository immagineRepository;

    @Autowired
    private AziendaRepository aziendaRepository;

    private final RestTemplate restTemplate;

    public ImmagineAziendaService() {
        this.restTemplate = new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        int timeout = 10000; // Timeout in milliseconds (5 seconds)
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        return factory;
    }

    public String uploadImageAzienda(MultipartFile file, int aziendaId) throws IOException{
        Optional<Azienda> optionalAzienda = aziendaRepository.findById(aziendaId);
        immagineRepository.save(ImmagineAzienda.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .azienda(optionalAzienda.get())
                .build()
        );
        return "Image uploaded succesfully:" + file.getOriginalFilename(); 
    }

    @Transactional
    public List<ImmagineAzienda> getImageByAzienda(int aziendaId){
        Optional<Azienda> optionalAzienda = aziendaRepository.findById(aziendaId);
        if(optionalAzienda.isPresent()){
            return immagineRepository.findByAzienda(optionalAzienda.get());
        } else {

        }
        return null;
    }

}
