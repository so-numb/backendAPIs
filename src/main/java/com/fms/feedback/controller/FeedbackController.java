package com.fms.feedback.controller;

import com.fms.feedback.model.Feedback;
import com.fms.feedback.model.LowRating;
import com.fms.feedback.model.Student;
import com.fms.feedback.model.Teacher;
import com.fms.feedback.model.request.FeedbackRequest;
import com.fms.feedback.model.request.GetTeacherRequest;
import com.fms.feedback.model.response.FeedbackResponse;
import com.fms.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institute")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/register/teacher")
    String registerTeacher(@RequestBody Teacher teacher){
        return feedbackService.registerTeacher(teacher);
    }
    @PostMapping("/register/student")
    String registerStudent(@RequestBody Student student){
        return feedbackService.registerStudent(student);
    }

    @GetMapping("/view_all/teacher")
    List<Teacher> viewAllTeacher(){
        return feedbackService.viewAllTeacher();
    }
    @GetMapping("/view_all/student")
    List<Student> viewAllStudent(){
        return feedbackService.viewAllStudent();
    }
    @GetMapping("/view_all/feedback")
    List<Feedback> viewAllFeedback(){
        return feedbackService.viewAllFeedback();
    }
    @PostMapping("/give/feedback")
    FeedbackResponse createFeedback(@RequestBody FeedbackRequest FeedbackRequest){
        return feedbackService.createFeedback(FeedbackRequest);
    }

    @DeleteMapping("/delete/teacher")
    String deleteTeacher(){
        return feedbackService.deleteTeacher();
    }
    @DeleteMapping("/delete/student")
    String deleteStudent(){
        return feedbackService.deleteStudent();
    }

    @GetMapping("/average/rating")
    String avgRating(String teacherName){
        return feedbackService.avgRating(teacherName);
    }

    @GetMapping("/low/rating")
    List<LowRating
            > lowRating(String studentName){
        return feedbackService.lowRating(studentName);
    }

    @DeleteMapping("/delete/feedback")
    String deleteFeedbackById(String feedbackID){
        return feedbackService.deleteFeedbackById(feedbackID);
    }


    @PostMapping("/list")
    List<Teacher> getTeacherByTopics(@RequestBody GetTeacherRequest getTeacherRequest) {
        return feedbackService.getTeacherByTopics(getTeacherRequest);

    }
}
