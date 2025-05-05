/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listacircularclientes;

/**
 * Clase que representa un nodo de la lista circular de clientes
 */
public class Nodo {
    String cedula;
    String nombre;
    Nodo siguiente;
    
    public Nodo(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.siguiente = null;
    }
}