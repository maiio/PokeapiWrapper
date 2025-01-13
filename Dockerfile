#Imagen base de java
FROM openjdk:17-jdk-slim AS build

#ARG JAR_FILE=build/libs/pokeapiwrapper-0.0.1.jar
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY . .

# Descargar e instalar Gradle
RUN apt-get update && apt-get install -y wget unzip \
    && wget https://services.gradle.org/distributions/gradle-7.6-bin.zip -P /tmp \
    && unzip /tmp/gradle-7.6-bin.zip -d /opt \
    && ln -s /opt/gradle-7.6/bin/gradle /usr/bin/gradle
    
# Construir el proyecto utilizando Gradle
RUN gradle build --no-daemon

# Imagen para la fase de ejecución
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado desde la fase de construcción
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Exponer el puerto en el que la aplicación Spring Boot estará escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]