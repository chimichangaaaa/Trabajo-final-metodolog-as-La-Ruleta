// Crear una clase Jugador para almacenar la información de cada jugador
class Jugador {
    constructor(nombre) {
      this.nombre = nombre;
      this.puntuacion = 0;
    }
    
    // Método para incrementar la puntuación del jugador
    incrementarPuntuacion(puntos) {
      this.puntuacion += puntos;
    }
  }
  
  // Crear un array de jugadores
  const jugadores = [];
  
  // Función para crear un nuevo jugador
  function crearJugador() {
    const nombre = prompt("Ingrese el nombre del jugador:");
    const jugador = new Jugador(nombre);
    jugadores.push(jugador);
  }
  
  // Función para mostrar la tabla de puntuación
  function mostrarTablaPuntuacion() {
    console.log("Tabla de Puntuación");
    console.log("-------------------");
    
    jugadores.forEach((jugador, indice) => {
      console.log(`Jugador ${indice + 1}: ${jugador.nombre} - Puntuación: ${jugador.puntuacion}`);
    });
    
    console.log("-------------------");
  }
  
  // Ejemplo de uso:
  crearJugador();
  crearJugador();
  crearJugador();
  crearJugador();
  
  // Incrementar la puntuación de los jugadores (solo como ejemplo)
  jugadores[0].incrementarPuntuacion(10);
  jugadores[1].incrementarPuntuacion(5);
  jugadores[2].incrementarPuntuacion(8);
  jugadores[3].incrementarPuntuacion(12);
  
  // Mostrar la tabla de puntuación
  mostrarTablaPuntuacion();
  