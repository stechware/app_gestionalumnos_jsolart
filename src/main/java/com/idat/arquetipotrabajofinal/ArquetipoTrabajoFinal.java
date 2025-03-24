/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.idat.arquetipotrabajofinal;

import com.idat.arquetipotrabajofinal.controller.MainController;
import com.idat.arquetipotrabajofinal.view.SplashScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Solaris
 */
public class ArquetipoTrabajoFinal {
    
    private static final Logger logger = LogManager.getLogger(ArquetipoTrabajoFinal.class);

    public static void main(String[] args) {
        System.out.println("Iniciando Arquetipo TrabajoFinal");
        logger.info("Iniciando Arquetipo TrabajoFinal Desde log4j");
        //new MainController();
        // Mostrar el Splash antes del Login
        new SplashScreen().showSplash();
    }
}
