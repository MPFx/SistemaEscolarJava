package model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un estudiante de la institucion educativa.
 * Hereda de Persona e incluye codigo, grado, año de ingreso y cursos.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Persona
 * @see Grado
 * @see Curso
 */
public class Estudiante extends Persona {
    
    // ==================== ATRIBUTOS ====================
    
    /** Codigo unico del estudiante. */
    private String codigo;
    
    /** Grado en el que cursa. */
    private Grado grado;
    
    /** Año de ingreso a la institucion. */
    private int anioIngreso;
    
    /** Lista de cursos en los que esta matriculado. */
    private List<Curso> cursos;
    
    /**
     * Constructor para crear un estudiante.
     * 
     * @param nombre Nombre completo
     * @param telefono Telefono de contacto
     * @param email Email de contacto
     * @param codigo Codigo del estudiante
     */
    public Estudiante(String nombre, String telefono, String email, String codigo) {
        super(nombre, telefono, email);
        this.codigo = codigo;
        this.grado = Grado.SEXTO;
        this.anioIngreso = java.time.LocalDate.now().getYear();
        this.cursos = new ArrayList<>();
    }
    
    /**
     * Obtiene el tipo de persona.
     * 
     * @return "Estudiante"
     */
    @Override
    public String getTipoPersona() {
        return "Estudiante";
    }
    
    /**
     * Agrega un curso al estudiante.
     * 
     * @param curso Curso a agregar
     */
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }
    
    // ==================== GETTERS ====================
    
    /** @return Codigo del estudiante */
    public String getCodigo() {
        return codigo;
    }
    
    /** @param codigo Nuevo codigo */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /** @return Grado */
    public Grado getGrado() {
        return grado;
    }
    
    /** @param grado Nuevo grado */
    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    /** @return Año de ingreso */
    public int getAnioIngreso() {
        return anioIngreso;
    }
    
    /** @param anioIngreso Nuevo año */
    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }
    
    /** @return Lista de cursos */
    public List<Curso> getCursos() {
        return cursos;
    }
    
    /**
     * Devuelve una representacion textual del estudiante.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - Cod: " + codigo + " - Grado: " + grado +
               " - Ingreso: " + anioIngreso;
    }
    
}//fin de la clase