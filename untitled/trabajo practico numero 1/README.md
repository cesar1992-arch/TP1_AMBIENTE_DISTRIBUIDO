# Trabajo Práctico N° 1
## Calculadora Distribuida Cliente-Servidor

### Descripción

Este proyecto implementa una calculadora distribuida utilizando una arquitectura Cliente-Servidor y comunicación mediante sockets TCP en Java.

El Cliente solicita al usuario dos números enteros y una operación matemática (+, -, * o /). Luego envía los datos al Servidor mediante un Socket TCP.

El Servidor recibe los datos, realiza la operación correspondiente y devuelve el resultado al Cliente.

### Tecnologías utilizadas

- Java
- API java.net
- Socket TCP
- ServerSocket
- IntelliJ IDEA

### Puerto utilizado

El Servidor utiliza el puerto: 5500

### Ejecución del Servidor

Primero se debe ejecutar la clase `Servidor.java`.

El servidor queda esperando conexiones en el puerto 5500.

### Servidor en ejecución
<<<<<<< HEAD
<img width="1874" height="651" alt="Captura de pantalla 2026-08-20 195402" src="https://github.com/user-attachments/assets/77b3318c-8c40-457a-a531-680446b37d64" />


### Ejecución del Cliente


### Ejecución del Cliente

### Cliente en ejecución
![Cliente](../docs/Captura_de_panta_la_2026-08-20_183218.png)

>>>>>>> 3c9ec9e (Agrego TP2 con ClienteResiliente, ServidorInestable y README)
Luego se debe ejecutar la clase `Cliente.java`.

El Cliente solicita:
[out](../out)
1. Primer número.
2. Operación matemática.
3. Segundo número.

Los datos son enviados al Servidor con el siguiente formato: `15;+;30`

### Ejemplo de funcionamiento

Entrada: `2 + 2`

Resultado: `4`

### Cliente en ejecución

<img width="1889" height="688" alt="Captura de pantalla 2026-08-20 195542" src="https://github.com/user-attachments/assets/04612779-5505-4b2f-9935-af2dfa6d9a4a" />

### División por cero
Si el usuario intenta realizar una división por cero, el Servidor devuelve:

`ERROR: Division por cero`

### Servidor apagado
Si el Cliente intenta conectarse cuando el Servidor no está ejecutándose, se produce una 
`ConnectException` y se muestra un mensaje indicando que no se pudo establecer la conexión.

<img width="1844" height="476" alt="Captura de pantalla 2026-08-20 172646" src="https://github.com/user-attachments/assets/c0c2da54-a59a-4200-8d50-036516247dac" />

### Identifique en su código qué línea bloquea la ejecución del programa hasta que ocurre un evento de red.
El cliente se queda detenido en readLine() hasta que el servidor envíe una respuesta.
Mientras no llegue nada, el programa no avanza.

`String resultado = entrada.readLine();`

El servidor se queda detenido en accept() hasta que un cliente intente conectarse.
Mientras no haya conexión, el programa no avanza.

`Socket socket = servidor.accept();`

### Comunicación entre dos notebooks

Para ejecutar el Cliente y el Servidor en diferentes notebooks conectadas a la misma red Wi-Fi, se debe reemplazar `localhost` en el Cliente por la dirección IP de la notebook donde se ejecuta el Servidor.

También debe estar disponible el puerto 5500 y la comunicación no debe ser bloqueada por el firewall.
