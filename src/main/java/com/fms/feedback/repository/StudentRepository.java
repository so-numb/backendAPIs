package com.fms.feedback.repository;

import com.fms.feedback.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByContact(String contact);
    Student findByName(String name);
}
