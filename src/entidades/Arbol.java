package entidades;

import javax.swing.JOptionPane;

public class Arbol {
    
    public Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    public void insertar(int indice, String nombreDependencia, String nombreJefe) {
        Nodo nuevoNodo = new Nodo(indice, nombreDependencia, nombreJefe);
    
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            Nodo aux = raiz;
            Nodo padre;

            while (true) {
                padre = aux;
                if (indice < aux.llave) {
                    aux = aux.izquierda;
                    if (aux == null) {
                        padre.izquierda = nuevoNodo;
                        return;
                    }
                } else {
                    aux = aux.derecha;
                    if (aux == null) {
                        padre.derecha = nuevoNodo;
                        return;
                    }
                }
            }
        }
    }
    
    public void recorrer(Nodo n){
        if(n != null){
            recorrer(n.izquierda);
            System.out.println("ID: " + n.llave + ", Nombre: " + n.nombreDependencia + ", Jefe: " + n.nombreJefe);
            recorrer(n.derecha);
        }
    }
    
    public void mostrarRamas() {
        StringBuilder mensaje = new StringBuilder("Ramas del árbol:\n");
        mostrarRamasRecursivo(raiz, "", mensaje);
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void mostrarRamasRecursivo(Nodo nodo, String prefijo, StringBuilder mensaje) {
        if (nodo != null) {
            mensaje.append(prefijo).append("├─ ID: ").append(nodo.llave).append(", Nombre: ").append(nodo.nombreDependencia).append(", Jefe: ").append(nodo.nombreJefe).append("\n");
            
            // Mostrar ramas a la izquierda
            mostrarRamasRecursivo(nodo.izquierda, prefijo + "│  ", mensaje);
            
            // Mostrar ramas a la derecha
            mostrarRamasRecursivo(nodo.derecha, prefijo + "│  ", mensaje);
        }
    }
    
    public void mostrarRaiz() {
        if (raiz != null) {
            JOptionPane.showMessageDialog(null, "Raíz del árbol:\nID: " + raiz.llave + ", Nombre: " + raiz.nombreDependencia + ", Jefe: " + raiz.nombreJefe);
        } else {
            JOptionPane.showMessageDialog(null, "El árbol está vacío.");
        }
    }

    public void mostrarUltimosNodos() {
        StringBuilder mensaje = new StringBuilder("Últimos nodos del árbol:\n");
        mostrarUltimosNodosRecursivo(raiz, mensaje);
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void mostrarUltimosNodosRecursivo(Nodo nodo, StringBuilder mensaje) {
        if (nodo != null) {
            if (nodo.izquierda == null && nodo.derecha == null) {
                mensaje.append(nodo.llave).append(": ").append(nodo.nombreDependencia).append(", Jefe: ").append(nodo.nombreJefe).append("\n");
            }
            mostrarUltimosNodosRecursivo(nodo.izquierda, mensaje);
            mostrarUltimosNodosRecursivo(nodo.derecha, mensaje);
        }
    }

    private class Nodo{
        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public String nombreDependencia;
        public String nombreJefe;
        
        public Nodo(int indice, String nombreDependencia, String nombreJefe){
            llave = indice;
            this.nombreDependencia = nombreDependencia;
            this.nombreJefe = nombreJefe;
            derecha = null;
            izquierda = null;
            padre = null;
        }
    }
}