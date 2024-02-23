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
```
GET localhost:8080/email
```
```json
[
  {
    "id": 1,
    "email": "example@example.com",
    "subject": "Subject",
    "message": "Message"
  }
]
```
```
GET localhost:8080/email/{id}
```
```json
{
  "id": 1,
  "email": "example@example.com",
  "subject": "Subject",
  "message": "Message"
}
```
```
DELETE localhost:8080/email/{id}
```
```
NoContent
```
```
GET localhost:8080/email/count
```
```json
1
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

