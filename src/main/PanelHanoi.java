/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class PanelHanoi extends JPanel {
    private final int discos = 4;
    private final Stack<Integer>[] torres = new Stack[3];
    private final int anchoDisco = 20;
    private final int altoDisco = 20;

    public PanelHanoi() {
        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }
        for (int i = discos; i >= 1; i--) {
            torres[0].push(i);
        }
    }

    public void iniciar() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                mover(discos, 0, 2, 1);
            } catch (InterruptedException e) {
            }
        }).start();
    }

    private void mover(int n, int origen, int destino, int auxiliar) throws InterruptedException {
        if (n == 1) {
            int disco = torres[origen].pop();
            repaint();
            Thread.sleep(500);
            torres[destino].push(disco);
            repaint();
            Thread.sleep(500);
        } else {
            mover(n - 1, origen, auxiliar, destino);
            mover(1, origen, destino, auxiliar);
            mover(n - 1, auxiliar, destino, origen);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int anchoTorre = getWidth() / 3;
        int baseY = getHeight() - 50;

        for (int i = 0; i < 3; i++) {
            int xCentro = anchoTorre * i + anchoTorre / 2;
            g.setColor(Color.GRAY);
            g.fillRect(xCentro - 5, 100, 10, baseY - 100);
            g.setColor(Color.BLACK);
            int y = baseY;
            for (int disco : torres[i]) {
                int ancho = disco * anchoDisco;
                g.setColor(new Color(50 + disco * 40, 100, 200));
                g.fillRect(xCentro - ancho / 2, y - altoDisco, ancho, altoDisco);
                y -= altoDisco + 5;
            }
        }
    }
}
