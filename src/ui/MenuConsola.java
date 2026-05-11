package ui;

import service.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de usuario por consola para el Sistema Escolar.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class MenuConsola {
    
    private Scanner scanner;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Materia> materias;
    private List<Curso> cursos;
    private List<Horario> horarios;
    private List<Calificacion> calificaciones;
    private EscuelaService escuelaService;
    private CalificacionService calificacionService;
    private Estudiante estudianteActual;
    private Curso cursoActual;
    
    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.escuelaService = new EscuelaService(estudiantes, profesores, materias, cursos, horarios);
        this.calificacionService = new CalificacionService(calificaciones);
        this.estudianteActual = null;
        this.cursoActual = null;
        cargarDatosPrueba();
    }
    
    private void cargarDatosPrueba() {
        // Materias
        Materia mat1 = new Materia("Matematicas", "MAT101", 4);
        mat1.setIntensidadHoraria(5);
        Materia mat2 = new Materia("Español", "ESP101", 4);
        mat2.setIntensidadHoraria(4);
        Materia mat3 = new Materia("Ingles", "ING101", 3);
        mat3.setIntensidadHoraria(3);
        materias.add(mat1);
        materias.add(mat2);
        materias.add(mat3);
        
        // Estudiantes
        Estudiante est1 = new Estudiante("Juan Perez", "555-1234", "juan@email.com", "2024001");
        est1.setGrado(Grado.DECIMO);
        Estudiante est2 = new Estudiante("Maria Gomez", "555-5678", "maria@email.com", "2024002");
        est2.setGrado(Grado.DECIMO);
        estudiantes.add(est1);
        estudiantes.add(est2);
        
        // Profesores
        Profesor prof1 = new Profesor("Carlos Lopez", "555-9012", "carlos@email.com");
        prof1.setEspecialidad("Matematicas");
        prof1.setTitulo("Lic. Matematicas");
        prof1.setAnosExperiencia(10);
        profesores.add(prof1);
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> escuelaService.registrarEstudiante(scanner);
                case 2 -> escuelaService.registrarProfesor(scanner);
                case 3 -> escuelaService.registrarMateria(scanner);
                case 4 -> escuelaService.crearCurso(scanner);
                case 5 -> escuelaService.matricularEstudiante(scanner);
                case 6 -> escuelaService.crearHorario(scanner);
                case 7 -> escuelaService.listarEstudiantes();
                case 8 -> escuelaService.listarProfesores();
                case 9 -> escuelaService.listarMaterias();
                case 10 -> escuelaService.listarCursos();
                case 11 -> escuelaService.listarHorarios();
                case 12 -> estudianteActual = escuelaService.seleccionarEstudiante(scanner);
                case 13 -> cursoActual = escuelaService.seleccionarCurso(scanner);
                case 14 -> calificacionService.registrarCalificaciones(scanner, estudianteActual, cursoActual);
                case 15 -> calificacionService.verCalificacionesEstudiante(estudianteActual);
                case 16 -> calificacionService.verCalificacionesCurso(cursoActual);
                case 17 -> {
                    System.out.println("\n¡Gracias por usar el Sistema Escolar!");
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
            
            if (!salir) pausa();
        }
        scanner.close();
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA ESCOLAR");
        System.out.println("========================================");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Registrar profesor");
        System.out.println("3. Registrar materia");
        System.out.println("4. Crear curso");
        System.out.println("5. Matricular estudiante en curso");
        System.out.println("6. Crear horario");
        System.out.println("7. Listar estudiantes");
        System.out.println("8. Listar profesores");
        System.out.println("9. Listar materias");
        System.out.println("10. Listar cursos");
        System.out.println("11. Listar horarios");
        System.out.println("12. Seleccionar estudiante");
        System.out.println("13. Seleccionar curso");
        System.out.println("14. Registrar calificaciones");
        System.out.println("15. Ver calificaciones de estudiante");
        System.out.println("16. Ver calificaciones de curso");
        System.out.println("17. Salir");
        System.out.println("========================================");
        
        if (estudianteActual != null) {
            System.out.println("Estudiante actual: " + estudianteActual.getNombre());
        } else {
            System.out.println("Estudiante actual: NINGUNO");
        }
        if (cursoActual != null) {
            System.out.println("Curso actual: " + cursoActual.getMateria().getNombre());
        }
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
}//fin de la clase