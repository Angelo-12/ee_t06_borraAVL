/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class nodoAVL<T extends Comparable> {
    
    T elem;
    nodoAVL<T> hijoIzquierdo;
    nodoAVL<T> hijoDerecho, papa;
    int fe;
    int nivel;

    public nodoAVL() {
        this.fe=0;
        this.nivel=1;
    }
    
    public nodoAVL(T elem){
        this.elem=elem;
        this.fe=0;
        this.nivel=1;
    }

    public T getElemento() {
        return elem;
    }

    public void setElemento(T elem) {
        this.elem = elem;
    }

    public void setIzquierda(nodoAVL<T> izquierda) {
        this.hijoIzquierdo = izquierda;
    }

    public void setDerecha(nodoAVL<T> derecha) {
        this.hijoDerecho = derecha;
    }

    public void setPapa(nodoAVL<T> papa) {
        this.papa = papa;
    }

    public void setFe(int fc) {
        this.fe = fc;
    }

    public nodoAVL<T> getIzquierda() {
        return hijoIzquierdo;
    }

    public nodoAVL<T> getDerecha() {
        return hijoDerecho;
    }

    public nodoAVL<T> getPapa() {
        return papa;
    }

    public int getFe() {
        return fe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setLevel(int nivel) {
        this.nivel = nivel;
    }

    public int compareTo(nodoAVL<T> otro) {
        return otro.getElemento().compareTo(this.elem);
    }
}
