
package actividadNDos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class EjercicioDos {

    /**
     * Tomando como base las siguientes estaciones de Transmilenio: Calle 76, Calle 72,
     * Flores, Calle 63, Calle 57, Marly, Calle 45, Av 39, Profamilia y Calle 26. que se
     * encuentran ordenadas respectivamente, es decir, si se dirige de la Calle 76 a la
     * Calle 26 en una ruta que para en cada estación, debe pasar por las demás
     * estaciones enunciadas y viceversa. En este sentido:
     * 
     */
    
    public static void main(String[] args) {
  
        Random random = new Random();

        List<String> estaciones = Arrays.asList("Calle 76", "Calle 72", "Flores", "Calle 63", "Calle 57", 
                                            "Marly", "Calle 45", "Av 39", "Profamilia", "Calle 26");

        List<String> ruta1 = Arrays.asList(estaciones.get(9), estaciones.get(7), estaciones.get(6)); 
        List<String> ruta2 = Arrays.asList(estaciones.get(6), estaciones.get(4), estaciones.get(3)); 
        List<String> ruta3 = Arrays.asList( estaciones.get(9), estaciones.get(8), estaciones.get(7), estaciones.get(6), estaciones.get(5), estaciones.get(4), estaciones.get(3), estaciones.get(2), estaciones.get(1), estaciones.get(0)); 
        List<String> ruta4 = Arrays.asList(estaciones.get(2), estaciones.get(1), estaciones.get(0)); 
        List<String> ruta5 = Arrays.asList(estaciones.get(9), estaciones.get(7), estaciones.get(6), estaciones.get(5), estaciones.get(8)); 
        List<List<String>> rutas = Arrays.asList(ruta1, ruta2, ruta3, ruta4, ruta5);
        short ruta = 6;
        
        do {
            try {
                do{
                    ruta = Short.parseShort(JOptionPane.showInputDialog("""
                                                                                  1. Ruta 1
                                                                                  2. Ruta 2
                                                                                  3. Ruta 3
                                                                                  4. Ruta 4
                                                                                  5. Ruta 5
                                                                                  0. salir del programa
                                                                                  Ingrese su opción: """));                                                              
                }while (ruta < 0 | ruta > 5); 
                
                if (ruta != 0){
                    JOptionPane.showMessageDialog(null, ruta + ". Ruta: " +  String.join(" -> ", rutas.get(ruta - 1)), "Información", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    System.out.println("Saliendo del programa.");
                }
                            
            } catch (Exception e) {
            // Manejo de excepciones y mensajes de error
            System.out.println("Se ha generado un error: " + e.getMessage());
            System.out.println("Se ha generado un error: " + e.getCause());
                }
        } while (ruta != 0 );           
    }
}
        
