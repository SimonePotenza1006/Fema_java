package com.example.demo.util;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

public class ImageUtil {

public static byte[] resizeImage(MultipartFile mpFile) throws IOException {
	InputStream inputStream = mpFile.getInputStream();
    BufferedImage bufferedImage = ImageIO.read(inputStream);

    BufferedImage resizedImage = new BufferedImage((bufferedImage.getWidth())/2, (bufferedImage.getHeight())/2, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = resizedImage.createGraphics();
    graphics2D.drawImage(bufferedImage, 0, 0, (bufferedImage.getWidth())/2, (bufferedImage.getHeight())/2, null);
    graphics2D.dispose();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(resizedImage, "png", baos);
    byte[] bytes = baos.toByteArray();


    return bytes;
}

public static byte[] compressImage24(MultipartFile mpFile) {
    float quality = 0.3f;
    String imageName = mpFile.getOriginalFilename();
    String imageExtension = imageName.substring(imageName.lastIndexOf(".") + 1);
    // Returns an Iterator containing all currently registered ImageWriters that claim to be able to encode the named format.
    // You don't have to register one yourself; some are provided.
    ImageWriter imageWriter = ImageIO.getImageWritersByFormatName(imageExtension).next();
    ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
    imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); // Check the api value that suites your needs.
    // A compression quality setting of 0.0 is most generically interpreted as "high compression is important,"
    // while a setting of 1.0 is most generically interpreted as "high image quality is important."
    imageWriteParam.setCompressionQuality(quality);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // MemoryCacheImageOutputStream: An implementation of ImageOutputStream that writes its output to a regular
    // OutputStream, i.e. the ByteArrayOutputStream.
    ImageOutputStream imageOutputStream = new MemoryCacheImageOutputStream(baos);
    // Sets the destination to the given ImageOutputStream or other Object.
    imageWriter.setOutput(imageOutputStream);
    BufferedImage originalImage = null;
    try (InputStream inputStream = mpFile.getInputStream()) {
        originalImage = ImageIO.read(inputStream);
    } catch (IOException e) {
        String info = String.format("compressImage - bufferedImage (file %s)- IOException - message: %s ", imageName, e.getMessage());
        System.out.println(info);//logger.error(info);
        return baos.toByteArray();
    }
    IIOImage image = new IIOImage(originalImage, null, null);
    try {
        imageWriter.write(null, image, imageWriteParam);
    } catch (IOException e) {
        String info = String.format("compressImage - imageWriter (file %s)- IOException - message: %s ", imageName, e.getMessage());
        System.out.println(info);//logger.error(info);
    } finally {
        imageWriter.dispose();
    }
    return baos.toByteArray();
}

public static byte[] compressImageNew(MultipartFile image) throws IOException
{


    InputStream inputStream = image.getInputStream();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    float imageQuality = 0.3f;

    // Create the buffered image
    BufferedImage bufferedImage = ImageIO.read(inputStream);
    //BufferedImage imagehg = Thumbnails.of(inputStream).scale(1).asBufferedImage();


    AffineTransform tx = new AffineTransform();
    int w0 = bufferedImage.getWidth();
    int h0 = bufferedImage.getHeight();
    int w1 = w0;
    int h1 = h0;

    int centerX = w0 / 2;
    int centerY = h0 / 2;

    if (4 % 2 == 1) {
        w1 = h0;
        h1 = w0;

        if (4 % 4 == 1) {
            centerX = Math.max(w0, h0) / 2;
        } else {
            centerX = Math.min(w0, h0) / 2;
        }

        centerY = centerX;
    }
    //tx.setToQuadrantRotation(4, centerX, centerY);
  //tx.scale(scalex, scaley);
  //tx.shear(shiftx, shifty);
  //tx.translate(x, y);
  //tx.rotate(Math.PI/2, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
  bufferedImage = op.filter(bufferedImage, null);

    // Get image writers
    Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("png"); // Input your Format Name here

    if (!imageWriters.hasNext())
        throw new IllegalStateException("Writers Not Found!!");

    ImageWriter imageWriter = imageWriters.next();
    ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
    imageWriter.setOutput(imageOutputStream);

    ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

    // Set the compress quality metrics
    imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    imageWriteParam.setCompressionQuality(imageQuality);

    // Compress and insert the image into the byte array.
    imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);

    byte[] imageBytes = outputStream.toByteArray();

    // close all streams
    inputStream.close();
    outputStream.close();
    imageOutputStream.close();
    imageWriter.dispose();


    return imageBytes;
}

// public static byte[] compressImage(byte[] data) {

//     Deflater deflater = new Deflater();
//     deflater.setLevel(Deflater.BEST_COMPRESSION);
//     deflater.setInput(data);
//     deflater.finish();

//     ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//     byte[] tmp = new byte[4*1024];
//     while (!deflater.finished()) {
//         int size = deflater.deflate(tmp);
//         outputStream.write(tmp, 0, size);
//     }
//     try {
//         outputStream.close();
//     } catch (Exception e) {
//     }
//     return outputStream.toByteArray();
// }

    public static byte[] compressImage(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data must not be null or empty.");
        }

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[16 * 1024]; // Aumentato a 16 KB per efficienza
            while (!deflater.finished()) {
                int size = deflater.deflate(buffer);
                outputStream.write(buffer, 0, size);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error during compression", e);
        } finally {
            deflater.end(); // Rilascia le risorse del Deflater
        }
    }


    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception exception) {
        }
        return outputStream.toByteArray();
    }

    public static byte[] compressImage0912(MultipartFile image) throws IOException, ImageProcessingException, MetadataException{

        InputStream inputStream = image.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        float imageQuality = 0.3f;

        // Leggi i metadati EXIF
        int orientation = 0;
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(image.getInputStream());
            ExifIFD0Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
            if (directory != null) {
                orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
                // Procedi con l'orientamento
            } else {
                System.out.println("Nessuna directory EXIF trovata.");
            }
        } catch (MetadataException e) {
            System.err.println("Errore nella lettura dei metadati: " + e.getMessage());
        }

        
        // Create the buffered image
        BufferedImage bufferedImage = ImageIO.read(inputStream);

        // Applica la rotazione in base all'orientamento EXIF
        bufferedImage = rotateImage(bufferedImage, orientation);
        
        // Converti l'immagine in RGB se necessario
        //bufferedImage = convertToRGB(bufferedImage);
        
     // Converti l'immagine in RGB se necessario
        BufferedImage rgbImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        rgbImage.getGraphics().drawImage(bufferedImage, 0, 0, null);
        
        // Get image writers
        Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpg"); // Input your Format Name here

        if (!imageWriters.hasNext())
            throw new IllegalStateException("Writers Not Found!!");

        ImageWriter imageWriter = imageWriters.next();
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);

        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

        // Set the compress quality metrics
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(imageQuality);

        // Compress and insert the image into the byte array.
        imageWriter.write(null, new IIOImage(rgbImage, null, null), imageWriteParam);

        byte[] imageBytes = outputStream.toByteArray();

        // close all streams
        inputStream.close();
        outputStream.close();
        imageOutputStream.close();
        imageWriter.dispose();


        return imageBytes;
    }
    
    private static BufferedImage convertToRGB(BufferedImage img) {
        // Se l'immagine è già in RGB, restituiscila
        if (img.getType() == BufferedImage.TYPE_INT_RGB) {
            return img;
        }

        // Altrimenti, crea una nuova immagine RGB
        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        newImage.getGraphics().drawImage(img, 0, 0, null);
        return newImage;
    }
    
    private static BufferedImage rotateImage(BufferedImage img, int orientation) {
        switch (orientation) {
            case 3:
                return rotate(img, 180);
            case 6:
                return rotate(img, 90);
            case 8:
                return rotate(img, 270);
            default:
                return img; // Nessuna rotazione necessaria
        }
    }
    
    private static BufferedImage rotate(BufferedImage img, int angle) {
        // Implementa la logica di rotazione qui
        // Puoi usare AffineTransform per ruotare l'immagine
        AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(angle), img.getWidth() / 2, img.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(img, null);
    }
    
}