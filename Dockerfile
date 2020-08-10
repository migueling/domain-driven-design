FROM openjdk:14-alpine
COPY build/libs/katas-*-all.jar katas.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "katas.jar"]