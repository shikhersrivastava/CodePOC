package com.example.demo1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentSer {

@Autowired
private StudentRepo studentRepo;


public String save(StudentDto studentDto)
{
    Student student=new Student();
    student.setAddress(studentDto.getAddress());
    student.setName(studentDto.getName());
    student.setMobileNo(studentDto.getMobileNo());
    student.setRollno(studentDto.getRollno());
   // student.setSalary(studentDto.getSalary());

    studentRepo.save(student);
    return "success";
}

public List<Student> getData()
{
    List<Student> students= studentRepo.findAll();


    System.out.println("Data hai={}"+students);
  //  students=students.stream().filter(c->c.getAddress().equalsIgnoreCase("AAB")).collect(Collectors.toList());
   /* Integer maxSalary = students.stream()
            .map(Student::getSalary)
            .min(Integer::compare).get();*/


 //   Optional<Student> obj=students.stream().sorted(Comparator.comparingDouble(Student::getSalary).reversed()).skip(2).findFirst();
    // System.out.println("Max salary::"+students
      //      .get());
    return students;
}


}

