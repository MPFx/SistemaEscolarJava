package principal;

import ui.MenuConsola;

/**
 * Clase principal del Sistema Escolar.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BIENVENIDO AL SISTEMA ESCOLAR");
        System.out.println("========================================");
        System.out.println("Gestiona estudiantes, profesores, materias,");
        System.out.println("cursos, horarios y calificaciones.");
        System.out.println("========================================\n");
        
        MenuConsola menu = new MenuConsola();
        menu.iniciar();
    }
    
}//fin de la clase