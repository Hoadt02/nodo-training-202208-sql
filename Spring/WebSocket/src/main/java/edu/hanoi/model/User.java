package edu.hanoi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HN_USER", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;
    @Column(name = "group_id", nullable = false)
    private Integer groupId;

}
