FROM openjdk:17-slim as builder

WORKDIR /usr/src/app

COPY . .

RUN javac src/*.java -d out

FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app

COPY --from=builder /usr/src/app/out /usr/src/app

CMD ["java", "GuessingGame"]