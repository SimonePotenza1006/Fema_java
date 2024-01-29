package com.example.demo.service;

import com.example.demo.util.ImageUtil;
import com.example.demo.entity.Utente;
import com.example.demo.repository.ImageDataRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.entity.ImageData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageDataService {
    
    @Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	public ImageDataRepository imageDataRepository;

    public String uploadImage(MultipartFile file, String tipofoto, int utenteId) throws IOException {
		Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
        imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .utente(optionalUtente.get())
                .tipofoto(tipofoto)
                .build());
        System.out.print(imageDataRepository);
        return "Image uploaded successfully: " +file.getOriginalFilename();
    }

    @Transactional
	public ImageData getInfoByImageByName(String name) {
	        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

	        return ImageData.builder()
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

	}

    @Transactional
	public byte[] getImage(String name) {
	        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}

    @Transactional
	public byte[] getProfilo(String tipofoto, int utenteId) {
			Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
	        Optional<ImageData> dbImage = imageDataRepository.findByTipofotoAndUtente(tipofoto, optionalUtente.get());
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}

    @Transactional
	public List<ImageData> getAll(){
	        List<ImageData> dbImages = imageDataRepository.findByTipofoto("spese");
	        return dbImages;
	}
}
