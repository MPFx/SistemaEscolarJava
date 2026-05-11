package model;

/**
 * Clase que representa el horario de un curso.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Curso
 */
public class Horario {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del horario. */
    private int idHorario;
    
    /** Dia de la semana. */
    private String dia;
    
    /** Hora de inicio. */
    private String horaInicio;
    
    /** Hora de fin. */
    private String horaFin;
    
    /** Curso asociado. */
    private Curso curso;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un horario.
     * 
     * @param curso Curso
     * @param dia Dia
     * @param horaInicio Hora inicio
     * @param horaFin Hora fin
     */
    public Horario(Curso curso, String dia, String horaInicio, String horaFin) {
        this.idHorario = contadorIds++;
        this.curso = curso;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdHorario() {
        return idHorario;
    }
    
    /** @return Dia */
    public String getDia() {
        return dia;
    }
    
    /** @return Hora inicio */
    public String getHoraInicio() {
        return horaInicio;
    }
    
    /** @return Hora fin */
    public String getHoraFin() {
        return horaFin;
    }
    
    /** @return Curso */
    public Curso getCurso() {
        return curso;
    }
    
    /**
     * Devuelve una representacion textual del horario.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return curso.getMateria().getNombre() + " - " + dia + " " + horaInicio + " - " + horaFin +
               " - Prof. " + curso.getProfesor().getNombre();
    }
    
}//fin de la clase