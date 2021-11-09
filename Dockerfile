FROM adoptopenjdk/openjdk8
COPY ./target/MailingSystem-1.0-SNAPSHOT.jar /usr/app/mailing.jar
ENTRYPOINT ["java", "-jar", "/usr/app/mailing.jar"]