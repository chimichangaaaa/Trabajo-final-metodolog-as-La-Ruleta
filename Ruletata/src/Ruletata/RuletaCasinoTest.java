package Ruletata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RuletaCasinoTest {
    private RuletaCasino ruleta;

    @BeforeEach
    public void setUp() {
        ruleta = new RuletaCasino();
    }

    @Test
    public void testAgregarJugador() {
        Jugador jugador = new Jugador("Juan", 100);
        ruleta.agregarJugador(jugador);

        List<Jugador> jugadores = ruleta.getJugadores();
        Assertions.assertEquals(1, jugadores.size());
        Assertions.assertTrue(jugadores.contains(jugador));
    }

    @Test
    public void testJugarRonda() {
        Jugador jugador1 = new Jugador("Juan", 100);
        Jugador jugador2 = new Jugador("María", 200);
        ruleta.agregarJugador(jugador1);
        ruleta.agregarJugador(jugador2);

        // Configurar el número ganador para las pruebas
        ruleta.setNumeroGanador(10);

        // Simular las apuestas de los jugadores
        jugador1.realizarApuesta(50, List.of("10", "20"));
        jugador2.realizarApuesta(100, List.of("rojo"));

        ruleta.jugarRonda();

        // Verificar los resultados
        Assertions.assertEquals(90, jugador1.getDinero());
        Assertions.assertEquals(210, jugador2.getDinero());
    }

   
    @Test
    public void testObtenerPremio() {
        Jugador jugador = new Jugador("Juan", 100);
        ruleta.agregarJugador(jugador);

        // Caso de prueba: sin apuestas realizadas
        Assertions.assertEquals(0, jugador.obtenerPremio());

        // Caso de prueba: una apuesta a un número
        jugador.realizarApuesta(50, List.of("10"));
        Assertions.assertEquals(10, jugador.obtenerPremio());

        // Caso de prueba: una apuesta a un color
        jugador.realizarApuesta(50, List.of("rojo"));
        Assertions.assertEquals(10, jugador.obtenerPremio());

        // Caso de prueba: múltiples apuestas a números
        jugador.realizarApuesta(50, List.of("10", "20", "30"));
        Assertions.assertEquals(30, jugador.obtenerPremio());
    }
}
