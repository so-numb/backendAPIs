package com.fms.feedback.service;

import com.fms.feedback.model.Feedback;
import com.fms.feedback.model.LowRating;
import com.fms.feedback.model.Student;
import com.fms.feedback.model.Teacher;
import com.fms.feedback.model.request.FeedbackRequest;
import com.fms.feedback.model.request.GetTeacherRequest;
import com.fms.feedback.model.response.FeedbackResponse;

import java.util.List;

public interface FeedbackService {
    String registerTeacher(Teacher teacher);

    String registerStudent(Student student);

    List<Teacher> viewAllTeacher();

    List<Student> viewAllStudent();


    FeedbackResponse createFeedback(FeedbackRequest feedbackRequest);

    String deleteTeacher();

    String deleteStudent();

    List<Feedback> viewAllFeedback();

    String avgRating(String teacherName);

    List<LowRating> lowRating(String studentName);

    String deleteFeedbackById(String feedbackID);

    List<Teacher> getTeacherByTopics(GetTeacherRequest getTeacherRequest);
}
