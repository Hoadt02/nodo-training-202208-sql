package edu.hanoi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@javax.persistence.Entity
@Table(name="HN_GROUP",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="group_id")
    private List<User> users;

}
