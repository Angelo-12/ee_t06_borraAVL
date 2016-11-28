/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class ArbolAVL<T extends Comparable> {

    public nodoAVL<T> raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public void rotaciones(nodoAVL actual) {
        nodoAVL nodo1, nodo2, nodo3;
        nodo1 = actual;

        if (nodo1.getFe() == 2) {
            nodo2 = nodo1.getDerecha();
            if (nodo2.getFe() == 1) {
                nodo3 = nodo2.getDerecha();
                rotacionDerDer(nodo1, nodo2, nodo3);
            } else {
                nodo3 = nodo2.getIzquierda();
                rotacionDerIzq(nodo1, nodo2, nodo3);
            }

        } else if (nodo1.getFe() == -2) {
            nodo2 = nodo1.getIzquierda();
            if (nodo2.getFe() == -1) {
                nodo3 = nodo2.getIzquierda();
                rotacionIzqIzq(nodo1, nodo2, nodo3);
            } else {
                nodo3 = nodo2.getDerecha();
                rotacionIzqDer(nodo1, nodo2, nodo3);
            }
        }

        actualizarNivel(raiz, 1);
    }

    public void rotacionDerDer(nodoAVL nodo1, nodoAVL nodo2, nodoAVL nodo3) {
        nodoAVL papa, aux;

        papa = nodo1.getPapa();
        aux = nodo2.getIzquierda();

        if (aux != null) {
            aux.setPapa(nodo1);
        }
        nodo1.setDerecha(aux);
        nodo1.setPapa(nodo2);
        nodo2.setIzquierda(nodo1);
        nodo2.setPapa(papa);

        if (papa == null) {
            nodo2.setPapa(null);
            raiz = nodo2;
        } else if (nodo2.getElemento().compareTo(papa.getElemento()) < 0) {
            papa.setDerecha(nodo2);
        } else {
            papa.setIzquierda(nodo2);
        }
        nodo2.setLevel(nodo2.getNivel() - 1);
        nodo2.setFe(nodo2.getFe() - 1);

        nodo1.setLevel(nodo1.getNivel() + 1);
        nodo1.setFe(nodo1.getFe() - 2);

        nodo3.setLevel(nodo3.getNivel() - 1);
    }

    public void rotacionDerIzq(nodoAVL nodo1, nodoAVL nodo2, nodoAVL nodo3) {
        nodoAVL papa, aux1, aux2;

        papa = nodo1.getPapa();
        aux1 = nodo3.getIzquierda();
        aux2 = nodo3.getDerecha();

        if (aux1 != null) {
            aux1.setPapa(nodo1);
        }
        nodo1.setDerecha(aux1);
        if (aux2 != null) {
            aux2.setPapa(nodo2);
        }
        nodo2.setIzquierda(aux2);
        nodo1.setPapa(nodo3);
        nodo2.setPapa(nodo3);
        nodo3.setIzquierda(nodo1);
        nodo3.setDerecha(nodo2);
        nodo3.setPapa(papa);

        if (papa == null) {
            nodo3.setPapa(null);
            raiz = nodo3;
        } else if (nodo3.getElemento().compareTo(papa.getElemento()) < 0) {
            papa.setIzquierda(nodo3);
        } else {
            papa.setDerecha(nodo3);
        }

        nodo2.setFe(nodo2.getFe() + 1);
        nodo1.setLevel(nodo1.getNivel() + 1);
        nodo1.setFe(nodo1.getFe() - 2);
        nodo3.setLevel(nodo3.getNivel() - 2);

    }

    public void rotacionIzqIzq(nodoAVL nodo1, nodoAVL nodo2, nodoAVL nodo3) {
        nodoAVL papa, aux;
        papa = nodo1.getPapa();
        aux = nodo2.getDerecha();

        if (aux != null) {
            aux.setPapa(nodo1);
        }
        nodo1.setIzquierda(aux);
        nodo1.setPapa(nodo2);
        nodo3.setPapa(nodo2);
        nodo2.setDerecha(nodo1);
        nodo2.setIzquierda(nodo3);
        nodo2.setPapa(papa);

        if (papa == null) {
            nodo2.setPapa(null);
            raiz = nodo2;
        } else if (nodo2.getElemento().compareTo(papa.getElemento()) < 0) {
            papa.setIzquierda(nodo2);
        } else {
            papa.setDerecha(nodo2);
        }
        nodo2.setLevel(nodo2.getNivel() - 1);
        nodo2.setFe(nodo2.getFe() + 1);
        nodo1.setLevel(nodo1.getNivel() + 1);
        nodo1.setFe(nodo1.getFe() + 2);
        nodo3.setLevel(nodo3.getNivel() - 1);
    }

    public void rotacionIzqDer(nodoAVL nodo1, nodoAVL nodo2, nodoAVL nodo3) {
        nodoAVL papa, aux1, aux2;

        papa = nodo1.getPapa();
        aux1 = nodo3.getIzquierda();
        aux2 = nodo3.getDerecha();

        if (aux1 != null) {
            aux1.setPapa(nodo2);
        }
        nodo2.setDerecha(aux1);
        if (aux2 != null) {
            aux2.setPapa(nodo1);
        }
        nodo1.setIzquierda(aux2);
        nodo1.setPapa(nodo3);
        nodo2.setPapa(nodo3);
        nodo3.setIzquierda(nodo2);
        nodo3.setDerecha(nodo1);
        nodo3.setPapa(papa);

        if (papa == null) {
            nodo3.setPapa(null);
            raiz = nodo3;
        } else if (nodo3.getElemento().compareTo(papa.getElemento()) > 0) {
            papa.setDerecha(nodo3);
        } else {
            papa.setIzquierda(nodo3);
        }
        nodo2.setFe(nodo2.getFe() - 1);
        nodo1.setLevel(nodo1.getNivel() + 1);
        nodo1.setFe(nodo1.getFe() + 2);
        nodo3.setLevel(nodo3.getNivel() - 2);
    }

    public void actualizarNivel(nodoAVL<T> actual, int level) {
        if (actual == null) {
            return;
        }
        actual.setLevel(level);
        actualizarNivel(actual.getIzquierda(), level + 1);
        actualizarNivel(actual.getDerecha(), level + 1);
    }
    public int altura(nodoAVL<T> actual, int nivel) {
        if (actual == null) {
            return nivel - 1;
        }
        int alturaDer = altura(actual.getDerecha(), nivel + 1);
        int alturaIzq = altura(actual.getIzquierda(), nivel + 1);
        if (alturaDer > alturaIzq) {
            return alturaDer;
        } else {
            return alturaIzq;
        }
    }
    public nodoAVL<T> eliminar(T elem) {
        
        nodoAVL<T> nodo=raiz,papa, aux,aux2;

        if (nodo == null) {
           return null;
        } else {
            papa = nodo.getPapa();
            aux2 = papa.getPapa();
            if ((nodo.getIzquierda() == null) && nodo.getDerecha() == null) {
                if (nodo.getElemento().compareTo(papa.getElemento()) <= 0) {
                    papa.setIzquierda(null);
                } else {
                    papa.setDerecha(null);
                }
            }
            if (nodo.getIzquierda() == null) {
                nodo.setElemento(nodo.getDerecha().getElemento());
                nodo.getDerecha().setPapa(null);
                nodo.setDerecha(null);
                nodo.setFe(nodo.getFe() - 1);
            } else if (nodo.getDerecha() == null) {
                nodo.setElemento(nodo.getIzquierda().getElemento());
                nodo.getIzquierda().setPapa(null);
                nodo.setIzquierda(null);
                nodo.setFe(nodo.getFe() + 1);
            } else {
                aux = nodo.getIzquierda();
                papa = aux.getPapa();
                papa.setDerecha(null);
                aux.setPapa(null);
                nodo.setElemento(aux.getElemento());
            }
            while (papa != null) {
                papa.setFe(altura(papa.getDerecha(), papa.getNivel()) - altura(papa.getIzquierda(), papa.getNivel()));
                papa = papa.getPapa();
            }
        }
        return nodo;
    }
}
