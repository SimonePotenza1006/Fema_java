package com.example.demo.service;

import com.example.demo.util.ImageUtil;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.Veicolo;
import com.example.demo.repository.ImmagineRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.MerceInRiparazioneRepository;
import com.example.demo.repository.SopralluogoRepository;
import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.repository.VeicoloRepository;

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

    @Autowired
    private SopralluogoRepository sopralluogoRepository;

    @Autowired
    private VeicoloRepository veicoloRepository;

    @Autowired
    private MerceInRiparazioneRepository merceRepository;

    @Autowired
    private SpesaVeicoloRepository spesaRepository; 

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
        System.out.println(interventoId);
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .intervento(optionalIntervento.get())
                .build());
            
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    public String uploadImageSopralluogo(MultipartFile file, int sopralluogoId) throws IOException {
        Optional<Sopralluogo> optionalSopralluogo = sopralluogoRepository.findById(sopralluogoId);
        System.out.println(sopralluogoId);
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .sopralluogo(optionalSopralluogo.get())
                .build());
            
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    public String uploadImageSpesa(MultipartFile file, int spesaId) throws IOException{
        Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(spesaId);
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .spesaVeicolo(optionalSpesa.get())
                .build());

        return "Image uploaded successfully:" + file.getOriginalFilename();        
    }

    public String uploadImageSpesaveicolo(MultipartFile file, int veicoloId) throws IOException {
        Optional<Veicolo> optionalVeicolo = veicoloRepository.findById(veicoloId);
        System.out.println(veicoloId);
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .veicolo(optionalVeicolo.get())
                .build());
            
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }

    public String uploadImageMerce(MultipartFile file, int merceId) throws IOException {
        Optional<MerceInRiparazione> optionalMerce = merceRepository.findById(merceId);
        if (file == null || file.isEmpty()) {
            return "Errore: nessun file ricevuto.";
        }
    
        immagineRepository.save(Immagine.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .merceInRiparazione(optionalMerce.get())
                .build());
            
        return "Immagine caricata con successo: " + file.getOriginalFilename();
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
        List<Immagine> dbImage = immagineRepository.findByIntervento(optionalIntervento.get());
        return ImageUtil.decompressImage(dbImage.get(interventoId).getImageData());
    }

    @Transactional
    public List<Immagine> getImagesByMerce(int merceId){
        Optional<MerceInRiparazione> optionalMerce = merceRepository.findById(merceId);
        if(optionalMerce.isPresent()){
            return immagineRepository.findByMerceInRiparazione(optionalMerce.get());
        } else {

        }
        return null;
    }

    @Transactional
    public List<Immagine> getImagesBySopralluogo(int sopralluogoId){
        Optional<Sopralluogo> optionalSopralluogo = sopralluogoRepository.findById(sopralluogoId);
        if(optionalSopralluogo.isPresent()) {
            return immagineRepository.findBySopralluogo(optionalSopralluogo.get());
        } else {

        }
        return null;
    }

    @Transactional
    public List<Immagine> getImagesByIntervento(int interventoId) { 
        Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId); 
        if (optionalIntervento.isPresent()) { 
            return immagineRepository.findByIntervento(optionalIntervento.get()); 
        } else {

     }
        return null; 
    }

    // @Transactional
    // public byte[] getImageBySopralluogo(int sopralluogoId){
    //     Optional<Sopralluogo> optionalSopralluogo = sopralluogoRepository.findById(sopralluogoId);
    //     List<Optional<Immagine>> dbImage = immagineRepository.findBySopralluogo(optionalSopralluogo.get());
    //     return ImageUtil.decompressImage(dbImage.get().getImageData());
    // }

    @Transactional
    public byte[] getImageBySpesa(int idSpesa){
        Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(idSpesa);
        Optional<Immagine> dbImage = immagineRepository.findBySpesaVeicolo(optionalSpesa.get());
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
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
