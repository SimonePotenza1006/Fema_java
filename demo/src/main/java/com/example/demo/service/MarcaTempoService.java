package com.example.demo.service;

import com.example.demo.entity.MarcaTempo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;
import com.example.demo.repository.ImageDataRepository;
import com.example.demo.repository.MarcaTempoRepository;
import com.example.demo.repository.SpesaRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.ViaggioRepository;
import com.example.demo.util.ImageUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class MarcaTempoService {
    @Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private SpesaRepository spesaRepository;
	
	@Autowired
	private ViaggioRepository viaggioRepository;
	
	@Autowired
	public MarcaTempoRepository marcaTempoRepository;
	
	public String uploadPdf(MultipartFile file, int viaggioId, int utenteId, Integer ing, String gps, int idmt) throws IOException, ParseException {
		System.out.print("ghghghh");
		System.out.print(idmt+" "+ing);
		Optional<Viaggio> optionalViaggio = viaggioRepository.findById(viaggioId);
		Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
		
		TimeZone tz = TimeZone.getTimeZone("Europe/Rome");
		TimeZone.setDefault(tz);
		Calendar cal = Calendar.getInstance(tz, Locale.ITALIAN);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ITALIAN);
		Date date = new Date();
		String formattedDate= df.format(date);
		Date dateBeforeDST = df.parse(formattedDate);
		cal.setTime(dateBeforeDST);
		cal.add(Calendar.HOUR, 1);
		System.out.print(date.toString()+dateBeforeDST+cal.getTime());
		//MatcherAssert.assertThat();
		
		
		/*Date date = new Date();
		System.out.print(date);
	    String strDateFormat = "dd/MM/yyyy hh:mm";
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
	    String formattedDate= dateFormat.format(date);
	    System.out.print(formattedDate);
	    LocalDateTime ldt = LocalDateTime.parse(formattedDate);
	    System.out.print(ldt);*/
	    
	    if (ing == 0)
        marcaTempoRepository.save(MarcaTempo.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .viaggio(optionalViaggio.get())
                //.ingresso(ing)
                .gps(gps)
                .data(cal.getTime())//java.sql.Timestamp.valueOf(ldt.plusHours(2)))
                .utente(optionalUtente.get())
                .build());
	    else if (ing == 1) {
	    	MarcaTempo aaa = marcaTempoRepository.findById(idmt).get();
	    	aaa.setGpsu(gps);
	    	aaa.setDatau(cal.getTime());//java.sql.Timestamp.valueOf(ldt.plusHours(2)));
	    	/*if (aaa.getData()!=null && aaa.getDatau()!=null) {
	    		 long difference_In_Time
	                = aaa.getData().getTime() - aaa.getDatau().getTime();
	    		 long difference_In_Minutes
	                = (difference_In_Time
	                   / (1000 * 60))
	                  % 60;
	 
	            long difference_In_Hours
	                = (difference_In_Time
	                   / (1000 * 60 * 60))
	                  % 24;
	            
	    	};*/
	    	marcaTempoRepository.save(aaa);
	    			/*.id(idmt)
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtil.compressImage(file.getBytes()))
	                .viaggio(optionalViaggio.get())
	                //.ingresso(ing)
	                //.setGpsu(gps)
	                .setDatau(date)
	                //.utente(optionalUtente.get())
	                .build()); */
	                }
        System.out.print(marcaTempoRepository);
        return "Image uploaded successfully: " +file.getOriginalFilename();

    }
	 
	@Transactional
	public Boolean getIngByDataByUtente(Date data, Utente utente) {
		Optional<MarcaTempo> marca = marcaTempoRepository.findByDataAndUtente(data, utente);
	    return marca.get().getIngresso();
	}

	@Transactional
	public byte[] getImage(String name) {
	        Optional<MarcaTempo> dbImage = marcaTempoRepository.findByName(name);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}
	
	@Transactional
	public List<Optional<MarcaTempo>> findByViaggioAndUtenteToday(int viaggioId, int utenteId) {
		Optional<Viaggio> optionalViaggio = viaggioRepository.findById(viaggioId);
		Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
		LocalDate today = LocalDate.now();
		LocalDate tomo = LocalDate.now().plusDays(1);
		
		Date datetoday = new Date().from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date datetomo = new Date().from(tomo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println(datetoday+" gg "+datetomo);
		List<Optional<MarcaTempo>> dbmt = marcaTempoRepository.findByViaggioAndUtenteAndDataBetween(optionalViaggio.get(), optionalUtente.get(), datetoday, datetomo);//findByViaggioAndUtente(optionalViaggio.get(), optionalUtente.get());
		List<Optional<MarcaTempo>> dbmtf = new ArrayList<>();
		 Date date = new Date();
		 for (Optional<MarcaTempo> def : dbmt){
			 //if (def.getData().compareTo(optionalViaggio.get().getDatap())>=0) {
				 dbmtf.add(def);
			// }
             //images.add(def.get().getImageData());

         }
	        //Optional<MarcaTempo> marca = imageDataRepository.findByDataAndUtente(data, utente);
	        return dbmtf;
	        /*return MarcaTempo.builder().ingresso(null)
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();*/

	}	
	
	@Transactional
	public List<MarcaTempo> findByViaggioAndUtente(int viaggioId, int utenteId) {
		Optional<Viaggio> optionalViaggio = viaggioRepository.findById(viaggioId);
		Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
		
		 List<MarcaTempo> dbmt = marcaTempoRepository.findByViaggioOrderByUtenteAsc(optionalViaggio.get());//findByViaggioAndUtente(optionalViaggio.get(), optionalUtente.get());
		 List<MarcaTempo> dbmtf = new ArrayList<>();
		 Date date = new Date();
		 for (MarcaTempo def : dbmt){
			 //if (def.getData().compareTo(optionalViaggio.get().getDatap())>=0) {
				 dbmtf.add(def);
			// }
             //images.add(def.get().getImageData());

         }
	        //Optional<MarcaTempo> marca = imageDataRepository.findByDataAndUtente(data, utente);
	        return dbmtf;
	        /*return MarcaTempo.builder().ingresso(null)
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();*/

	}	
	
	/*@Transactional
	public byte[] getProfilo(String tipofoto, Long viaggioId) {
			Optional<Viaggio> optionalUtente = viaggioRepository.findById(viaggioId);
	        Optional<Ddt> dbImage = imageDataRepository.findByViaggio(optionalUtente.get());
	        List<byte[]> images = new ArrayList<>();
	        for (Optional<ImageData> def : dbImage){
                images.add(def.get().getImageData());

            }
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	return image;
	}*/
	
	/*@Transactional
	public List<Ddt> getAll(){//String tipofoto, Long utenteId) {
			//Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
	        List<Ddt> dbImages = imageDataRepository.findAll();
	        List<byte[]> images = new ArrayList<>();
	        for (Optional<ImageData> def : dbImage){
                images.add(def.get().getImageData());

            }
	        //byte[] images = ImageUtil.decompressImage(dbImage.get().getImageData());
	return dbImages;
	}*/

}
