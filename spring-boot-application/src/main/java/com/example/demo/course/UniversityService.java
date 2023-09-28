package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    List<University> universities = new ArrayList<>(List.of(
            new University("1",
                    "ELTE",
                    "governmental",
                    1L
                      ),
            new University("2",
                    "Ala-Too",
                    "private",
                    2L
                    )
    ));

    public List<University> getAllUniversities(Long studentID)
    {
        List<University> universities = new ArrayList<>();
        universityRepository.findByStudentId(studentID).forEach(universities::add);
        return universities;
    }

    public University getUniversity(String id)
    {
        return universityRepository.findByName(id);
    }


    public void addUniversity(University university)
    {
//        universities.add(course);
        universityRepository.save(university);
    }


    public void updateUniversity(University university) {
//        for(int i = 0; i < universities.size(); i++)
//        {
//            Course s = universities.get(i);
//            if(s.getId() == id)
//            {
//                universities.set(i, course);
//                return;
//            }
//        }
        universityRepository.save(university);

    }

    public void deleteUniversity(String id) {
//        universities.removeIf(university -> university.getId() == id);
        universityRepository.deleteByName(id);
    }
}
