FROM eclipse-temurin:21-jdk
WORKDIR /src
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/src/app.jar"]