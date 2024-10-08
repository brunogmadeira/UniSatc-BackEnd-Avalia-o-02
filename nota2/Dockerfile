# Etapa 1: Construir a aplicação com Maven
FROM maven:3.8.4-openjdk-17 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e as dependências necessárias
COPY pom.xml ./
COPY src ./src

# Instalar as dependências e compilar a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Criar o ambiente de execução com JRE
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado da primeira etapa
COPY --from=build /app/target/*.jar app.jar

# Expor a porta padrão do Spring Boot (8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
