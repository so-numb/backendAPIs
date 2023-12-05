package com.fms.feedback.repository;

import com.fms.feedback.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findByTopicName(String topicName);
    List<Feedback> findByTopicTeacher(String teacherName);
    List<Feedback> findByStudentId(String studentId);
}
