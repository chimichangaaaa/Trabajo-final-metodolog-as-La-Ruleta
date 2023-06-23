package Ruletata;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RuletaCasinoTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testJugarRonda() {
        // Configuración del escenario de prueba
        String input = "1\n" +           // Número de jugadores
                       "John\n" +        // Nombre del jugador
                       "100\n" +         // Cantidad inicial de fichas del jugador
                       "s\n";            // Respuesta de continuar jugando

        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        RuletaCasino ruleta = new RuletaCasino();
        ruleta.jugarRonda();

        // Verificación de la salida esperada
        String output = testOut.toString();
        List<String> expectedOutput = Arrays.asList(
                "Comienza una nueva ronda...",
                "El número ganador es: 0",
                "",
                "John ha perdido su apuesta.",
                "John ha sido eliminado.",
                "",
                "Tabla de Clasificación",
                "---------------------",
                "",
                "¡John ha ganado el juego!",
                ""
        );

        }
    

    @Test
    public void testMostrarTablaClasificacion() {
        // Configuración del escenario de prueba
        Jugador jugador1 = new Jugador("John", 100);
        Jugador jugador2 = new Jugador("Jane", 200);
        RuletaCasino ruleta = new RuletaCasino();
        ruleta.agregarJugador(jugador1);
        ruleta.agregarJugador(jugador2);

        // Capturar la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Llamar al método a probar
        ruleta.mostrarTablaClasificacion();

     
    }

}
