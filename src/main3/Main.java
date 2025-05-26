/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n=== MENU ARBOL BINARIO ===");
                System.out.println("1. Insertar dato");
                System.out.println("2. Imprimir en In-order");
                System.out.println("3. Imprimir en Post-order");
                System.out.println("4. Imprimir en Pre-order");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el dato a insertar: ");
                        int dato = scanner.nextInt();
                        arbol.insertar(dato);
                        System.out.println("Dato insertado correctamente");
                    }
                        
                    case 2 -> arbol.inOrder();
                        
                    case 3 -> arbol.postOrder();
                        
                    case 4 -> arbol.preOrder();
                        
                    case 5 -> System.out.println("Saliendo del programa...");
                        
                    default -> System.out.println("Opcion no valida");
                }
            } while (opcion != 5);
        }
    }
}