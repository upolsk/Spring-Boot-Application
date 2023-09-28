package com.example.demo.course;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UniversityController {
    @Autowired
    private UniversityService universityService;
    @RequestMapping(path = "/students/{studentID}/universities")
    public List<University> getAllUniversities(@PathVariable Long studentID)
    {
        return universityService.getAllUniversities(studentID);
    }

    @RequestMapping("/students/{studentID}/universities/{id}")
    public University getUniversity(@PathVariable String id, @PathVariable String studentID)
    {
        return universityService.getUniversity(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students/{studentID}/universities")
    public void addUniversity(@RequestBody University university, @PathVariable Long studentID)
    {
        university.setStudent(new Student(studentID, "", "", 12));
        universityService.addUniversity(university);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/students/{studentID}/universities/{id}")
    public void updateUniversity(@RequestBody University university, @PathVariable Long studentID)
    {
        university.setStudent(new Student(studentID, "", "", 21));
        universityService.updateUniversity(university);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{studentID}/universities/{id}")
    public void deleteUniversity(@PathVariable String id, @PathVariable String studentID)
    {
        universityService.deleteUniversity(id);
    }
}
