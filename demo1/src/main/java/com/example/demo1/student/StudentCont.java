package com.example.demo1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentCont {


    @Autowired
    private StudentSer studentSer;

    @PostMapping("/post")
    public String save(@RequestBody StudentDto studentDto)
    {
        String str=studentSer.save(studentDto);
        return str
                ;
    }

    @GetMapping("/getData")
    public List<Student> getData()
    {
        List<Student> students=studentSer.getData();
        return students;
    }

    @GetMapping("/saved")
    public String save()
    {
        return "shikher";
    }
}
