package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las operaciones generales de la institucion educativa.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class EscuelaService {
    
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Materia> materias;
    private List<Curso> cursos;
    private List<Horario> horarios;
    
    public EscuelaService(List<Estudiante> estudiantes, List<Profesor> profesores,
                          List<Materia> materias, List<Curso> cursos, List<Horario> horarios) {
        this.estudiantes = estudiantes;
        this.profesores = profesores;
        this.materias = materias;
        this.cursos = cursos;
        this.horarios = horarios;
    }
    
    public void registrarEstudiante(Scanner scanner) {
        System.out.println("\n=== REGISTRAR ESTUDIANTE ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        
        Estudiante estudiante = new Estudiante(nombre, telefono, email, codigo);
        
        System.out.println("Grados: SEXTO, SEPTIMO, OCTAVO, NOVENO, DECIMO, ONCE");
        System.out.print("Grado: ");
        estudiante.setGrado(Grado.valueOf(scanner.nextLine().toUpperCase()));
        
        estudiantes.add(estudiante);
        System.out.println("✅ Estudiante registrado: " + estudiante.getNombre());
    }
    
    public void registrarProfesor(Scanner scanner) {
        System.out.println("\n=== REGISTRAR PROFESOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Profesor profesor = new Profesor(nombre, telefono, email);
        System.out.print("Especialidad: ");
        profesor.setEspecialidad(scanner.nextLine());
        System.out.print("Titulo: ");
        profesor.setTitulo(scanner.nextLine());
        System.out.print("Años de experiencia: ");
        profesor.setAnosExperiencia(Integer.parseInt(scanner.nextLine()));
        
        profesores.add(profesor);
        System.out.println("✅ Profesor registrado: " + profesor.getNombre());
    }
    
    public void registrarMateria(Scanner scanner) {
        System.out.println("\n=== REGISTRAR MATERIA ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Creditos: ");
        int creditos = Integer.parseInt(scanner.nextLine());
        
        Materia materia = new Materia(nombre, codigo, creditos);
        System.out.print("Intensidad horaria (horas/semana): ");
        materia.setIntensidadHoraria(Integer.parseInt(scanner.nextLine()));
        
        materias.add(materia);
        System.out.println("✅ Materia registrada: " + materia.getNombre());
    }
    
    public void crearCurso(Scanner scanner) {
        System.out.println("\n=== CREAR CURSO ===");
        
        // Seleccionar materia
        System.out.println("Materias disponibles:");
        for (Materia m : materias) {
            System.out.println(m.getIdMateria() + ". " + m.getNombre());
        }
        System.out.print("ID materia: ");
        int idMateria = Integer.parseInt(scanner.nextLine());
        Materia materia = materias.stream().filter(m -> m.getIdMateria() == idMateria).findFirst().orElse(null);
        if (materia == null) {
            System.out.println("Materia no encontrada");
            return;
        }
        
        // Seleccionar profesor
        System.out.println("\nProfesores disponibles:");
        for (Profesor p : profesores) {
            System.out.println(p.getIdPersona() + ". " + p.getNombre());
        }
        System.out.print("ID profesor: ");
        int idProfesor = Integer.parseInt(scanner.nextLine());
        Profesor profesor = profesores.stream().filter(p -> p.getIdPersona() == idProfesor).findFirst().orElse(null);
        if (profesor == null) {
            System.out.println("Profesor no encontrado");
            return;
        }
        
        System.out.print("Año: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Periodo (1,2,3,4): ");
        String periodo = scanner.nextLine();
        
        Curso curso = new Curso(materia, profesor, anio, periodo);
        cursos.add(curso);
        profesor.agregarCurso(curso);
        
        System.out.println("✅ Curso creado: " + curso);
    }
    
    public void matricularEstudiante(Scanner scanner) {
        System.out.println("\n=== MATRICULAR ESTUDIANTE EN CURSO ===");
        
        // Seleccionar estudiante
        System.out.println("Estudiantes disponibles:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getIdPersona() + ". " + e.getNombre() + " (" + e.getCodigo() + ")");
        }
        System.out.print("ID estudiante: ");
        int idEstudiante = Integer.parseInt(scanner.nextLine());
        Estudiante estudiante = estudiantes.stream().filter(e -> e.getIdPersona() == idEstudiante).findFirst().orElse(null);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado");
            return;
        }
        
        // Seleccionar curso
        System.out.println("\nCursos disponibles:");
        for (Curso c : cursos) {
            System.out.println(c.getIdCurso() + ". " + c.getMateria().getNombre() + " - " + c.getProfesor().getNombre());
        }
        System.out.print("ID curso: ");
        int idCurso = Integer.parseInt(scanner.nextLine());
        Curso curso = cursos.stream().filter(c -> c.getIdCurso() == idCurso).findFirst().orElse(null);
        if (curso == null) {
            System.out.println("Curso no encontrado");
            return;
        }
        
        curso.agregarEstudiante(estudiante);
        System.out.println("✅ Estudiante matriculado en " + curso.getMateria().getNombre());
    }
    
    public void crearHorario(Scanner scanner) {
        System.out.println("\n=== CREAR HORARIO ===");
        
        // Seleccionar curso
        System.out.println("Cursos disponibles:");
        for (Curso c : cursos) {
            System.out.println(c.getIdCurso() + ". " + c.getMateria().getNombre());
        }
        System.out.print("ID curso: ");
        int idCurso = Integer.parseInt(scanner.nextLine());
        Curso curso = cursos.stream().filter(c -> c.getIdCurso() == idCurso).findFirst().orElse(null);
        if (curso == null) {
            System.out.println("Curso no encontrado");
            return;
        }
        
        System.out.print("Dia (LUNES, MARTES, MIERCOLES, JUEVES, VIERNES): ");
        String dia = scanner.nextLine();
        System.out.print("Hora inicio (HH:MM): ");
        String horaInicio = scanner.nextLine();
        System.out.print("Hora fin (HH:MM): ");
        String horaFin = scanner.nextLine();
        
        Horario horario = new Horario(curso, dia, horaInicio, horaFin);
        horarios.add(horario);
        System.out.println("✅ Horario creado");
    }
    
    public void listarEstudiantes() {
        System.out.println("\n=== LISTA DE ESTUDIANTES ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
    
    public void listarProfesores() {
        System.out.println("\n=== LISTA DE PROFESORES ===");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados");
            return;
        }
        for (Profesor p : profesores) {
            System.out.println(p);
        }
    }
    
    public void listarMaterias() {
        System.out.println("\n=== LISTA DE MATERIAS ===");
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas");
            return;
        }
        for (Materia m : materias) {
            System.out.println(m);
        }
    }
    
    public void listarCursos() {
        System.out.println("\n=== LISTA DE CURSOS ===");
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos creados");
            return;
        }
        for (Curso c : cursos) {
            System.out.println(c);
        }
    }
    
    public void listarHorarios() {
        System.out.println("\n=== LISTA DE HORARIOS ===");
        if (horarios.isEmpty()) {
            System.out.println("No hay horarios registrados");
            return;
        }
        for (Horario h : horarios) {
            System.out.println(h);
        }
    }
    
    public Estudiante seleccionarEstudiante(Scanner scanner) {
        System.out.print("ID del estudiante: ");
        int id = Integer.parseInt(scanner.nextLine());
        Estudiante estudiante = estudiantes.stream().filter(e -> e.getIdPersona() == id).findFirst().orElse(null);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado");
        }
        return estudiante;
    }
    
    public Curso seleccionarCurso(Scanner scanner) {
        System.out.print("ID del curso: ");
        int id = Integer.parseInt(scanner.nextLine());
        Curso curso = cursos.stream().filter(c -> c.getIdCurso() == id).findFirst().orElse(null);
        if (curso == null) {
            System.out.println("Curso no encontrado");
        }
        return curso;
    }
    
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public List<Materia> getMaterias() {
        return materias;
    }
    
}//fin de la clase