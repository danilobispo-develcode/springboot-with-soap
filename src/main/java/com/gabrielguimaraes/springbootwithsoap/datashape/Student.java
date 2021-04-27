package com.gabrielguimaraes.springbootwithsoap.datashape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    public Student(String name, String passportNumber) {
        super();
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, passportNumber=%s]", id, name, passportNumber);
    }
}
