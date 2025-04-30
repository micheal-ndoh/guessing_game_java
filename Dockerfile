ARG JAVA_VERSION=21
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine as builder

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF ./MANIFEST.MF

RUN mkdir bin
RUN javac -d bin $(find src -name "*.java")

RUN jar cfm GuessingGame.jar MANIFEST.MF -C bin .

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

WORKDIR /app

COPY --from=builder /app/GuessingGame.jar /app/GuessingGame.jar

CMD ["java", "-jar", "/app/GuessingGame.jar"]