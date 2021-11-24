package com.example.demo1;

import com.example.demo1.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class project {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    @JsonIgnoreProperties("projectList")
    private Student student;
}
