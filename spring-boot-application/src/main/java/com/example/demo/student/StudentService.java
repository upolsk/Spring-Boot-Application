package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    List<Student> students = new ArrayList<>(List.of(
            new Student(1L,
                    "Upol",
                    "upolsk@gmail.com",
                    21),
            new Student(2L,
                    "Asan",
                    "asansk@gmail.com",
                    21)
    ));

    public List<Student> getAllStudents()
    {
//        return students;
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);  //studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Student getStudent(Long id)
    {
//        return students.stream().filter(student -> student.getId() == id).findFirst().get();
        return studentRepository.findById(id).get();
    }


    public void addStudent(Student student)
    {
//        students.add(student);
        studentRepository.save(student);
    }


    public void updateStudent(Student student, Long id) {
//        for(int i = 0; i < students.size(); i++)
//        {
//            Student s = students.get(i);
//            if(s.getId() == id)
//            {
//                students.set(i, student);
//                return;
//            }
//        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
//        students.removeIf(student -> student.getId() == id);
        studentRepository.deleteById(id);
    }
}
