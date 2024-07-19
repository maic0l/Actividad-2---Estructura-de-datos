
package actividadNDos;

import entidades.Arbol;
import javax.swing.JOptionPane;

public class EjercicioUno {
    
    /**Cree un árbol binario, con mínimo 5 niveles de profundidad, que 
     * represente la estructura jerárquica de una organización, es decir, el 
     * organigrama. Tenga encuenta que:
     * 
     * a. Cada nodo debe tener el identificador, el nombre de la dependencia, 
     * el nombre del jefe de la dependencia y los campos de referencia a 
     * susrespectivos hijos (nodos).
     * 
     * b. Debe tener un método para mostrar sus ramas con los datos de cada 
     * nodo
     * 
     * c. Debe tener un método para mostrar su raíz con los datos del nodo
     * 
     * d. Debe tener un método para mostrar solo los últimos nodos del árbol*/

    public static void main(String[] args) {
        short opcion;
        Arbol arbol = new Arbol();
        
arbol.insertar(20, "CEO", null); // 1
    
    arbol.insertar(10, "D. general", "CEO"); // 2.1
    
    arbol.insertar(5, "Finanzas", "D. general"); // 3.1
    
    arbol.insertar(3, "Contabilidad", "Finanzas"); // 4.1
    arbol.insertar(2, "Contador principal", "Contabilidad"); // 5.1
    arbol.insertar(4, "Analista Financiero", "Contabilidad"); // 5.2
    
    arbol.insertar(7, "Tesorería", "Finanzas"); // 4.2
    arbol.insertar(8, "Tesorero", "Tesorería"); // 5.1
    arbol.insertar(6, "Analista de Tesorería", "Tesorería"); // 5.2
    
    arbol.insertar(15, "Operaciones", "D. general"); // 3.2
    
    arbol.insertar(13, "Producción", "Operaciones"); // 4.1
    arbol.insertar(12, "Gerente de Producción", "Producción"); // 5.1
    arbol.insertar(14, "Ingeniero de Procesos", "Producción"); // 5.2
    
    arbol.insertar(17, "Logística", "Operaciones"); // 4.1
    arbol.insertar(16, "Gerente de Logística", "Logística"); // 5.1
    arbol.insertar(18, "Coordinador de Almacén", "Logística"); // 5.2
    
    arbol.insertar(30, "D. Comercial", "CEO"); // 2.2
    
    arbol.insertar(25, "Ventas", "D. Comercial"); // 3.1
    
    arbol.insertar(22, "Ventas nacionales", "Ventas"); // 4.1
    arbol.insertar(21, "director de ventas", "Ventas nacionales"); // 5.1
    arbol.insertar(23, "Ejecutivo", "Ventas nacionales"); // 5.2
    
    arbol.insertar(27, "Marketing", "D. Comercial"); // 4.2
    arbol.insertar(26, "Director de Marketing", "Marketing"); // 5.1
    arbol.insertar(28, "Especialista en Redes Sociales", "Marketing"); // 5.2
    
    arbol.insertar(35, "Servicio al cliente", "D. general"); // 3.2
    
    arbol.insertar(32, "Atención al cliente", "Servicio al cliente"); // 4.1
    arbol.insertar(31, "Gerente de Servicio al Cliente", "Atención al cliente"); // 5.1
    arbol.insertar(33, "Representante de Servicio al Cliente", "Atención al cliente"); // 5.2
    
    arbol.insertar(37, "Soporte Técnico", "Servicio al cliente"); // 4.1
    arbol.insertar(36, "Especialista en Hardware", "Soporte Técnico"); // 5.1
    arbol.insertar(38, "Supervisor de Soporte", "Soporte Técnico"); // 5.2
    
        try {
            // Ciclo principal del menú de opciones
            do {
                do{
                    opcion = Short.parseShort(JOptionPane.showInputDialog("""
                                                                        1. Mostrar ramas
                                                                        2. Mostrar raiz
                                                                        3. últimos nodos del árbol
                                                                        0. Salir
                                                                        Ingrese su opción: """));
                }while(opcion< 0 || opcion > 4); 
                
                switch (opcion) {
                    case 1:
                        arbol.mostrarRamas();
                        break;
                    case 2:                   
                        arbol.mostrarRaiz();
                        break;
                    case 3:
                        arbol.mostrarUltimosNodos();
                        break;  
                    case 0:
                        // Opción para salir del programa
                        System.out.println("Saliendo del programa...");
                        break;
                        
                    default: 
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }while (opcion != 0);

        } catch (Exception e) {
            // Manejo de excepciones y mensajes de error
            System.out.println("Se ha generado un error: " + e.getMessage());
            System.out.println("Se ha generado un error: " + e.getCause());
        }
    }
    
}
