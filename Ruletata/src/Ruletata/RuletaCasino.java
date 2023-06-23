package Ruletata;

import java.util.*;

public class RuletaCasino {
    private List<Jugador> jugadores;
    private int numeroGanador;
    private Random random;

    public RuletaCasino() {
        jugadores = new ArrayList<>();
        random = new Random();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void jugarRonda() {
        System.out.println("Comienza una nueva ronda...");
        numeroGanador = random.nextInt(37); // Genera un número aleatorio entre 0 y 36

        for (Jugador jugador : jugadores) {
            int fichasApostadas = obtenerFichasApostadas(jugador);
            List<String> casillasApostadas = obtenerCasillasApostadas(jugador);

            jugador.realizarApuesta(fichasApostadas, casillasApostadas);
        }

        System.out.println("El número ganador es: " + numeroGanador);
        System.out.println();

        for (Jugador jugador : jugadores) {
            if (jugador.tieneApuestaGanadora(numeroGanador)) {
                int premio = jugador.obtenerPremio();
                jugador.incrementarDinero(premio);
                System.out.println(jugador.getNombre() + " ha ganado " + premio + " fichas.");
            } else {
                System.out.println(jugador.getNombre() + " ha perdido su apuesta.");
                if (jugador.getDinero() <= 0) {
                    System.out.println(jugador.getNombre() + " ha sido eliminado.");
                    jugadores.remove(jugador);
                }
            }

            jugador.reiniciarApuesta();
        }

        System.out.println();
    }

    private int obtenerFichasApostadas(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(jugador.getNombre() + ", ingrese la cantidad de fichas a apostar: ");
        return scanner.nextInt();
    }

    private List<String> obtenerCasillasApostadas(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        List<String> casillasApostadas = new ArrayList<>();

        System.out.print(jugador.getNombre() + ", ¿desea apostar a numeros o colores? (numeros/colores): ");
        String opcion = scanner.next();

        if (opcion.equalsIgnoreCase("numeros")) {
            System.out.print("Ingrese la cantidad de números a apostar: ");
            int cantidadNumeros = scanner.nextInt();

            for (int i = 0; i < cantidadNumeros; i++) {
                System.out.print("Ingrese el número " + (i + 1) + ": ");
                casillasApostadas.add(scanner.next());
            }
        } else if (opcion.equalsIgnoreCase("colores")) {
            System.out.print("Ingrese el color al que desea apostar (rojo/negro): ");
            casillasApostadas.add(scanner.next());
        }

        return casillasApostadas;
    }

    public void mostrarTablaClasificacion() {
        System.out.println("Tabla de Clasificación");
        System.out.println("---------------------");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getDinero() + " fichas");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de jugadores (1-4): ");
        int numJugadores = scanner.nextInt();

        RuletaCasino ruleta = new RuletaCasino();

        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.next();

            System.out.print("Ingrese la cantidad inicial de fichas del jugador " + (i + 1) + ": ");
            int fichasIniciales = scanner.nextInt();
            Jugador jugador = new Jugador(nombre, fichasIniciales);
            ruleta.agregarJugador(jugador);
        }

        boolean jugar = true;
        while (jugar) {
            ruleta.jugarRonda();
            ruleta.mostrarTablaClasificacion();

            boolean continuar = false;
            for (Jugador jugador : ruleta.jugadores) {
                if (jugador.getDinero() > 0) {
                    System.out.print(jugador.getNombre() + ", ¿desea continuar jugando? (s/n): ");
                    String opcion = scanner.next();
                    if (opcion.equalsIgnoreCase("s")) {
                        continuar = true;
                    }
                }
            }

            if (!continuar || ruleta.jugadores.size() == 1) {
                jugar = false;
                if (ruleta.jugadores.size() == 1) {
                    System.out.println("¡" + ruleta.jugadores.get(0).getNombre() + " ha ganado el juego!");
                }
            }
        }
    }
}

class Jugador {
    private String nombre;
    private int dinero;
    private List<String> casillasApostadas;

    public Jugador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void incrementarDinero(int cantidad) {
        dinero += cantidad;
    }

    public void realizarApuesta(int fichasApostadas, List<String> casillasApostadas) {
        dinero -= fichasApostadas;
        this.casillasApostadas = casillasApostadas;
    }

    public void reiniciarApuesta() {
        casillasApostadas = null;
    }

    public boolean tieneApuestaGanadora(int numeroGanador) {
        if (casillasApostadas == null || casillasApostadas.isEmpty()) {
            return false;
        }

        if (casillasApostadas.size() == 1) {
            String apuesta = casillasApostadas.get(0);
            if (apuesta.equalsIgnoreCase("rojo")) {
                return numeroGanador % 2 != 0 && numeroGanador != 0;
            } else if (apuesta.equalsIgnoreCase("negro")) {
                return numeroGanador % 2 == 0 && numeroGanador != 0;
            } else {
                int numeroApostado = Integer.parseInt(apuesta);
                return numeroApostado == numeroGanador;
            }
        }

        for (String casilla : casillasApostadas) {
            if (casilla.equalsIgnoreCase(String.valueOf(numeroGanador))) {
                return true;
            }
        }

        return false;
    }

    public int obtenerPremio() {
        if (casillasApostadas == null || casillasApostadas.isEmpty()) {
            return 0;
        }

        return casillasApostadas.size() * 10; // Cada casilla acertada tiene un premio de 10 fichas
    }
}
