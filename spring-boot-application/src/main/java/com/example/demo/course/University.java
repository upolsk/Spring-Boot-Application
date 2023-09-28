package com.example.demo.course;

//import com.example.demo.student.Student;
import com.example.demo.student.Student;
import jakarta.persistence.*;

@Entity
public class University {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne
    private Student student;


    public University() {
    }

    public University(String id, String name, String description, Long studentID) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.student = new Student(studentID, "Upol", "upolsk@gmail.com", 21);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

}
