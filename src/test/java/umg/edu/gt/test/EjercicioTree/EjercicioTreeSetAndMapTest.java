package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EjercicioTreeSetAndMapTest {

@Test
public void testFrequenciaPalabras() throws IOException {
    String rutaArchivo = "C:/Users/David/Documents/NetBeansProjects/EstructuraDeDatos2025/palabras.txt";
    Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuencia(rutaArchivo);

    System.out.println("=== Frecuencia de Palabras ===");
    for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    assertEquals(2, resultado.get("hola"));
    assertEquals(2, resultado.get("mundo"));
    assertEquals(2, resultado.get("java"));
}

@Test
public void testRastreadorVersiones() {
    int v1 = EjercicioTreeSetAndMap.agregarVersion("System.out.println('Hola Mundo');");
    int v2 = EjercicioTreeSetAndMap.agregarVersion("System.out.println('Hola Java');");

    String ultima = EjercicioTreeSetAndMap.obtenerUltimaVersion();
    String primera = EjercicioTreeSetAndMap.obtenerVersion(1);

    System.out.println("Agregar version " + v1 + ": " + EjercicioTreeSetAndMap.obtenerVersion(v1));
    System.out.println("Agregar version " + v2 + ": " + EjercicioTreeSetAndMap.obtenerVersion(v2));
    System.out.println("Ultima version: " + ultima);
    System.out.println("Version 1: " + primera);

    assertEquals("System.out.println('Hola Mundo');", primera);
    assertEquals("System.out.println('Hola Java');", ultima);
}
 

@Test
public void testEventosOrdenCronologico() {
    EjercicioTreeSetAndMap.agregarEvento(
        new EjercicioTreeSetAndMap.Evento(LocalDateTime.of(2025, 5, 10, 10, 0),
            "Conferencia de Java", "Auditorio A")
    );
    EjercicioTreeSetAndMap.agregarEvento(
        new EjercicioTreeSetAndMap.Evento(LocalDateTime.of(2025, 4, 15, 14, 0),
            "Taller de Machine Learning", "Sala 3")
    );

    var eventos = EjercicioTreeSetAndMap.obtenerEventos();
    EjercicioTreeSetAndMap.Evento proximo = EjercicioTreeSetAndMap.obtenerProximoEvento();

    System.out.println("Proximo evento: " + proximo);

    System.out.println("Lista de eventos:");
    int i = 1;
    for (EjercicioTreeSetAndMap.Evento e : eventos) {
        System.out.println(i++ + ". " + e);
    }

    assertEquals("Taller de Machine Learning", proximo.getNombre());
}


    // 🚨 Test forzado a fallar
    @Test
    public void testFallaFuerzaBruta() {
        assertEquals(999, EjercicioTreeSetAndMap.agregarVersion("Test falso")); // Este fallará intencionalmente
    }
    
    
}





            
            
