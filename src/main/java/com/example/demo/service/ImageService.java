package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

@Component
public class ImageService {

  public void getImageFromUrl(String urls,String photoName){

    URL url = null;
    try {
      url = new URL(urls);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    BufferedImage img = null;
    try {
      img = ImageIO.read(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
    File file = new File("/home/pcatalini/Documents/fotosTW/"+photoName);
    try {
      ImageIO.write(img, "jpg", file);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
