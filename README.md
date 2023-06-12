# Trabajo-final-metodologias-La-Ruleta

Este es el trabajo de fin de curso de la asignatura Metodologias de la Programacion de la universidad UNIE.
Participantes:Álvaro Hernandez(thealvarox7), Adrián Tamargo (FalquitoPit) y Pablo Martínez (chimichangaaaa)

Descripcion del proyecto:

El proyecto consiste en el desarrollo de un código en Java para simular una ruleta virtual en el contexto de un casino en línea. El objetivo principal es brindar una experiencia interactiva y realista a los usuarios, replicando las reglas y mecánicas de una ruleta tradicional.

Características clave del proyecto:

Interfaz gráfica de usuario: Se ha implementado una interfaz gráfica intuitiva y atractiva que permite a los usuarios interactuar fácilmente con la ruleta. La interfaz muestra , los jugadores en juego,las casillas numeradas y las apuestas de cada jugador.

Generación de números aleatorios: Utilizando las capacidades de generación de números aleatorios en Java, se generan resultados aleatorios para simular el giro de la rueda de la ruleta. Estos resultados son utilizados para determinar el número, a que tercio pertenece y el color ganador.

Opciones de apuesta: El código permite a los jugadores realizar diferentes tipos de apuestas, como apuestas a números individuales, apuestas a grupos de números, apuestas a colores, entre otras. Se implementarán las reglas de pago correspondientes que se explican en el word adjunto a cada tipo de apuesta.

Control de apuestas: Se ha desarrollado un sistema para gestionar las apuestas de los jugadores. Los usuarios pueden realizar sus apuestas antes de que la rueda de la ruleta comience a girar, y una vez que la rueda se detenga, se calcularán los pagos correspondientes según los resultados.


Ahora pasamos a la distribución del proyecto.
Hemos dividido el Proyecto en 3 Branches Main (donde se encuentra el Index.html, un word con los requisitos y este archivo.txt) Diseño (donde esta el css y las imagenes utilizadas ) y codigo donde estan todo el codigo en javascript para que el programa funcione.

La instalación es muy sencilla descarga el repositorio mediante rar o en github desktop. Inicias VisualStudio y abres todos los repositorios en un mismo folder y ejecutas el archivo index.html.



Cuando ejecutas el index.html comienza el juego lo primero que te pide es seleeccionar el numero de participantes (entre 1 a 4) lo siguiente es añadir un nombre a los jugadores que se guardara para la clasificacion. Una vez añadido los nombres se añade un valor de creditos incial(Minimo 2) a cada jugador en juego.

Añadido el dinero a todos los jugadores comienza la apuesta del primer jugador, el cual elige cuantas fichas de 50,25,10,5,1 quiere apostar y a que casilla quiere. Una vez seleccionada la casilla se guarda la apuesta y el jugador puede hacer otra apuesta si quiere o pasar al siguiente jugador que repitera el mismo proceso y asi sucesivamente con todos los jugadores.

Otra opcion que tiene cada jugador es la de pasar turno y no apostar.

Cuando esten todas las apuestas realizadas se presiona un boton que da el resultado de la ruleta de forma totalmente aleatoria. Dependiendo del resultado los participantes podran recoger sus creditos multiplicados en base a que apostaron o no recoger nada porque no se cumplio su apuesta.

Se suman los creditos a los participantes y comienza otra ronda mas de la ruleta hasta que gane un jugador gane  porque sus contricantes se han quedado sin dinero.


Como se trata de un trabajo en grupo cada participante ha subido una parte de codigo para que funcione correctamente descargue el repositorio completo.
Disfrute del juego.
