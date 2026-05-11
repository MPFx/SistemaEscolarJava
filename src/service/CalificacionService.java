package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las calificaciones.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class CalificacionService {
    
    private List<Calificacion> calificaciones;
    
    public CalificacionService(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public void registrarCalificaciones(Scanner scanner, Estudiante estudiante, Curso curso) {
        if (estudiante == null) {
            System.out.println("Primero seleccione un estudiante");
            return;
        }
        if (curso == null) {
            System.out.println("Primero seleccione un curso");
            return;
        }
        
        // Verificar si ya existe calificacion
        Calificacion calificacion = calificaciones.stream()
                .filter(c -> c.getEstudiante().getIdPersona() == estudiante.getIdPersona() &&
                            c.getCurso().getIdCurso() == curso.getIdCurso())
                .findFirst().orElse(null);
        
        if (calificacion == null) {
            calificacion = new Calificacion(estudiante, curso);
            calificaciones.add(calificacion);
            curso.agregarCalificacion(calificacion);
        }
        
        System.out.println("\n=== REGISTRAR CALIFICACIONES ===");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Curso: " + curso.getMateria().getNombre());
        
        System.out.print("Nota parcial 1: ");
        double p1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nota parcial 2: ");
        double p2 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nota parcial 3: ");
        double p3 = Double.parseDouble(scanner.nextLine());
        calificacion.registrarNotas(p1, p2, p3);
        
        System.out.print("Nota final (examen): ");
        double notaFinal = Double.parseDouble(scanner.nextLine());
        calificacion.registrarNotaFinal(notaFinal);
        
        System.out.println("✅ Calificaciones registradas");
        System.out.println("Definitiva: " + String.format("%.2f", calificacion.getDefinitiva()));
        System.out.println(calificacion.isAprobado() ? "🎉 APROBADO 🎉" : "📚 REPROBADO 📚");
    }
    
    public void verCalificacionesEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            System.out.println("Primero seleccione un estudiante");
            return;
        }
        
        System.out.println("\n=== CALIFICACIONES DE " + estudiante.getNombre().toUpperCase() + " ===");
        List<Calificacion> califs = calificaciones.stream()
                .filter(c -> c.getEstudiante().getIdPersona() == estudiante.getIdPersona())
                .toList();
        
        if (califs.isEmpty()) {
            System.out.println("No hay calificaciones registradas para este estudiante");
            return;
        }
        
        double promedioGeneral = 0;
        for (Calificacion c : califs) {
            System.out.println(c);
            promedioGeneral += c.getDefinitiva();
        }
        promedioGeneral /= califs.size();
        System.out.println("\n📊 PROMEDIO GENERAL: " + String.format("%.2f", promedioGeneral));
    }
    
    public void verCalificacionesCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Primero seleccione un curso");
            return;
        }
        
        System.out.println("\n=== CALIFICACIONES DEL CURSO: " + curso.getMateria().getNombre().toUpperCase() + " ===");
        List<Calificacion> califs = calificaciones.stream()
                .filter(c -> c.getCurso().getIdCurso() == curso.getIdCurso())
                .toList();
        
        if (califs.isEmpty()) {
            System.out.println("No hay calificaciones registradas para este curso");
            return;
        }
        
        int aprobados = 0;
        for (Calificacion c : califs) {
            System.out.println(c);
            if (c.isAprobado()) aprobados++;
        }
        System.out.println("\n📊 ESTADISTICAS:");
        System.out.println("Total estudiantes: " + califs.size());
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + (califs.size() - aprobados));
        System.out.println("Porcentaje aprobacion: " + String.format("%.1f", (aprobados * 100.0 / califs.size())) + "%");
    }
    
    // Nota: El método registrarNotasFinal debe agregarse en Calificacion.java
    // por ahora usamos el método existente
    
}//fin de la clase