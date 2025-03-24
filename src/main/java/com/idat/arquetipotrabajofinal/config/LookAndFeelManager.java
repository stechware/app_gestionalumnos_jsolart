/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.config;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Solaris
 */

public class LookAndFeelManager {
    
    // Mapa con los Look and Feel disponibles
    private static final Map<String, String> LOOK_AND_FEELS = new HashMap<>();

    static {
        LOOK_AND_FEELS.put("Java (Por Defecto)", UIManager.getCrossPlatformLookAndFeelClassName());
        LOOK_AND_FEELS.put("Nimbus", "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        LOOK_AND_FEELS.put("Metal", "javax.swing.plaf.metal.MetalLookAndFeel");
        LOOK_AND_FEELS.put("Windows", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        LOOK_AND_FEELS.put("Windows Classic", "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
    }

    /**
     * Cambia el Look and Feel de la aplicación.
     *
     * @param frame La ventana principal que se actualizará con el nuevo Look and Feel.
     * @param lookAndFeelName El nombre del Look and Feel (debe estar en el mapa LOOK_AND_FEELS).
     */
    public static void setLookAndFeel(JFrame frame, String lookAndFeelName) {
        try {
            String lookAndFeelClass = LOOK_AND_FEELS.get(lookAndFeelName);
            if (lookAndFeelClass != null) {
                UIManager.setLookAndFeel(lookAndFeelClass);
                SwingUtilities.updateComponentTreeUI(frame);
                frame.pack(); // Ajusta el tamaño si es necesario
            } else {
                JOptionPane.showMessageDialog(frame, "Look and Feel no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "No se pudo aplicar el Look and Feel.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Devuelve un array con los nombres de los Look and Feel disponibles.
     * @return Un array con los nombres.
     */
    public static String[] getAvailableLookAndFeels() {
        return LOOK_AND_FEELS.keySet().toArray(new String[0]);
    }
}
