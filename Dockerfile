FROM eclipse-temurin:17-jre-jammy
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=data_loader", "-jar","/app.jar"]
