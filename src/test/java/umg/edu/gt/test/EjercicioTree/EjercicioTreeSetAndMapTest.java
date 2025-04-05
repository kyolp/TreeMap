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
    String rutaArchivo = "palabras.txt";

    Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuencia(rutaArchivo);

    assertEquals(2, resultado.get("hola"));   // OK
    assertEquals(2, resultado.get("mundo"));  // OK
    assertEquals(2, resultado.get("java"));   // OK
}

    @Test
    public void testRastreadorVersiones() {
        EjercicioTreeSetAndMap.agregarVersion("System.out.println(\"Hola Mundo\");");
        EjercicioTreeSetAndMap.agregarVersion("System.out.println(\"Hola Java\");");

        assertEquals("System.out.println(\"Hola Mundo\");", EjercicioTreeSetAndMap.obtenerVersion(1));
        assertEquals("System.out.println(\"Hola Java\");", EjercicioTreeSetAndMap.obtenerUltimaVersion());
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
        assertEquals(2, eventos.size());

        EjercicioTreeSetAndMap.Evento proximo = EjercicioTreeSetAndMap.obtenerProximoEvento();
        assertEquals("Taller de Machine Learning", proximo.getNombre()); // OK
    }

    // 🚨 Test forzado a fallar
    @Test
    public void testFallaFuerzaBruta() {
        assertEquals(999, EjercicioTreeSetAndMap.agregarVersion("Test falso")); // Este fallará intencionalmente
    }
}
