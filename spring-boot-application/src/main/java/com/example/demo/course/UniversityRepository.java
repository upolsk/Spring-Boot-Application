package com.example.demo.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepository extends CrudRepository<University, Long> {
    public List<University> findByStudentId(Long studentID);
    public University findByName(String id);
    public void deleteByName(String id);
}
