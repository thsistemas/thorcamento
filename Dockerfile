FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/orcamento-0.0.1-SNAPSHOT.jar orcamento.jar
ENTRYPOINT ["java","-jar","/orcamento.jar"]