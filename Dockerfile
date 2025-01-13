#
FROM openjdk:17-jdk-slim

ARG JAR_FILE=build/libs/pokeapiwrapper-0.0.1.jar

# Copiar el archivo JAR al contenedor
COPY ${JAR_FILE} app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]