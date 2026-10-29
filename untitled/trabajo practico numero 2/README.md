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