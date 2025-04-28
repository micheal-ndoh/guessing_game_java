FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /usr/src/app

COPY src/ ./src/

RUN javac src/*.java -d out

FROM eclipse-temurin:17-jre-alpine

WORKDIR /usr/src/app

COPY --from=builder /usr/src/app/out /usr/src/app

CMD ["java", "GuessingGame"]