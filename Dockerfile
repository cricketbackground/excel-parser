FROM openjdk:17-ea-14-jdk

WORKDIR /app

COPY build/libs/excel-parser.jar excel-parser.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", "-jar", "excel-parser.jar"]
