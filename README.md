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
### Edit application.properties
```properties
quarkus.mailer.username=<your_email>
quarkus.mailer.password=<your_password>
quarkus.mailer.from=<your_email>
```

### Build image
```shell
./gradlew clean build
```
```shell
docker build -f src/main/docker/Dockerfile.jvm -t manoelpiovesan/quarkus-email-sender-jvm .
```
then, up the docker compose
```shell
docker compose up
```

