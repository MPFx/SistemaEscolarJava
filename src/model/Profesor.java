package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un profesor de la institucion educativa.
 * Hereda de Persona e incluye especialidad, titulo, años de experiencia y cursos.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Persona
 * @see Curso
 */
public class Profesor extends Persona {
    
    // ==================== ATRIBUTOS ====================
    
    /** Especialidad del profesor. */
    private String especialidad;
    
    /** Titulo academico. */
    private String titulo;
    
    /** Años de experiencia. */
    private int anosExperiencia;
    
    /** Lista de cursos que dicta. */
    private List<Curso> cursos;
    
    /**
     * Constructor para crear un profesor.
     * 
     * @param nombre Nombre completo
     * @param telefono Telefono de contacto
     * @param email Email de contacto
     */
    public Profesor(String nombre, String telefono, String email) {
        super(nombre, telefono, email);
        this.cursos = new ArrayList<>();
        this.especialidad = "";
        this.titulo = "";
        this.anosExperiencia = 0;
    }
    
    /**
     * Obtiene el tipo de persona.
     * 
     * @return "Profesor"
     */
    @Override
    public String getTipoPersona() {
        return "Profesor";
    }
    
    /**
     * Agrega un curso al profesor.
     * 
     * @param curso Curso a agregar
     */
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }
    
    // ==================== GETTERS ====================
    
    /** @return Especialidad */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /** @param especialidad Nueva especialidad */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /** @return Titulo */
    public String getTitulo() {
        return titulo;
    }
    
    /** @param titulo Nuevo titulo */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /** @return Años de experiencia */
    public int getAnosExperiencia() {
        return anosExperiencia;
    }
    
    /** @param anosExperiencia Nuevos años */
    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
    
    /** @return Lista de cursos */
    public List<Curso> getCursos() {
        return cursos;
    }
    
    /**
     * Devuelve una representacion textual del profesor.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + especialidad + " - " + titulo +
               " - " + anosExperiencia + " años de experiencia";
    }
    
}//fin de la clase