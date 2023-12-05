package com.fms.feedback.repository;

import com.fms.feedback.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    String findByName(String name);

    List<Teacher> findAllByTopicsIn(List<String> topicList);
}
