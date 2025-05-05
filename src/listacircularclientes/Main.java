/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listacircularclientes;

import javax.swing.SwingUtilities;

/**
 * Clase principal para iniciar la aplicacion
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListaCircularClientes().setVisible(true);
        });
    }
}