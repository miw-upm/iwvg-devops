# Entorno de PRODUCCIÓN

# ==ETAPA 1: Construcción del JAR con Maven==
   # Imagen combinada: maven + jdk21 de eclipse
FROM maven:3.9.9-eclipse-temurin-21 AS build
   # Directorio de trabajo dentro del contenedor
WORKDIR /app
   # Solo se copia el pom.xml al directorio de trabajo
COPY pom.xml ./
   # Baja las dependencias sin conexión y en modo Batch (sin asistencia)
RUN mvn dependency:go-offline -B
   # Solo copia los fuentes java, NO los test
COPY src ./src
   # Limpia y empaqueta (se crea el *.jar)
RUN mvn clean package -DskipTests

# ==ETAPA 2: Configuración de la app Java ==
   # Contenedor solo con JRE, para hacerlo mas pequeño
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
   # Copia el archivo *jar generado en el contenedor de construcción
COPY --from=build /app/target/*.jar app.jar
   # Este contenedor escucha el puerto indicado
EXPOSE 8080
   # Define un comando para cuando se inicialice el contenedor en el host: java -jar app.jar
CMD ["java", "-jar", "app.jar"]


# ------------------------------------- COMANDOS ----------------------------------------------------------
# Construir la imagen, ATENCION!!! existe un punto al final que se debe incluir
#> docker build -t devops:latest .

# Crea y arrancar el contenedor a partir de la imagen
#> docker run -d --name devops1  -p 8080:8080 devops

# Arranca el contenedor
#> docker start devops1
