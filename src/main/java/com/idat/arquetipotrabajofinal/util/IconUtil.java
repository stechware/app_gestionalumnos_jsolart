/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.util;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author Solaris
 */
public class IconUtil {
    
     public static ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(IconUtil.class.getResource(path)); // Cargar desde classpath
        Image image = originalIcon.getImage(); // Obtener la imagen
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Redimensionar suavemente
        return new ImageIcon(scaledImage);
    }
    
}
