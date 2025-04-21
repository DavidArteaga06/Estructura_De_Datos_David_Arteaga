/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDoble listaClientes = new ListaDoble();
        int opcion;

        do {
            try {
                System.out.println("\n===== GESTIÓN DE CLIENTES =====");
                System.out.println("1. Insertar cliente");
                System.out.println("2. Listar clientes hacia la derecha");
                System.out.println("3. Listar clientes hacia la izquierda");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                String entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1 -> insertarCliente(scanner, listaClientes);
                    case 2 -> listaClientes.listarHaciaDerecha();
                    case 3 -> listaClientes.listarHaciaIzquierda();
                    case 4 -> System.out.println("Gracias por usar la aplicación. ¡Hasta pronto!");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                opcion = 0; // No es estrictamente necesario, pero puedes dejarlo si prefieres
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = 0; // Igualmente opcional
            }
        } while (opcion != 4);
    }

    private static void insertarCliente(Scanner scanner, ListaDoble lista) {
        System.out.println("\n--- INSERTAR NUEVO CLIENTE ---");

        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(cedula, nombre);
        lista.insertarOrdenado(nuevoCliente);

        System.out.println("Cliente insertado correctamente.");
    }
}
    
    

