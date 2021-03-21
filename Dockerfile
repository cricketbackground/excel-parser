FROM openjdk:jdk-14.0.2_12-alpine-slim

WORKDIR /app

COPY build/libs/excel-parser.jar excel-parser.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", "-jar", "excel-parser.jar"]
