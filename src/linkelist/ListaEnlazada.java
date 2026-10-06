
package linkelist;

import java.util.Iterator;

public class ListaEnlazada <T> implements IList<T>, Iterable<T>{
    
    protected NodoSimple<T> inicio;
    protected int nElementos;
    
    private class NodoSimple<T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato){
            this.dato = dato;
        }
    }
    
    //constructor solo esta inicianizado la clase
    public ListaEnlazada(){
        inicio= null;
        nElementos = 0;
    }

    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo= new NodoSimple<>(elemento);
        NodoSimple nodo = inicio;
        
        if (nodo == null) {
            inicio = nodoNuevo;
        }else{
            
            while (nodo.sig != null) {  
                
                nodo=nodo.sig;   
            }
            
            nodo.sig = nodoNuevo;
        }
        
        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index< 0 || index > nElementos) {
          throw new ListException("Indice fuera de limite");
        }
        
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        
        if (index == 0) {
            nodoNuevo.sig = inicio;
            inicio =nodoNuevo;  
        }else{
            NodoSimple<T> nodoPrevio = inicio;
            
            for (int i = 0; i < index - 1; i++) {
                nodoPrevio = nodoPrevio.sig;   
            }
            nodoNuevo.sig = nodoPrevio.sig;
            nodoPrevio.sig = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        if (index <0 || index >=nElementos) {
            throw new ListException("Indice fuera de los limites");  
        }
        
        T datoRemovido;
        
        if (index == 0) {
            datoRemovido = inicio.dato;
            inicio = inicio.sig;    
        }else{
            NodoSimple<T> nodoPrevio = inicio;
            
            for (int i = 0; i < index - 1; i++) {
                nodoPrevio = nodoPrevio.sig;
            }
            
            NodoSimple<T> nodoBorrar = nodoPrevio.sig;
            datoRemovido = nodoBorrar.dato;
            
            nodoPrevio.sig = nodoBorrar.sig;
        }
        
        nElementos --;
        return datoRemovido;

    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(T element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T get(int index) throws ListException {
        if (index < 0 || index>= nElementos) {
            throw new ListException("Indice Fuera de Limite"); 
        }
        NodoSimple<T> nodoActual = inicio;
        
        for (int i = 0; i < index; i++) {
            nodoActual = nodoActual.sig;  
        }
        return nodoActual.dato;
    }
    
    public void invertir(){
        if (inicio == null || inicio.sig == null) {
            return;  
        }
        NodoSimple<T> anterior = null;
        NodoSimple<T> actual = inicio;
        NodoSimple<T> siguiente = null;
    
        while (actual != null) {
        siguiente = actual.sig;
        
        actual.sig  = anterior;
        
        anterior = actual;
        actual = siguiente;  
        }
        inicio = anterior;
    }
 
    public void concatenar(ListaEnlazada otraLista){
        if (otraLista == null || otraLista.inicio== null) {
            return;  
        }
        NodoSimple<T> ultimo = this.inicio;
        if (ultimo != null) {
            while (ultimo.sig != null) {   
                ultimo = ultimo.sig;
            }
        }
        NodoSimple<T> actualOtra = otraLista.inicio;
        
        while (actualOtra != null) {       
            NodoSimple<T> nodoNuevo = new NodoSimple<>(actualOtra.dato);
            
            if (this.inicio == null) {
                this.inicio = nodoNuevo;
                ultimo = nodoNuevo;
            }else{
            ultimo.sig = nodoNuevo;
            ultimo = nodoNuevo;
            }
            this.nElementos++;
            actualOtra = actualOtra.sig;
        }
    }
    
    

    @Override
    public void set(T elemento, int index) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        inicio= null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return this.nElementos;
    }

    @Override
    public Iterator<T> Iterador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
