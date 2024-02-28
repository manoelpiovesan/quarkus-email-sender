package io.github.manoelpiovesan.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.manoelpiovesan.enums.EmailStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Email extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, name = "email")
    public String email;

    @Column(name = "message", nullable = false, length = 1000)
    public String message;

    @Column(name = "subject", nullable = false, length = 100)
    public String subject;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt = LocalDateTime.now()
                                                  .atZone(java.time.ZoneId.of(
                                                          "America/Sao_Paulo"))
                                                  .toLocalDateTime();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public EmailStatus status = EmailStatus.PENDING;

}
