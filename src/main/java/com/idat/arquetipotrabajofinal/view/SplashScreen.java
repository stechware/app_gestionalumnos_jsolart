/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

/**
 *
 * @author Solaris
 */
import com.idat.arquetipotrabajofinal.controller.MainController;
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    public SplashScreen() {
        // Panel para el Splash Screen
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Imagen del Splash
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("/icons/splash.png")));
        panel.add(label, BorderLayout.CENTER);

        // Mensaje de carga
        JLabel loadingLabel = new JLabel("Cargando sistema...", JLabel.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(loadingLabel, BorderLayout.SOUTH);

        // Agregar panel a la ventana
        getContentPane().add(panel);
        setSize(400, 300); // Tamaño del Splash
        //setSize(800, 700); // Tamaño del Splash
        setLocationRelativeTo(null); // Centrar en pantalla
    }

    public void showSplash() {
        setVisible(true);

        // Esperar 5 segundos antes de cerrar el Splash y abrir el Login
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
        dispose();

        // Mostrar pantalla de Login
        new LoginView(new MainController()).setVisible(true);
    }
}
