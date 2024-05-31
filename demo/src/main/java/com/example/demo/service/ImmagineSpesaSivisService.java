package com.example.demo.service;
import java.io.File;
import java.io.IOException;
import com.example.demo.util.ImageUtil;
import com.example.demo.entity.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.ImmagineSpesaSivisRepository;
import com.example.demo.repository.SpesaVeicoloSivisRepository;

@Service
public class ImmagineSpesaSivisService {
    
    @Autowired
    private ImmagineSpesaSivisRepository immagineRepository;

    @Autowired
    private SpesaVeicoloSivisRepository spesaRepository;

    private final RestTemplate restTemplate;

    public ImmagineSpesaSivisService() {
        this.restTemplate = new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        int timeout = 10000; // Timeout in milliseconds (5 seconds)
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        return factory;
    }

    public String uploadImage(MultipartFile file, int spesaId) throws IOException {
        Optional<SpesaVeicoloSivis> optionalSpesa = spesaRepository.findById(spesaId);
        System.out.println(spesaId);
        immagineRepository.save(ImmagineSpesaSivis.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .spesa(optionalSpesa.get())
                .build());
        
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    @Transactional
	public byte[] getImageBySpesa(int idspesa) {
		Optional<SpesaVeicoloSivis> optionalSpesa = spesaRepository.findById(idspesa);
	        Optional<ImmagineSpesaSivis> dbImage = immagineRepository.findBySpesa(optionalSpesa.get());
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}

}
