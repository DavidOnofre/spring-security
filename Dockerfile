# Especificar la imagen base de Java 11
FROM openjdk:11-jre-slim

# Copiar los archivos necesarios para la aplicación
COPY target/springBank-0.0.1-SNAPSHOT.jar /app/springBank-0.0.1-SNAPSHOT.jar

# Especificar el comando que se ejecutará al iniciar el contenedor
CMD ["java", "-jar", "/app/springBank-0.0.1-SNAPSHOT.jar"]
