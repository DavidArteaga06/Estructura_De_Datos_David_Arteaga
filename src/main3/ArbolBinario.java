/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main3;

/**
 *
 * @author PC
 */
class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    private Nodo insertarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }
        
        if (dato < actual.dato) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        }
        
        return actual;
    }
    
    public void inOrder() {
        System.out.print("In-order: ");
        inOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void inOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrderRecursivo(nodo.derecho);
        }
    }
    
    public void postOrder() {
        System.out.print("Post-order: ");
        postOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void postOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            postOrderRecursivo(nodo.izquierdo);
            postOrderRecursivo(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }
    
    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrderRecursivo(nodo.izquierdo);
            preOrderRecursivo(nodo.derecho);
        }
    }
}
