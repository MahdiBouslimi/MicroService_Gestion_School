package com.example.school;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_School", unique = true, nullable = false)
    private Integer id;
    private String name;
    private String email;
}
