# Quarkus Email Sender
This is a simple example of how to send an email using Quarkus and Gmail SMTP.

### Endpoint
```
POST localhost:8080/email
```
```json
{
  "email": "emailtosend@email.com",
  "subject": "Subject",
  "message": "Message"
}
```

### Configuration
You need to set the following application properties:
```properties
quarkus.mailer.username=<your_email>
quarkus.mailer.password=<your_password>
quarkus.mailer.from=<your_email>
```

### Run
```shell
./gradlew clean build
```
```shell
java -jar build/quarkus-app/quarkus-run.jar
```