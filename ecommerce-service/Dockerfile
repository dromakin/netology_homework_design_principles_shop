FROM maven:3.8.2-jdk-8
EXPOSE 8081
WORKDIR /app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run