package edu.hanoi.service.springhnservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HN_GROUP", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

}
