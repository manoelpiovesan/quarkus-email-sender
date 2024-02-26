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

### Build image
```shell
./gradlew clean build
```
```shell
docker build -f src/main/docker/Dockerfile.jvm -t manoelpiovesan/quarkus-email-sender-jvm .
```
### Configure environment variables in docker-compose.yml
```shell
      QUARKUS_MAILER_USERNAME: your_email@example.com
      QUARKUS_MAILER_FROM: your_email@example.com
      QUARKUS_MAILER_PASSWORD: your_password
```
### Configure environment variables in docker-swarm.yml
```shell
      QUARKUS_MAILER_USERNAME: your_email@example.com
      QUARKUS_MAILER_FROM: your_email@example.com
      QUARKUS_MAILER_PASSWORD: your_password
```

then, up the docker compose
```shell
docker compose up
```

