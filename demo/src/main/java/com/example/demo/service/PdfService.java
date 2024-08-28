package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import com.example.demo.entity.Pdf;
import com.example.demo.entity.Utente;
import com.example.demo.entity.ImageData;
import com.example.demo.repository.ImageDataRepository;
import com.example.demo.repository.PdfRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.util.ImageUtil;

@Service
public class PdfService {
    
    @Autowired
    private PdfRepository pdfRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public String uploadPdf(Optional<MultipartFile> file, int utenteId) //throws Exception 
	{
		try {
			if(file.isPresent()) {
		Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
        pdfRepository.save(Pdf.builder()
                .name(file.get().getOriginalFilename())
                .type(file.get().getContentType())
                .imageData(ImageUtil.compressImage(file.get().getBytes()))
                .utente(optionalUtente.get())
                .build());
        //System.out.print(imageDataRepository);
        return "Image uploaded successfully: " +file.get().getOriginalFilename();
			} else {return null;}
		} catch (Exception e) {
			  throw new RuntimeException("dsvdvf: " + e.getMessage());
		    //System.err.println("Failed to create directory!" + e.getMessage());

		  } 
        

    }
	 
	@Transactional
	public Pdf getInfoByImageByName(String name) {
	        Optional<Pdf> dbImage = pdfRepository.findByName(name);

	        return Pdf.builder()
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

	}

	@Transactional
	public byte[] getImage(String name) {
	        Optional<Pdf> dbImage = pdfRepository.findByName(name);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}
	
	@Transactional
	public byte[] getProfilo(String tipofoto, int utenteId) {
			Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
	        Optional<Pdf> dbImage = Optional.ofNullable(pdfRepository.findByUtente(optionalUtente.get()).get(0));
	        /*List<byte[]> images = new ArrayList<>();
	        for (Optional<ImageData> def : dbImage){
                images.add(def.get().getImageData());

            }*/
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}
	
	@Transactional
	public List<Pdf> getAllByUtente(int utenteId){//String tipofoto, Long utenteId) {
			Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
	        List<Pdf> dbImages = pdfRepository.findByUtente(optionalUtente.get());
	        /*List<byte[]> images = new ArrayList<>();
	        for (Optional<ImageData> def : dbImage){
                images.add(def.get().getImageData());

            }*/
	        //byte[] images = ImageUtil.decompressImage(dbImage.get().getImageData());
	return dbImages;
	}

	
	@Transactional
	public List<Pdf> getAll(){//String tipofoto, Long utenteId) {
			//Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
	        List<Pdf> dbImages = pdfRepository.findAll();
	        /*List<byte[]> images = new ArrayList<>();
	        for (Optional<ImageData> def : dbImage){
                images.add(def.get().getImageData());

            }*/
	        //byte[] images = ImageUtil.decompressImage(dbImage.get().getImageData());
	return dbImages;
	}

}
