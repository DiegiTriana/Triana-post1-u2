# creational-patterns

Proyecto- Unidad 2.
Se implementaron los patrones Singleton y Factory Method en Java usando Maven,
construyendo un sistema simple de notificaciones para un e-commerce.

## Que hace el proyecto

El sistema permite enviar notificaciones por distintos canales (email, SMS, push, slack)
y lleva un historial de todas las notificaciones enviadas durante la sesion.

## Patrones implementados

### Singleton
El problema era que necesitaba un solo objeto que guardara el historial de notificaciones
en toda la aplicacion. Si cada clase creara su propio logger, los registros quedarian
separados y no tendria un historial completo.

La solucion fue usar la variante enum de Singleton en la clase NotificationLogger.
La JVM garantiza que solo existe una instancia, y se accede siempre con
NotificationLogger.INSTANCE.

### Factory Method
El problema era que el codigo principal no deberia saber como se crea cada tipo
de notificador. Si usara directamente new EmailNotifier() o new SmsNotifier(),
agregar un canal nuevo obligaria a modificar ese codigo.

La solucion fue una factory con un Map que registra como crear cada tipo.
Para agregar un canal nuevo solo se llama NotifierFactory.register() sin tocar
la logica existente. Esto aplica el principio OCP.

## Como ejecutar

Requisitos: Java 17 y Maven 3.8 o superior.

\\\
mvn compile
mvn exec:java -Dexec.mainClass="com.patrones.u2.Main"
\\\

## Salida de la Main

\\\
![image alt](https://github.com/DiegiTriana/Triana-post1-u2/blob/bf7ab4d10400a32a0ef5d734461eb31d266abfc4/captura%20pantalla%20main%201.png)
\\\
