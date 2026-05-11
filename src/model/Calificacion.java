package model;

/**
 * Clase que representa las calificaciones de un estudiante en un curso.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Estudiante
 * @see Curso
 */
public class Calificacion {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la calificacion. */
    private int idCalificacion;
    
    /** Estudiante. */
    private Estudiante estudiante;
    
    /** Curso. */
    private Curso curso;
    
    /** Nota del primer parcial. */
    private double notaParcial1;
    
    /** Nota del segundo parcial. */
    private double notaParcial2;
    
    /** Nota del tercer parcial. */
    private double notaParcial3;
    
    /** Nota final (examen). */
    private double notaFinal;
    
    /** Nota definitiva (promedio final). */
    private double definitiva;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una calificacion.
     * 
     * @param estudiante Estudiante
     * @param curso Curso
     */
    public Calificacion(Estudiante estudiante, Curso curso) {
        this.idCalificacion = contadorIds++;
        this.estudiante = estudiante;
        this.curso = curso;
        this.notaParcial1 = 0;
        this.notaParcial2 = 0;
        this.notaParcial3 = 0;
        this.notaFinal = 0;
        this.definitiva = 0;
    }
    
    /**
     * Registra las notas de los parciales.
     * 
     * @param parcial1 Nota primer parcial
     * @param parcial2 Nota segundo parcial
     * @param parcial3 Nota tercer parcial
     */
    public void registrarNotas(double parcial1, double parcial2, double parcial3) {
        this.notaParcial1 = parcial1;
        this.notaParcial2 = parcial2;
        this.notaParcial3 = parcial3;
        calcularDefinitiva();
    }
    
    /**
     * Registra la nota final (examen).
     * 
     * @param calificacion del del ultimo examen
     */
    public void registrarNotaFinal(double calificacion) {
        this.notaFinal = calificacion;
        calcularDefinitiva();
    }
    
    /**
     * Calcula la nota definitiva.
     * Formula: 70% de los 3 parciales (promedio) + 30% de la nota final
     */
    private void calcularDefinitiva() {
        double promedioParciales = (notaParcial1 + notaParcial2 + notaParcial3) / 3;
        this.definitiva = (promedioParciales * 0.7) + (notaFinal * 0.3);
    }
    
    /**
     * Verifica si el estudiante aprobo (definitiva >= 60).
     * 
     * @return true si aprobo
     */
    public boolean isAprobado() {
        return definitiva >= 60;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador */
    public int getIdCalificacion() {
        return idCalificacion;
    }
    
    /** @return Estudiante */
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    /** @return Curso */
    public Curso getCurso() {
        return curso;
    }
    
    /** @return Nota parcial 1 */
    public double getNotaParcial1() {
        return notaParcial1;
    }
    
    /** @return Nota parcial 2 */
    public double getNotaParcial2() {
        return notaParcial2;
    }
    
    /** @return Nota parcial 3 */
    public double getNotaParcial3() {
        return notaParcial3;
    }
    
    /** @return Nota final */
    public double getNotaFinal() {
        return notaFinal;
    }
    
    /** @return Definitiva */
    public double getDefinitiva() {
        return definitiva;
    }
    
    /**
     * Devuelve una representacion textual de la calificacion.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        String estado = isAprobado() ? "APROBADO" : "REPROBADO";
        return estudiante.getNombre() + " - " + curso.getMateria().getNombre() +
               " - Parciales: " + notaParcial1 + ", " + notaParcial2 + ", " + notaParcial3 +
               " - Final: " + notaFinal + " - Definitiva: " + String.format("%.2f", definitiva) +
               " - " + estado;
    }
    
}//fin de la clase