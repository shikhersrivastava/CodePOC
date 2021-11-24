package com.example.demo1.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;
    private String rollno;
    private String address;
    private String mobileNo;

    //private Integer salary;

}
