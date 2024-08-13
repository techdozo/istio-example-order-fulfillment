FROM eclipse-temurin:17-jre
RUN mkdir /app
WORKDIR /app

ADD ./build/libs/payment-svc-0.0.1.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
