
package linkelist;

public class LinkeList {

    public static void main(String[] args)throws ListException {
        
        // LISTA SIMPLE
        
        /*
        ListaEnlazada<String> miLista = new ListaEnlazada<>();
        
        miLista.append("Manzana");
        miLista.append("Pera");
        miLista.append("Coco");
        
        System.out.println("Lista original: ");
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println("Indice "+ i +": "+ miLista.get(i));
        }
        System.out.println("Tamano inicial: "+miLista.size());
        
        miLista.insert("Uvas", 1);
        System.out.println("\nLista despues de inserta Uvas:");
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println("Indice"+ i + ": "+miLista.get(i)); 
        }
        
        String borrado = miLista.remove(0);
        System.out.println("\nSe borro el elemento"+ borrado);
        System.out.println("Mi Lista despues del remove: ");
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println(miLista.get(i));
        }
        
        System.out.println("\nLista Invertida: ");
        miLista.invertir();
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println(miLista.get(i));
        }
        
        ListaEnlazada<String> lista2 = new ListaEnlazada<>();
        lista2.append("Tomate");
        lista2.append("Lechuga");
        
        miLista.concatenar(lista2);
        System.out.println("\nListas Concatenadas: ");
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println("Indice"+i+": "+miLista.get(i)); 
        }
        System.out.println("\nTamano despues de concatenar las listas: "+ miLista.size());
        
        miLista.clear();
        System.out.println("Tamano despues de usar clear: "+ miLista.size());*/
    
        // LISTA DOBLEMENTE ENLAZADA CIRCULAR
        System.out.println("-------------------------------");
        System.out.println("Pruebas de Lista doblemente enlazada circular");
        System.out.println("------------------------------- \n");
        
        ListaDoblementeEnlazadaCircular<String> listaCircular = new ListaDoblementeEnlazadaCircular<>();
        
        listaCircular.append("Manzana");
        listaCircular.append("Pera");
        listaCircular.append("Coco");

        System.out.println(listaCircular);

        System.out.println("El  iterador se coloca al inicio");
        listaCircular.irInicio();
        System.out.println(listaCircular.getActual());

        System.out.println("\nEl iterado se coloca al final");
        listaCircular.irFinal();
        System.out.println(listaCircular.getActual());

        System.out.println("\nEl iterador se coloca nodo anterior");
        listaCircular.previous();
        System.out.println(listaCircular.getActual());

        System.out.println("\nElementos:");
        for (String fruta : listaCircular) {
            System.out.println(fruta);
        }
        
        /*ListaDoblementeEnlazadaCircular<String> listaCircular = new ListaDoblementeEnlazadaCircular<>();

        listaCircular.append("Manzana");
        listaCircular.append("Pera");
        listaCircular.append("Coco");

        listaCircular.irInicio();
        System.out.println("El  iterador se coloca al inicio");
        System.out.println();
        
        listaCircular.irFinal();
        System.out.println("El iterado se coloca al final");
        
        listaCircular.previous();
        System.out.println("El iterador se coloca nodo anterior");
        */
    }   
    
}
