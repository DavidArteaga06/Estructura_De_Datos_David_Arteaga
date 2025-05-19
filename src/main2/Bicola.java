/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main2;

public class Bicola {
    private Nodo inicio;
    private Nodo fin;

    public Bicola() {
        inicio = null;
        fin = null;
    }

    public void insertarIzquierda(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    public void insertarDerecha(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (fin == null) {
            inicio = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Integer atenderIzquierda() {
        if (inicio == null) return null;
        int valor = inicio.valor;
        inicio = inicio.siguiente;
        if (inicio == null) fin = null;
        return valor;
    }

    public Integer atenderDerecha() {
        if (inicio == null) return null;
        if (inicio == fin) {
            int valor = fin.valor;
            inicio = fin = null;
            return valor;
        }
        Nodo actual = inicio;
        while (actual.siguiente != fin) {
            actual = actual.siguiente;
        }
        int valor = fin.valor;
        fin = actual;
        fin.siguiente = null;
        return valor;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null) {
            sb.append(actual.valor).append(" ");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}
