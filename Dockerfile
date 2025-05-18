# Usa una imagen oficial de Java con Maven
FROM maven:17-eclipse-temurin AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usa una imagen más ligera para ejecutar la app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/comedor-app-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
