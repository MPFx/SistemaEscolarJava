package model;

/**
 * Clase que representa una materia academica.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Curso
 */
public class Materia {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la materia. */
    private int idMateria;
    
    /** Nombre de la materia. */
    private String nombre;
    
    /** Codigo de la materia. */
    private String codigo;
    
    /** Numero de creditos. */
    private int creditos;
    
    /** Intensidad horaria semanal en horas. */
    private int intensidadHoraria;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una materia.
     * 
     * @param nombre Nombre de la materia
     * @param codigo Codigo de la materia
     * @param creditos Creditos
     */
    public Materia(String nombre, String codigo, int creditos) {
        this.idMateria = contadorIds++;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.intensidadHoraria = 4;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdMateria() {
        return idMateria;
    }
    
    /** @return Nombre */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return Codigo */
    public String getCodigo() {
        return codigo;
    }
    
    /** @param codigo Nuevo codigo */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /** @return Creditos */
    public int getCreditos() {
        return creditos;
    }
    
    /** @param creditos Nuevos creditos */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    /** @return Intensidad horaria */
    public int getIntensidadHoraria() {
        return intensidadHoraria;
    }
    
    /** @param intensidadHoraria Nueva intensidad */
    public void setIntensidadHoraria(int intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }
    
    /**
     * Devuelve una representacion textual de la materia.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "[" + idMateria + "] " + nombre + " (" + codigo + ") - " + creditos + " creditos - " + intensidadHoraria + "h/semana";
    }
    
}//fin de la clase