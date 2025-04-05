package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class EjercicioTreeSetAndMap {

    // EJERCICIO 1
    public static Map<String, Integer> contarFrecuencia(String rutaArchivo) throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo))).toLowerCase();
        contenido = contenido.replaceAll("[^a-záéíóúñü\\s]", ""); // limpiar puntuación
        String[] palabras = contenido.split("\\s+");

        TreeMap<String, Integer> mapa = new TreeMap<>();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                mapa.put(palabra, mapa.getOrDefault(palabra, 0) + 1);
            }
        }
        return mapa;
    }

    // EJERCICIO 2
    private static TreeMap<Integer, String> versiones = new TreeMap<>();
    private static int contador = 0;

    public static int agregarVersion(String contenido) {
        versiones.put(++contador, contenido);
        return contador;
    }

    public static String obtenerVersion(int version) {
        return versiones.get(version);
    }

    public static String obtenerUltimaVersion() {
        return versiones.isEmpty() ? null : versiones.lastEntry().getValue();
    }

    public static void eliminarVersion(int version) {
        versiones.remove(version);
    }

    // EJERCICIO 3
    public static class Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }

        @Override
        public String toString() {
            return "\"" + nombre + "\", " + fecha.toString().replace("T", " ") + ", " + ubicacion;
        }
    }

    private static TreeSet<Evento> eventos = new TreeSet<>();

    public static void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public static List<Evento> obtenerEventos() {
        eventos.removeIf(e -> e.getFecha().isBefore(LocalDateTime.now()));
        return new ArrayList<>(eventos);
    }

    public static Evento obtenerProximoEvento() {
        eventos.removeIf(e -> e.getFecha().isBefore(LocalDateTime.now()));
        return eventos.isEmpty() ? null : eventos.first();
    }
}
