package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.example.demo.entity.Pdf;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.ImageData;
import com.example.demo.service.AziendaService;
import com.example.demo.service.ImageDataService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.PdfService;
import com.example.demo.service.UtenteService;



@RestController
@RequestMapping("/pdfu")
public class PdfController {

      @Autowired
      private PdfService imageDataService;

      @Autowired
      private UtenteService utenteService2;

      @Autowired
      private AziendaService aziendaService;

      @Autowired
      private InterventoService interventoService;


	  @PostMapping("/certificazioni/aziende")
        public ResponseEntity<?> uploadCerificazioneAzienda(
                @RequestParam("pdf") Optional<MultipartFile> file,
                @RequestParam("azienda") String aziendaNome
        ) throws org.springframework.web.server.ResponseStatusException {
            String response = null;

            try {
                // Verifica che il file non sia vuoto
                if (file.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il file PDF è obbligatorio.");
                }

                // Percorso dinamico in base a nome azienda e targa
                String baseDir = "C:\\APP_FEMA\\Certificazioni\\Azienda";
                Path path = Paths.get(baseDir, aziendaNome);

                // Crea le directory se non esistono
                Files.createDirectories(path);

                // Destinazione del file
                File targetFile = new File(path.toString() + "\\" + file.get().getOriginalFilename());

                // Trasferisci il file
                file.get().transferTo(targetFile);

                // Risposta di conferma
                response = "File caricato con successo in: " + targetFile.getAbsolutePath();
                System.out.println(response);

                // Chiudi lo stream del file
                file.get().getInputStream().close();

                // Risposta con successo
                return ResponseEntity.status(HttpStatus.OK).body(response);

            } catch (Exception e) {
                System.err.println("Errore durante il caricamento del file: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento del file.");
            }
        }

        @PostMapping("intervento")
            public ResponseEntity<?> uploadPdfIntervento(
                @RequestParam("pdf") MultipartFile file,
                @RequestParam("intervento") String interventoId
            ) {
                try {
                    if (file.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il file PDF è obbligatorio.");
                    }
                
                    // Directory base
                    String baseDir = "C:\\APP_FEMA\\Pdf\\Interventi";
                
                    // Crea il percorso della sottodirectory con nome interventoId
                    Path interventionDir = Paths.get(baseDir, interventoId);
                    Files.createDirectories(interventionDir);
                
                    // Percorso completo del file
                    Path targetPath = interventionDir.resolve(file.getOriginalFilename());
                
                    // Salva il file nella directory
                    Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                
                    // Messaggio di successo
                    String response = "File caricato con successo in: " + targetPath.toAbsolutePath();
                    System.out.println(response);
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                } catch (IOException e) {
                    System.err.println("Errore durante il caricamento del file: " + e.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Errore durante il caricamento del file: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Errore generico: " + e.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Errore imprevisto durante il caricamento del file.");
                }
    }
    
    @GetMapping("intervento/{intervento}/{fileName}")
public ResponseEntity<Resource> downloadPdfFile(@PathVariable("intervento") String interventoId,
                                                @PathVariable("fileName") String fileName) {
    // Directory base
    String baseDir = "C:\\APP_FEMA\\Pdf\\Interventi";
    Path filePath = Paths.get(baseDir, interventoId, fileName);

    // Verifica se il file esiste
    if (!Files.exists(filePath)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(null);
    }

    // Restituisce il file come risorsa
    Resource resource = new FileSystemResource(filePath.toFile());
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
        .contentType(MediaType.APPLICATION_PDF)
        .body(resource);
}


        
@GetMapping("intervento/{intervento}")
public ResponseEntity<?> getPdfFilesByIntervento(@PathVariable("intervento") String interventoId) {
    try {
        // Directory base
        String baseDir = "C:\\APP_FEMA\\Pdf\\Interventi";

        // Percorso della sottodirectory per l'intervento
        Path interventionDir = Paths.get(baseDir, interventoId);
        System.out.println("Percorso directory: " + interventionDir.toAbsolutePath());

        // Verifica se la directory esiste
        if (!Files.exists(interventionDir) || !Files.isDirectory(interventionDir)) {
            System.out.println("Directory non trovata o non valida: " + interventionDir.toAbsolutePath());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("La directory per l'intervento con ID " + interventoId + " non esiste.");
        }

        // Trova tutti i file nella directory
        List<String> fileNames = Files.list(interventionDir)
            .filter(Files::isRegularFile) // Solo file regolari
            .peek(path -> System.out.println("File trovato: " + path.getFileName())) // Debug
            .map(path -> path.getFileName().toString()) // Nome del file
            .filter(name -> name.toLowerCase().endsWith(".pdf")) // Solo PDF, case-insensitive
            .peek(name -> System.out.println("File PDF trovato: " + name)) // Debug
            .collect(Collectors.toList());

        // Se non ci sono file PDF
        if (fileNames.isEmpty()) {
            System.out.println("Nessun file PDF trovato nella directory.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Nessun file PDF trovato per l'intervento con ID " + interventoId + ".");
        }

        // Risposta con i nomi dei file
        return ResponseEntity.status(HttpStatus.OK).body(fileNames);
    } catch (IOException e) {
        System.err.println("Errore durante la lettura dei file: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Errore durante la lettura dei file: " + e.getMessage());
    }
}






       @PostMapping("/certificazioni/clienti")
    public ResponseEntity<?> uploadCertificazioneCliente(
            @RequestParam("pdf") MultipartFile file,
            @RequestParam("cliente") String clienteNome
    ) throws org.springframework.web.server.ResponseStatusException {
        String response = null;

    try {
        // Verifica che il file non sia vuoto
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il file PDF è obbligatorio.");
        }

        // Percorso dinamico in base al nome del cliente
        String baseDir = "C:\\APP_FEMA\\Certificazioni\\Clienti";
        Path path = Paths.get(baseDir, clienteNome);

        // Crea le directory se non esistono
        Files.createDirectories(path);

        // Destinazione del file
        Path targetPath = path.resolve(file.getOriginalFilename());

        // Trasferisci il file
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        // Risposta di conferma
        response = "File caricato con successo in: " + targetPath.toAbsolutePath();
        System.out.println(response);

        // Risposta con successo
        return ResponseEntity.status(HttpStatus.OK).body(response);

    } catch (Exception e) {
        System.err.println("Errore durante il caricamento del file: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento del file.");
    }
}

        
        @GetMapping("/certificazioni/{path:.+}/{filename:.+}")
        public ResponseEntity<?> getPdf(@PathVariable("path") String path, @PathVariable("filename") String filename) {
            // Sostituisci '_' con '/' per ricostruire il path corretto
            String decodedPath = path.replace('_', '/');

            // Log per il percorso decodificato
            System.out.println("Decoded Path: " + decodedPath);

            // Costruisci il percorso completo del file
            String fileBasePath = "C:\\APP_FEMA\\Certificazioni\\";
            Path completePath = Paths.get(fileBasePath + decodedPath.replace('/', '\\') + "\\" + filename);

            // Log per il percorso completo
            System.out.println("Percorso completo del file: " + completePath.toString());

            Resource resource;

            // Verifica se il file esiste
            if (!Files.exists(completePath)) {
                System.out.println("File non trovato: " + completePath.toString());
                return ResponseEntity.notFound().build(); // Restituisce 404 se il file non esiste
            } else {
                System.out.println("File trovato: " + completePath.toString());
            }

            try {
                resource = new UrlResource(completePath.toUri());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nel recupero del file.");
            }

            // Determina il tipo di contenuto del file
            String contentType = "application/pdf"; // Puoi utilizzare un metodo per ottenere dinamicamente il tipo di contenuto se necessario
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);
        }
    

    
        @GetMapping("/filesnameCertificazioni")
        public ResponseEntity<List<Map<String, Object>>> getFilesName() {
            String fileBasePath = "C:\\APP_FEMA\\Certificazioni\\";
            File baseDirectory = new File(fileBasePath);

            // Lista per immagazzinare la struttura gerarchica
            List<Map<String, Object>> response = new ArrayList<>();

            if (baseDirectory.exists() && baseDirectory.isDirectory()) {
                // Scansiona le directory principali (Aziende e Privati)
                for (File mainDir : baseDirectory.listFiles()) {
                    if (mainDir.isDirectory()) {
                        // Aggiungi la directory principale (es: NoleggioAziendale, NoleggioPrivato)
                        Map<String, Object> directoryMap = new HashMap<>();
                        directoryMap.put("name", mainDir.getName());
                        directoryMap.put("type", "directory");

                        // Scansiona le sottodirectory e i file
                        List<Map<String, Object>> children = new ArrayList<>();
                        scanDirectory(mainDir, children);

                        // Aggiungi la lista dei figli (sottodirectory e file) alla directory principale
                        directoryMap.put("children", children);
                        response.add(directoryMap);
                    }
                }
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        private void scanDirectory(File dir, List<Map<String, Object>> fileList) {
            for (File file : dir.listFiles()) {
                Map<String, Object> fileMap = new HashMap<>();
                fileMap.put("name", file.getName());
                fileMap.put("lastModified", new Date(file.lastModified()).toString()); // Aggiungi la data di ultima modifica

                String relativePath = dir.getPath().replace("C:\\APP_FEMA\\Certificazioni", "").replace("\\", "/"); // Percorso relativo dal root
                fileMap.put("path", relativePath); // Aggiungi il percorso completo per ogni file o directory

                if (file.isDirectory()) {
                    fileMap.put("type", "directory");
                    // Crea una lista per i file e le sottodirectory della cartella corrente
                    List<Map<String, Object>> children = new ArrayList<>();
                    scanDirectory(file, children); // Ricorsione per scansionare la sottodirectory
                    fileMap.put("children", children);
                } else {
                    fileMap.put("type", "file");
                    // Aggiungi informazioni per distinguere tra azienda e privato
                    File parentDir = file.getParentFile();
                    String parentDirName = parentDir.getParentFile().getName(); // Nome della directory genitore

                    if ("Azienda".equals(parentDirName)) {
                        fileMap.put("isAzienda", true);
                        fileMap.put("azienda", parentDir.getParentFile().getName()); // Nome dell'azienda // Aggiungi la targa dal nome della cartella
                    } else if ("Clienti".equals(parentDirName)) {
                        fileMap.put("isAzienda", false);
                        fileMap.put("cliente", parentDir.getName()); // Nome della targa per i privati
                    }
                }

                fileList.add(fileMap); // Aggiungi il file o la directory alla lista
            }
        }

        @DeleteMapping("/noleggio/{path:.+}/{filename:.+}")
        public ResponseEntity<?> deletePdf(@PathVariable("path") String path, @PathVariable("filename") String filename) {
            // Decodifica il percorso sostituendo '_' con '/'
            String decodedPath = path.replace('_', '/');

            // Log per il percorso decodificato
            System.out.println("Decoded Path: " + decodedPath);

            // Costruisci il percorso completo del file
            String fileBasePath = "C:\\APP_FEMA\\Certificazioni";
            Path completePath = Paths.get(fileBasePath + decodedPath.replace('/', '\\') + "\\" + filename);

            // Log per il percorso completo
            System.out.println("Percorso completo del file: " + completePath.toString());

            try {
                // Verifica se il file esiste
                if (!Files.exists(completePath)) {
                    System.out.println("File non trovato: " + completePath.toString());
                    return ResponseEntity.notFound().build(); // Restituisce 404 se il file non esiste
                } else {
                    System.out.println("File trovato: " + completePath.toString());

                    // Cancella il file
                    Files.delete(completePath);

                    // Log per confermare la cancellazione
                    System.out.println("File cancellato: " + completePath.toString());

                    return ResponseEntity.ok("File cancellato con successo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la cancellazione del file.");
            }
        }
}