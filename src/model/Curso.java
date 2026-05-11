package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un curso (materia dictada en un periodo especifico).
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Materia
 * @see Profesor
 * @see Estudiante
 * @see Calificacion
 */
public class Curso {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del curso. */
    private int idCurso;
    
    /** Materia del curso. */
    private Materia materia;
    
    /** Profesor que dicta el curso. */
    private Profesor profesor;
    
    /** Año del curso. */
    private int anio;
    
    /** Periodo academico (1, 2, 3, 4). */
    private String periodo;
    
    /** Lista de estudiantes matriculados. */
    private List<Estudiante> estudiantes;
    
    /** Lista de calificaciones del curso. */
    private List<Calificacion> calificaciones;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un curso.
     * 
     * @param materia Materia
     * @param profesor Profesor
     * @param anio Año
     * @param periodo Periodo
     */
    public Curso(Materia materia, Profesor profesor, int anio, String periodo) {
        this.idCurso = contadorIds++;
        this.materia = materia;
        this.profesor = profesor;
        this.anio = anio;
        this.periodo = periodo;
        this.estudiantes = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }
    
    /**
     * Agrega un estudiante al curso.
     * 
     * @param estudiante Estudiante a agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            estudiante.agregarCurso(this);
        }
    }
    
    /**
     * Agrega una calificacion al curso.
     * 
     * @param calificacion Calificacion a agregar
     */
    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdCurso() {
        return idCurso;
    }
    
    /** @return Materia */
    public Materia getMateria() {
        return materia;
    }
    
    /** @return Profesor */
    public Profesor getProfesor() {
        return profesor;
    }
    
    /** @return Año */
    public int getAnio() {
        return anio;
    }
    
    /** @return Periodo */
    public String getPeriodo() {
        return periodo;
    }
    
    /** @return Lista de estudiantes */
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    /** @return Lista de calificaciones */
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    
    /**
     * Devuelve una representacion textual del curso.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "Curso #" + idCurso + " - " + materia.getNombre() + " - " + profesor.getNombre() +
               " - " + anio + " - Periodo " + periodo + " - " + estudiantes.size() + " estudiantes";
    }
    
}//fin de la clase