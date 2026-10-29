TRABAJO PRÁCTICO N° 3
Asignatura: Desarrollo de Aplicaciones para Ambientes Distribuidos
Unidad 2: Comunicación entre Procesos y Concurrencia
Tema: Sockets TCP/UDP con API java.net y Servidores Multihilo
Docente: Lic. Gabriel Artaza

3. Cuestionario Teórico
   Responder de forma concisa y fundamentada las siguientes preguntas:
1. Capa de Transporte: Explique las diferencias estructurales y operativas entre una
   comunicación orientada a conexión (TCP) y una sin conexión (UDP) en el contexto
   del paso de mensajes.

La capa de transporte de TCP (conexión) establece una conexión previa desde el emisor
al receptor esto garantiza una entrega confiable, ordenada y sin duplicados. 
Implementa control de flujo y congestión que garantizan la comunicación estable y confiable. 
ideal para aplicaciones donde la integridad de los datos es crítica ej transferencia de archivos, 
HTTP.

UDP (sin conexión) no requiere establecer conexión previa, cada mensaje es independiente no garantiza
la entrega ni orden, suelen existir pérdidas o duplicados como ventaja es más rápido y ligero, 
con, menor sobrecarga se usan en diferentes aplicaciones de tiempo real  por ejemplo en juegos 
online, streaming.


2. API java.net: ¿Cuál es la función del método ServerSocket.accept()?
   Justifique por qué es indispensable usar un hilo dedicado por cada cliente aceptado
   en un servidor TCP.


API java.net: ServerSocket.accept
este método bloque la ejecución hasta que un cliente solicita la conexión y devuelve un objeto 
socket que representa la conexión establecida con ese cliente se usa un hilo dedicado por cliente, 
cada cliente necesita ser atendido de forma independiente, si el servidor usará un único hilo, 
quedaría bloqueado atendiendo a un cliente y no podrá aceptar otros. con el multithreading, el servidor 
puede manejar múltiples clientes en paralelo, garantizando escalabilidad y respuesta inmediata.




3. Manejo de Errores y Resiliencia: ¿Qué sucede si el paquete UDP enviado por el
   emisor se pierde en la red? ¿Cómo lo detecta el receptor con setSoTimeout()?

Manejo de errores y resiliencia en UDP
Si un paquete UDP se pierde, el receptor nunca lo recibe porque UDP no tiene mecanismos de retransmisión
el receptor puede usar setSoTimeout() en socket esto define un tiempo máximo de espera para recibir un paquete.
Si el tiempo expira sin recibir nada, se lanza una excepción (SocketTimeoutException). 
Esto permite detectar la ausencia de respuesta y aplicar estrategias de resiliencia ejemplo en reintentar 
en vivo, notificar errores.




4. Criterios de Evaluación y Entregables
   ● Repositorio GitHub: Estructura limpia de carpetas (src/), commits significativos y
   código funcional.
   ● Archivo README.md: Debe contener las respuestas al cuestionario teórico, las
   instrucciones paso a paso para compilar y ejecutar los programas, y capturas
   demostrativas de al menos 3 clientes conectados simultáneamente al servidor TCP.
   ● Entrega en Classroom: Adjuntar únicamente la URL del repositorio


Ejercicio 1 - Chat Multihilo TCP
Ejecutar el servidor
Ejecutar:

ChatServer.java
El servidor escucha conexiones en el puerto 5000.


Ejecutar clientes
Abrir tres instancias de:

ChatClient.java
Cada cliente puede enviar mensajes que serán recibidos por los demás clientes conectados.




Ejercicio 2 - Comunicación UDP
Ejecutar receptor
Ejecutar:

UDPReceiver.java
El receptor queda escuchando datagramas en el puerto 6000.

Ejecutar emisor
Ejecutar:

UDPEmitter.java
El emisor envía periódicamente alertas UDP.