Trabajo Práctico N° 2
Calculadora Distribuida Cliente-Servidor

Ejercicio 3: Análisis Teórico

Problema de reintentos simultáneos sin jitter

Cuando todos los clientes reintentan sus peticiones exactamente al mismo tiempo y con intervalos fijos, se produce el “Thundering Herd Problem” o Efecto Estampida.

Qué ocurre: miles de clientes golpean al servidor en el mismo instante.

Consecuencia: el servidor, ya saturado, recibe un pico de carga enorme y puede colapsar.

Solución: aplicar jitter (variación aleatoria en los tiempos de espera) para distribuir los reintentos en el tiempo y evitar que todos coincidan.

Diferencia entre fallo transitorio y fallo permanente


Fallo transitorio: es temporal y puede resolverse con reintentos.

Ejemplo: un microservicio en la nube que demora en responder por sobrecarga momentánea. Si el cliente reintenta más tarde, la petición puede tener éxito.

Fallo permanente: no se soluciona con reintentos, requiere intervención o cambios en la arquitectura.

Ejemplo: un servicio que dejó de existir porque la API fue retirada o el servidor está apagado definitivamente. Ningún reintento logrará conectarse.


captura de patntallas 

<img width="926" height="511" alt="Captura de pantalla 2026-09-03 203025" src="https://github.com/user-attachments/assets/75d3f3a1-26cf-456c-a8fe-08abfb0bc384" />
<img width="927" height="508" alt="Captura de pantalla 2026-09-03 203045" src="https://github.com/user-attachments/assets/8778e104-a0b5-4522-94a2-af990992a836" />


