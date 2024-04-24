package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.ImageSpesaveicolo;
import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.repository.ImageSpesaveicoloRepository;
import com.example.demo.util.ImageUtil;


@Service
public class ImageSpesaveicoloService {
	
	@Autowired
	private SpesaVeicoloRepository spesaRepository;
	
	@Autowired
	public ImageSpesaveicoloRepository imageDataRepository;
	
    public String uploadImage(MultipartFile file, int spesaId) throws IOException {
		Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(spesaId);
        imageDataRepository.save(ImageSpesaveicolo.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .spesaVeicolo(optionalSpesa.get())
                .build());
        System.out.print(imageDataRepository);
        return "Image uploaded successfully: " +file.getOriginalFilename();

    }

	@Transactional
	public byte[] getImage(String name) {
	        Optional<ImageSpesaveicolo> dbImage = imageDataRepository.findByName(name);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}
	
	@Transactional
	public byte[] getImageBySpesa(int idspesa) {
		Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(idspesa);
	        Optional<ImageSpesaveicolo> dbImage = imageDataRepository.findBySpesaVeicolo(optionalSpesa.get());
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}

	
	@Transactional
	public List<ImageSpesaveicolo> getAll(){//String tipofoto, Long utenteId) {
	        List<ImageSpesaveicolo> dbImages = imageDataRepository.findAll();
	return dbImages;
	}
	
}
