package linkelist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaDoblementeEnlazadaCircular<T> implements IList<T>, Iterable<T> {

    protected NodoSimple<T> inicio;
    protected NodoSimple<T> fin;
    protected NodoSimple<T> actual;
    protected int nElementos;

    private class NodoSimple<E> {
        private E dato;
        private NodoSimple<E> sig;
        private NodoSimple<E> ant;

        public NodoSimple(E dato) {
            this.dato = dato;
        }
    }

    public ListaDoblementeEnlazadaCircular() {
        inicio = null;
        fin = null;
        actual = null;
        nElementos = 0;
    }

    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);

        if (empty()) {
            inicio = nodoNuevo;
            fin = nodoNuevo;
            nodoNuevo.sig = nodoNuevo;
            nodoNuevo.ant = nodoNuevo;
        } else {
            nodoNuevo.ant = fin;
            nodoNuevo.sig = inicio;
            fin.sig = nodoNuevo;
            inicio.ant = nodoNuevo;
            fin = nodoNuevo;
        }

        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de limite");
        }

        if (index == nElementos) {
            append(elemento);
            return;
        }

        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);

        if (index == 0) {
            if (empty()) {
                inicio = nodoNuevo;
                fin = nodoNuevo;
                nodoNuevo.sig = nodoNuevo;
                nodoNuevo.ant = nodoNuevo;
            } else {
                nodoNuevo.sig = inicio;
                nodoNuevo.ant = fin;

                inicio.ant = nodoNuevo;
                fin.sig = nodoNuevo;

                inicio = nodoNuevo;
            }
        } else {
            NodoSimple<T> nodo = inicio;

            for (int i = 0; i < index; i++) {
                nodo = nodo.sig;
            }

            nodoNuevo.ant = nodo.ant;
            nodoNuevo.sig = nodo;

            nodo.ant.sig = nodoNuevo;
            nodo.ant = nodoNuevo;
        }

        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de los limites");
        }

        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        T datoRemovido = nodo.dato;

        if (nElementos == 1) {
            inicio = null;
            fin = null;
            actual = null;
        } else {
            nodo.ant.sig = nodo.sig;
            nodo.sig.ant = nodo.ant;

            if (nodo == inicio) {
                inicio = nodo.sig;
            }

            if (nodo == fin) {
                fin = nodo.ant;
            }

            if (actual == nodo) {
                actual = nodo.sig;
            }
        }

        nElementos--;
        return datoRemovido;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            if (Objects.equals(nodo.dato, elemento)) {
                if (nElementos == 1) {
                    inicio = null;
                    fin = null;
                    actual = null;
                } else {
                    nodo.ant.sig = nodo.sig;
                    nodo.sig.ant = nodo.ant;

                    if (nodo == inicio) {
                        inicio = nodo.sig;
                    }

                    if (nodo == fin) {
                        fin = nodo.ant;
                    }

                    if (actual == nodo) {
                        actual = nodo.sig;
                    }
                }

                nElementos--;
                return true;
            }

            nodo = nodo.sig;
        }

        return false;
    }

    @Override
    public int indexOf(T elemento) {
        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            if (Objects.equals(nodo.dato, elemento)) {
                return i;
            }

            nodo = nodo.sig;
        }

        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limite");
        }

        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        return nodo.dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limite");
        }

        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        nodo.dato = elemento;
    }

    public void invertir() {
        if (nElementos < 2) {
            return;
        }

        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            NodoSimple<T> siguiente = nodo.sig;

            nodo.sig = nodo.ant;
            nodo.ant = siguiente;

            nodo = siguiente;
        }

        NodoSimple<T> temporal = inicio;
        inicio = fin;
        fin = temporal;
    }

    public void concatenar(ListaDoblementeEnlazadaCircular<T> otraLista)
            throws ListException {

        if (otraLista == null || otraLista.empty()) {
            return;
        }

        if (otraLista == this) {
            int cantidad = nElementos;
            NodoSimple<T> nodo = inicio;

            for (int i = 0; i < cantidad; i++) {
                append(nodo.dato);
                nodo = nodo.sig;
            }

            return;
        }

        NodoSimple<T> nodo = otraLista.inicio;

        for (int i = 0; i < otraLista.nElementos; i++) {
            append(nodo.dato);
            nodo = nodo.sig;
        }
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
        actual = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public void irInicio() throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        actual = inicio;
    }

    @Override
    public void irFinal() throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        actual = fin;
    }

    public void next() throws ListException {
        if (actual == null) {
            throw new ListException("Cursor sin posicion");
        }

        actual = actual.sig;
    }

    @Override
    public void previous() throws ListException {
        if (actual == null) {
            throw new ListException("Cursor sin posicion");
        }

        actual = actual.ant;
    }

    public T getActual() throws ListException {
        if (actual == null) {
            throw new ListException("Cursor sin posicion");
        }

        return actual.dato;
    }

    @Override
    public Iterator<T> Iterador() {
        return iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoSimple<T> nodo = inicio;
            private int recorridos = 0;

            @Override
            public boolean hasNext() {
                return recorridos < nElementos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T dato = nodo.dato;
                nodo = nodo.sig;
                recorridos++;

                return dato;
            }
        };
    }

    @Override
    public String toString() {
        String resultado = "[";
        NodoSimple<T> nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            resultado += nodo.dato;

            if (i < nElementos - 1) {
                resultado += ", ";
            }

            nodo = nodo.sig;
        }

        return resultado + "]";
    }
}