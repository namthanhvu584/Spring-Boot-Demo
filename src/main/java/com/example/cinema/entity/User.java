package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    public static ElasticsearchConnectionDetails.Node builder() {
        return null;
    }

    public void setUsername(String username) {
    }

    public void setEmail(String email) {
    }

    public void setPassword(String encode) {
    }

    public void setRole(String roleUser) {
    }

    public String getRole() {
        return "";
    }

    public String getPassword() {
        return "";
    }

    public String getUsername() {
        return "";
    }
}
